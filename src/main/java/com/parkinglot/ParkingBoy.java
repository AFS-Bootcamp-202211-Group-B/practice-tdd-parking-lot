package com.parkinglot;

import java.util.Arrays;
import java.util.List;

public class ParkingBoy {
    protected List<ParkingLot> parkingLots;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLots= Arrays.asList(parkingLot);
    }
    public ParkingBoy(List<ParkingLot> parkingLotList){
        this.parkingLots=parkingLotList;
    }

    public Ticket park(Car car) {
        for(ParkingLot parkingLot:this.parkingLots){
            try {
                Ticket returnTicket = parkingLot.park(car);
                return returnTicket;
            }catch(FullParkingLotException e){}
        }
        throw new FullParkingLotException("No available position.");
    }

    public Car fetch(Ticket ticket) {
        for(ParkingLot parkingLot:this.parkingLots){
            try {
                Car returnCar = parkingLot.fetch(ticket);
                return returnCar;
            }catch(UnrecognizedParkingTicketException e){}
        }
        throw new UnrecognizedParkingTicketException("Unrecognized parking ticket.");
    }
}
