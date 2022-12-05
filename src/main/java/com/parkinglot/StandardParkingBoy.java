package com.parkinglot;

import java.util.ArrayList;

public class StandardParkingBoy {
    protected ArrayList<ParkingLot> parkingLotList;

    public StandardParkingBoy(ParkingLot parkingLot){
        parkingLotList = new ArrayList<>();
        parkingLotList.add(parkingLot);
    }

    public ParkingTicket park(Car car){
        for(ParkingLot parkingLot:  parkingLotList){
        //    if(parkingLot.checkAvailable())
            try {
                return parkingLot.park(car);
            }
            catch(NoAvailablePositionException e){}
        }
        throw new NoAvailablePositionException();
    }

    public Car fetch(ParkingTicket ticket) {
        for(ParkingLot parkingLot:  parkingLotList){
        //    if(!parkingLot.isUnrecognizeedTicket(ticket))
            try {
                return parkingLot.fetch(ticket);
            }
            catch(UnrecognizeedTicketException e){}

        }
        throw new UnrecognizeedTicketException();
    }

    public void addParkingLot(ParkingLot parkingLot) {
        parkingLotList.add(parkingLot);
    }
}
