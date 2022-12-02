package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Map<Ticket, Car> carTicketMap = new HashMap<>();

    public Ticket park(Car car) {
        Ticket ticket = new Ticket();
        carTicketMap.put(ticket, car);
        return ticket;
    }

    public Car fetch(Ticket ticket) {
        Car parkedCar = carTicketMap.get(ticket);
        return parkedCar;
    }
}
