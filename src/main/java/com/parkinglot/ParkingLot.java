package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private Map<ParkingTicket, Car> parkedPosition = new HashMap<>();

    public ParkingTicket park(Car car){
        ParkingTicket ticket = new ParkingTicket();
        parkedPosition.put(ticket,car);
        return ticket;
    }

    public Car fetch(ParkingTicket ticket){
        return parkedPosition.get(ticket);
    }



}
