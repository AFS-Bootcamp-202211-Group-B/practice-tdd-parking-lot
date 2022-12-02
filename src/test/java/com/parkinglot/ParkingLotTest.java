package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingLotTest {
    @Test
    void should_return_Ticket_when_Park_given_ParkLot_and_Car(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car=new Car();
        //when
        Ticket ticket = parkingLot.park(car);

        //then
        assertNotNull(ticket);
    }
}
