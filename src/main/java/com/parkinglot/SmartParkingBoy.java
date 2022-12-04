package com.parkinglot;

import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy {
    List<ParkingLot> parkingLotList;

    public SmartParkingBoy(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }
    public Ticket park(Car car) {
        ParkingLot parkingLot = findParkingLotWithMorePositions();
        return parkingLot.park(car);
    }
    public ParkingLot findParkingLotWithMorePositions() {
        return this.parkingLotList.stream()
            .max(Comparator.comparing(ParkingLot::getRemainingPositions))
            .orElseThrow(NoAvailablePositionException::new);
    }
}
