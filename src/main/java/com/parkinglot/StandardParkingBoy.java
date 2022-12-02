package com.parkinglot;


import java.util.List;




public class StandardParkingBoy {

    private List<ParkingLot> parkingLot;

    public StandardParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLot = parkingLots;
    }



    public  Ticket park(Car car)
    {
        return parkingLot.stream()
                .filter(parkingLot -> parkingLot.getAvailablePositionCount() > 0)
                .findFirst()
                .orElseThrow(() -> new NoAvailablePosition("No available position"))
                .park(car);
    }

    public Car getCar(Ticket ticket) {
        return parkingLot.stream()
                .filter(parkingLot -> parkingLot.isContainCar(ticket))
                .findFirst()
                .orElseThrow(() -> new UnrecognizedParkingTicketException("Unrecognized Parking Ticket"))
                .getCar(ticket);
    }
}
