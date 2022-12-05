package com.parkinglot;

import java.util.List;
import java.util.NoSuchElementException;

public class ParkingLotManager extends StandardParkingBoy {

    private List<StandardParkingBoy> parkingBoys;


    public ParkingLotManager(List<ParkingLot> parkingLot, List<StandardParkingBoy> parkingBoys) {
        super(parkingLot);
        this.parkingBoys = parkingBoys;
    }


    public Car getCar(StandardParkingBoy parkingBoy, Ticket ticket) {
        try
        {
            if (parkingBoys.contains(parkingBoy)) {
                return parkingBoy.getCar(ticket);
            }
        }
        catch (UnrecognizedParkingTicketException unrecognizedParkingTicketException)
        {
            throw new UnrecognizedParkingTicketException("Unrecognized Parking Ticket");
        }
        return null;
    }


    public Ticket park(StandardParkingBoy parkingBoy, Car car) {
        try {
            if (parkingBoys.contains(parkingBoy)) {
                return parkingBoy.park(car);
            }

        } catch (NoAvailablePosition exception) {
            throw new NoAvailablePosition("No available position");
        }
        return null; // throw exception~, not suggested to return null -> NullPointExcep
    }
}
