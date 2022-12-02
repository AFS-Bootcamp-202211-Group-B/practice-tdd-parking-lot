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
        Car parkedCar = new Car();
        Ticket ticket = parkingLot.park(parkedCar);
        //when
        Car actual = parkingLot.fetch(ticket);
        //then
        assertEquals(parkedCar, actual);
    }
    @Test
    void should_return_right_car_with_each_ticket_when_fetch_twice_given_two_tickets_and_two_parked_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car parkedCar1 = new Car();
        Car parkedCar2 = new Car();
        Ticket ticket1 = parkingLot.park(parkedCar1);
        Ticket ticket2 = parkingLot.park(parkedCar2);
        //when
        Car actualCar1 = parkingLot.fetch(ticket1);
        Car actualCar2 = parkingLot.fetch(ticket2);
        //then
        assertEquals(parkedCar1, actualCar1);
        assertEquals(parkedCar2, actualCar2);
    }
    @Test
    void should_return_nothing_when_fetch_twice_given_wrong_tickets() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Ticket ticket = new Ticket();
        //when
        Car actual = parkingLot.fetch(ticket);
        //then
        assertNull(actual);
    }
    
}
