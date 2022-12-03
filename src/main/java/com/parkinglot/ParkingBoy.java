package com.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {
    ParkBehaviour parkBehaviour;
    FetchBehaviour fetchBehaviour;
    protected final List<ParkingLot> parkingLots;
    public ParkingBoy(ParkingLot parkingLot) {
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        this.parkingLots = parkingLots;
    }

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car){
        return parkBehaviour.park(car);
    }

    public Car fetch(Ticket ticket){
        return fetchBehaviour.fetch(ticket);
    }

}
