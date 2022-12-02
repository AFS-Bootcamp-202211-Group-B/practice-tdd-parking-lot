package com.parkinglot;

public class StandardParkingBoy {
    private ParkingLot parkingLot;

    public StandardParkingBoy(ParkingLot parkingLot){
        this.parkingLot = parkingLot;
    }

    public ParkingTicket park(Car car){
        return this.parkingLot.park(car);
    }

    public Car fetch(ParkingTicket ticket) {
        return this.parkingLot.fetch(ticket);
    }

}
