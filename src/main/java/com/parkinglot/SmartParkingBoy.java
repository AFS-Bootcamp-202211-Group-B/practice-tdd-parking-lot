package com.parkinglot;

import java.util.ArrayList;

public class SmartParkingBoy extends StandardParkingBoy{

    public SmartParkingBoy(ParkingLot parkingLot){
        super(parkingLot);
    }

    @Override
    public ParkingTicket park(Car car){
        ParkingLot parkingLot = checkMoreEmptyPosition();
        if(parkingLot==null) {
            throw new NoAvailablePositionException();
        }
        else{
            return parkingLot.park(car);
        }
    }

    public ParkingLot checkMoreEmptyPosition(){
        int empty =0;
        ParkingLot res = null;
        for(ParkingLot parkingLot:  parkingLotList) {
            if(parkingLot.getEmptyPosition() > empty){
                res = parkingLot;
                empty = parkingLot.getEmptyPosition();
            }
        }
        return res;
    }


}
