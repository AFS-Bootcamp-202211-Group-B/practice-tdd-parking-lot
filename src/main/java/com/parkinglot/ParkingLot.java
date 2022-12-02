package com.parkinglot;

import java.util.HashMap;

public class ParkingLot {
    private static HashMap<Ticket, Car> ticketCarHashMap = new HashMap<>();
    public static Ticket park(Car car) {

        Ticket ticket = new Ticket();
        ticketCarHashMap.put(ticket,car);
        return  ticket;
    }

    public Car getCar(Ticket ticket) {
        Car car = ticketCarHashMap.remove(ticket);

        if (car != null)
        {
            return car;
        }
        return null;
    }
}
