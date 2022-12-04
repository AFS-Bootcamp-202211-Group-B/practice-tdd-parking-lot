package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SmartParkingBoyTest {
    @Test
    void should_return_first_parkingLot_ticket_when_SmartParkingBoy_park_given_first_parkingLot_has_more_space() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(10);
        ParkingLot parkingLot2 = new ParkingLot(5);
        Car car = new Car();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(new ArrayList<>(Arrays.asList(parkingLot1, parkingLot2)));
        //when
        Ticket actual = smartParkingBoy.park(car);
        //then
        assertTrue(parkingLot1.hasTicket(actual));
        assertFalse(parkingLot2.hasTicket(actual));
    }
    
}
