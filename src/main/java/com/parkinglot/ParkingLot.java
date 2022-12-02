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
            throw new FullParkingLotException("No available position.");
        }
        Ticket ticket = new Ticket();
        parkedCar.put(ticket, car);
        return ticket;
    }


    public Car fetch(Ticket ticket) {
        Car returnCar = parkedCar.get(ticket);
        if(returnCar==null){
            throw new UnrecognizedParkingTicketException("Unrecognized parking ticket.");
        }
        parkedCar.remove(ticket);
        return returnCar;
    }

    public boolean has(Ticket ticket) {
        return !(parkedCar.get(ticket)==null);
    }
}
