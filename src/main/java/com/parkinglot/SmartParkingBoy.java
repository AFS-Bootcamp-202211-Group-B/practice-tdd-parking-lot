package com.parkinglot;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SmartParkingBoy extends ParkingBoy{

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }
    public Ticket park(Car car) {
        List<ParkingLot> notFullParkingLots = parkingLots.stream()
                .filter(parkingLot -> !parkingLot.isFull())
                .collect(Collectors.toList());
        ParkingLot morePositionParkingLot = notFullParkingLots.stream()
                .min(Comparator.comparingInt(parkingLot -> parkingLot.getParkedCar().size()))
                .orElseThrow(noAnyPositionException::new);
        return morePositionParkingLot.park(car);
    }

    public Car fetch(Ticket ticket) {
        ParkingLot fetchToParkingLot = parkingLots.stream()
                .filter(parkingLot -> !parkingLot.isUnrecognizedTicket(ticket))
                .findFirst()
                .orElseThrow(unrecognizedTicketException::new);
        return fetchToParkingLot.fetch(ticket);
    }
}
