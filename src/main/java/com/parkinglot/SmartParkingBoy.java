package com.parkinglot;

import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy extends ParkingBoy{


    public SmartParkingBoy(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
    }

    public Ticket park(Car car) {
        ParkingLot availableParkingLot = super.parkingLots.stream()
                .sorted(Comparator.comparing(ParkingLot::getRemainingSpace).reversed())
                .findFirst()
                .get();
        return availableParkingLot.park(car);
    }
}
