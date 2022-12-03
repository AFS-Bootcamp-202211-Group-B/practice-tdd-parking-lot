package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SmartParkingBoyTest {

    @Test
    void should_return_second_parking_lot_ticket_when_park_car_given_second_parking_lot_more_position_than_first_one(){
        //given
        ParkingLot parkingLot = new ParkingLot(3);
        ParkingLot parkingLot2 = new ParkingLot(5);
        //when
        Car bob = new Car();
        SmartParkingBoy parkingBoy = new SmartParkingBoy(parkingLot);
        parkingBoy.addParkingLot(parkingLot2);
        parkingBoy.park(bob);

        //then
        assertEquals(4, parkingLot2.getEmptyPosition());
    }



}
