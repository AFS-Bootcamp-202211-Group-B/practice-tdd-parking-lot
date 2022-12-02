package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Map<Ticket, Car> parkedPosition = new HashMap<>();
    private int capacity;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public ParkingLot() {
        this.capacity = 10;
    }

    public Ticket park(Car car) {
        if (parkedPosition.size() >= capacity)
            return null;
        Ticket ticket = new Ticket();
        parkedPosition.put(ticket, car);
        return ticket;
    }

    public Car fetch(Ticket ticket) {
        Car car = parkedPosition.get(ticket);
        parkedPosition.remove(ticket);
        return car;
    }
}
