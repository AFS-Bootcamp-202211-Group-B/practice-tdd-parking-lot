package com.parkinglot;

import java.util.ArrayList;
import java.util.List;


public class StandardParkingBoy extends ParkingBoy{

    public StandardParkingBoy(ParkingLot parkingLot) {
        super(parkingLot);
    }
    public StandardParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }
    @Override
    public Ticket park(Car car) {
        ParkBehaviour sequentialPark = new SequentialPark(parkingLots);
        return sequentialPark.park(car);

    }
    @Override
    public Car fetch(Ticket ticket) {
        FetchBehaviour simpleFetch = new SimpleFetch(parkingLots);
        return simpleFetch.fetch(ticket);
    }
}
