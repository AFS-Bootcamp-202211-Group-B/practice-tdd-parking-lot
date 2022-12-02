package com.parkinglot;

import java.util.HashMap;

public class ParkingLot {

    private HashMap<Ticket, Car> ticketCarHashMap = new HashMap<>();

    private final int capacity;

    public ParkingLot(int capacity)
    {
        this.capacity = capacity;
    }

    public ParkingLot()
    {
        this.capacity = 10;
    }
    public  Ticket park(Car car) {
        if (ticketCarHashMap.size() >= capacity) throw new NoAvailablePosition("No available position");;
        Ticket ticket = new Ticket();
        ticketCarHashMap.put(ticket,car);
        return  ticket;
    }

    public Car getCar(Ticket ticket) {
        Car car =  ticketCarHashMap.remove(ticket);

        if (car != null){
            return car;
        }

        throw new UnrecognizedParkingTicketException("Unrecognized Parking Ticket");
    }
}
