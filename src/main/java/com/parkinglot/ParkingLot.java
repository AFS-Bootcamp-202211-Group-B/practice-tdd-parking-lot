package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Map<Car, Ticket> carTicketMap = new HashMap<>();

    public Ticket park(Car car) {
        Ticket ticket = new Ticket();
        carTicketMap.put(car, ticket);
        return ticket;
    }
}
