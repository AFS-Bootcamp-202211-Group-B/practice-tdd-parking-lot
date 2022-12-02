package com.parkinglot;

public class StandardParkingBoy {
    private ParkingLot parkingLot;

    public StandardParkingBoy(ParkingLot parkingLot){
        this.parkingLot = parkingLot;
    }

    public ParkingTicket park(Car car){
        return this.parkingLot.park(car);
    }

<<<<<<< HEAD
    public Car fetch(ParkingTicket ticket) {
        return this.parkingLot.fetch(ticket);
    }


=======
>>>>>>> e912361fc3fc5a52c73dc3fa84e3bd7f98552d7e
}
