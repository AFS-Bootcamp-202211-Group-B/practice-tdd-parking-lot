package com.parkinglot;


import java.util.List;

public class SmartParkingBoy extends ParkingBoy{

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }
    public Ticket park(Car car) {
        ParkBehaviour morePositionPark = new MorePositionPark(parkingLots);
        return morePositionPark.park(car);
    }

    public Car fetch(Ticket ticket) {
        FetchBehaviour simpleFetch = new SimpleFetch(parkingLots);
        return simpleFetch.fetch(ticket);
    }
}
