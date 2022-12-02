package com.parkinglot;


public class StandardParkingBoy {

    private  ParkingLot parkingLot;

    public StandardParkingBoy(ParkingLot parkingLot){
        this.parkingLot = parkingLot;
    }

    public  Ticket park(Car car)
    {
        return  this.parkingLot.park(car);
    }

    public Car getCar(Ticket ticket) { return  this.parkingLot.getCar(ticket);
    }
}
