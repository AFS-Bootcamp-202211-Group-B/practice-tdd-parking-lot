package com.parkinglot;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MorePositionPark implements ParkBehaviour {
    private final List<ParkingLot> parkingLots;

    public MorePositionPark(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
    public Ticket park(Car car) {
        List<ParkingLot> notFullParkingLots = parkingLots.stream()
                .filter(parkingLot -> !parkingLot.isFull())
                .collect(Collectors.toList());
        ParkingLot morePositionParkingLot = notFullParkingLots.stream()
                .min(Comparator.comparingInt(parkingLot -> parkingLot.getParkedCar().size()))
                .orElseThrow(noAnyPositionException::new);
        return morePositionParkingLot.park(car);
    }
}
