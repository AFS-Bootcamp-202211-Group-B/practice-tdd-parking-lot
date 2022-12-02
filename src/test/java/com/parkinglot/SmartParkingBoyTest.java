package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SmartParkingBoyTest {
    @Test
    void should_return_ticket_from_first_parkingLot_when_park_given_two_available_parkingLots_where_parkingLots1_has_the_most_space_and_car(){
        //given
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        for(int i=0;i<3;i++){
            parkingLot2.park(new Car());
        }
        ParkingBoy smartParkingBoy = new SmartParkingBoy(Arrays.asList(parkingLot1, parkingLot2));

        Car car = new Car();
        //when
        Ticket ticket = smartParkingBoy.park(car);

        //then
        assertTrue(parkingLot1.has(ticket));
    }
    @Test
    void should_return_ticket_from_first_parkingLot_when_park_given_two_available_parkingLots_where_parkingLots2_has_the_most_space_and_car(){
        //given
        ParkingLot parkingLot1 = new ParkingLot();
        for(int i=0;i<3;i++){
            parkingLot1.park(new Car());
        }
        ParkingLot parkingLot2 = new ParkingLot();

        ParkingBoy smartParkingBoy = new SmartParkingBoy(Arrays.asList(parkingLot1, parkingLot2));

        Car car = new Car();
        //when
        Ticket ticket = smartParkingBoy.park(car);

        //then
        assertTrue(parkingLot2.has(ticket));
    }

}