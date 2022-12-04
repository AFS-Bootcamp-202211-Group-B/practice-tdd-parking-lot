package com.parkinglot;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SmartParkingBoy {
    List<ParkingLot> parkingLotList;

    public SmartParkingBoy(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }
    public Ticket park(Car car) {
        ParkingLot parkingLot = findParkingLotWithMorePositions();
        return parkingLot.park(car);
    }
    public ParkingLot findParkingLotWithMorePositions() {
        return this.parkingLotList.stream()
            .max(Comparator.comparing(ParkingLot::getRemainingPositions))
            .orElseThrow(NoAvailablePositionException::new);
    }
    public Car fetch(Ticket ticket) {
        return findParkingLoContainsTicket(ticket).fetch(ticket);
    }
    private ParkingLot findParkingLoContainsTicket(Ticket ticket) throws UnrecognizedMessageException{
        Optional<ParkingLot> parkingLot = this.parkingLotList.stream()
            .filter( p -> p.hasTicket(ticket))
            .findAny();
        if(parkingLot.isPresent()){
            return parkingLot.get();
        }
        else{
            throw new UnrecognizedMessageException();
        }
    }
}
