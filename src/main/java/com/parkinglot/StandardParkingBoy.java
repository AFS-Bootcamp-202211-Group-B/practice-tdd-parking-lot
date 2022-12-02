package com.parkinglot;

import java.util.Arrays;
import java.util.List;

public class StandardParkingBoy {
    private List<ParkingLot> parkingLotList;

    public StandardParkingBoy(ParkingLot parkingLot) {
        parkingLotList = Arrays.asList(parkingLot);
    }

    public StandardParkingBoy(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    public Ticket park(Car car) {
        for (ParkingLot parkingLot : parkingLotList) {
            try {
                Ticket ticket = parkingLot.park(car);
                if (ticket != null)
                    return ticket;
            } catch (NoAvailablePositionException e) {
                continue;
            }
        }
        return null;
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
        return null;
    }
}
