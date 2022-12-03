package com.parkinglot;

import java.util.List;

public class SequentialPark implements ParkBehaviour{
    private final List<ParkingLot> parkingLots;

    public SequentialPark(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
    public Ticket park(Car car) {
        ParkingLot notFullParkingLot = parkingLots.stream()
                .filter(parkingLot -> !parkingLot.isFull())
                .findFirst()
                .orElseThrow(NoAnyPositionException::new);
        return notFullParkingLot.park(car);
    }
}
