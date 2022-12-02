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
        for (ParkingLot parkingLot : parkingLotList) {
            try {
                Ticket ticket = parkingLot.park(car);
                if (ticket != null)
                    return ticket;
            } catch (NoAvailablePositionException e) {
                continue;
            }
        }
        throw new NoAvailablePositionException();
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
