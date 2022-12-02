package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final int capacity;
    private Map<Ticket,Car> parkedCar = new HashMap<>();

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public Ticket park(Car car) {
        if(this.parkedCar.size() < capacity){
            Ticket ticket = new Ticket();
            this.parkedCar.put(ticket,car);
            return ticket;
        }
        return null;
    }
    public Car fetch(Ticket ticket) {
        Car fetchCar = this.parkedCar.get(ticket);
        this.parkedCar.remove(ticket);
        return fetchCar;
    }
}
