package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {
    @Test
    void should_return_ticket_when_park_given_a_parkingLot() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        //when
        Ticket actual = parkingLot.park(car);
        //then
        assertNotNull(actual);
    }
    @Test
    void should_return_parked_car_when_fetch_given_a_Ticket_and_a_Car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Ticket ticket = new Ticket();
        //when
        Car actual = parkingLot.fetch(ticket);
        //then
        assertNotNull(actual);
    }
    
}
