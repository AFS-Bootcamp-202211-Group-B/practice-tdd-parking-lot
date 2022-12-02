package com.parkinglot;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StandardParkingBoy {
    private final List<ParkingLot> parkingLots;
    public StandardParkingBoy(ParkingLot parkingLot) {
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        this.parkingLots = parkingLots;
    }
    public StandardParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car) {
        ParkingLot notFullParkingLot = parkingLots.stream()
                .filter(parkingLot -> !parkingLot.isFull())
                .findFirst()
                .orElseThrow(noAnyPositionException::new);
        return notFullParkingLot.park(car);
    }

    public Car fetch(Ticket ticket) {
        ParkingLot fetchToParkingLot = parkingLots.stream()
                .filter(parkingLot -> !parkingLot.isUnrecognizedTicket(ticket))
                .findFirst()
                .orElseThrow(unrecognizedTicketException::new);
        return fetchToParkingLot.fetch(ticket);
    }
}
