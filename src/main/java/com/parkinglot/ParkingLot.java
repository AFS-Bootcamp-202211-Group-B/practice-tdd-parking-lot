package com.parkinglot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    private Map<Ticket, Car> parkedCar = new HashMap<>();


    private int size;

    public ParkingLot() {
        this.size = 10;
    }

    public Ticket park(Car car) {
        if(this.parkedCar.size()>=this.size) {
            return null;
        }
        Ticket ticket = new Ticket();
        parkedCar.put(ticket, car);
        return ticket;
    }


    public Car fetch(Ticket ticket) {
        Car returnCar = parkedCar.get(ticket);
        parkedCar.remove(ticket);
        return returnCar;
    }
}
