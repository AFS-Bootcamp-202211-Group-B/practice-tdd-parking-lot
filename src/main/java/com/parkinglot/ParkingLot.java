package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private Map<ParkingTicket, Car> parkedPosition = new HashMap<>();
    private int capacity;

    public ParkingLot(int capacity){
        this.capacity = capacity;
    }

    public ParkingTicket park(Car car){
        if(parkedPosition.size() >= capacity){
            throw new NoAvailablePositionException();
        }
        ParkingTicket ticket = new ParkingTicket();
        parkedPosition.put(ticket,car);
        return ticket;
    }

    public Car fetch(ParkingTicket ticket){
        if(isUnrecognizeedTicket(ticket)){
            throw new UnrecognizeedTicketException();
        }
        Car tmp = parkedPosition.get(ticket);
        parkedPosition.remove(ticket);
        return tmp;
    }

    private boolean isUnrecognizeedTicket(ParkingTicket ticket){
        return !parkedPosition.containsKey(ticket);
    }



}
