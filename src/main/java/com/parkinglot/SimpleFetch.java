package com.parkinglot;

import java.util.List;

public class SimpleFetch implements FetchBehaviour{
    private final List<ParkingLot> parkingLots;

    public SimpleFetch(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
    public Car fetch(Ticket ticket) {
        ParkingLot fetchToParkingLot = parkingLots.stream()
                .filter(parkingLot -> !parkingLot.isUnrecognizedTicket(ticket))
                .findFirst()
                .orElseThrow(unrecognizedTicketException::new);
        return fetchToParkingLot.fetch(ticket);
    }
}
