package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Map<Ticket, Car> carTicketMap = new HashMap<>();
    private final int capacity;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public Ticket park(Car car) {
        if(carTicketMap.size() == this.capacity){
            return null;
        }
        Ticket ticket = new Ticket();
        carTicketMap.put(ticket, car);
        return ticket;
    }

    public Car fetch(Ticket ticket) {
        Car parkedCar = carTicketMap.get(ticket);
        carTicketMap.remove(ticket);
        return parkedCar;
    }
}
