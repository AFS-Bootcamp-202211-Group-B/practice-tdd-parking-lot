package com.parkinglot;

import java.util.Arrays;
import java.util.List;

public class SmartParkingBoy {
    private List<ParkingLot> parkingLotList;

    public SmartParkingBoy(ParkingLot parkingLot) {
        parkingLotList = Arrays.asList(parkingLot);
    }

    public SmartParkingBoy(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    public Ticket park(Car car) {
        ParkingLot toPark = null;
        int availablePositions = 0;
        for (ParkingLot parkingLot : parkingLotList) {
            int currentAvailablePositions = parkingLot.countAvailablePositions();
            if (currentAvailablePositions > availablePositions) {
                availablePositions = currentAvailablePositions;
                toPark = parkingLot;
            }
        }
        if (toPark == null)
            throw new NoAvailablePositionException();
        return toPark.park(car);
    }

    public Car fetch(Ticket ticket) {
        for (ParkingLot parkingLot : parkingLotList) {
            try {
                Car car = parkingLot.fetch(ticket);
                if (car != null)
                    return car;
            } catch (UnrecognizedTicketException e) {
                continue;
            }
        }
        throw new UnrecognizedTicketException();
    }
}
