package com.parkinglot;

import java.util.HashMap;

public class ParkingLot {
    private HashMap<Ticket, Car> ticketCarHashMap = new HashMap<>();
    public  Ticket park(Car car) {

        Ticket ticket = new Ticket();
        ticketCarHashMap.put(ticket,car);
        return  ticket;
    }

    public Car getCar(Ticket ticket) {
        return ticketCarHashMap.get(ticket);

    }
}
