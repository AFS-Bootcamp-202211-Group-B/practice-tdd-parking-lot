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
    @Test
    void should_return_second_parkingLot_ticket_when_SmartParkingBoy_park_given_second_parkingLot_has_more_space() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(5);
        ParkingLot parkingLot2 = new ParkingLot(10);
        Car car = new Car();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(new ArrayList<>(Arrays.asList(parkingLot1, parkingLot2)));
        //when
        Ticket actual = smartParkingBoy.park(car);
        //then
        assertFalse(parkingLot1.hasTicket(actual));
        assertTrue(parkingLot2.hasTicket(actual));
    }
    @Test
    void should_return_first_parkingLot_ticket_when_SmartParkingBoy_park_given_parkingLots_have_same_space() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(5);
        ParkingLot parkingLot2 = new ParkingLot(5);
        Car car = new Car();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(new ArrayList<>(Arrays.asList(parkingLot1, parkingLot2)));
        //when
        Ticket actual = smartParkingBoy.park(car);
        //then
        assertTrue(parkingLot1.hasTicket(actual));
        assertFalse(parkingLot2.hasTicket(actual));
    }
    @Test
    void should_NoAvailablePositionException_when_SmartParkingBoy_park_given_parkingLots_full() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        Car car1 = new Car();
        Car car2 = new Car();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(new ArrayList<>(Arrays.asList(parkingLot1, parkingLot2)));
        smartParkingBoy.park(car1);
        smartParkingBoy.park(car2);

        Car newCar = new Car();
        //then
        Exception exception = assertThrows(NoAvailablePositionException.class, () -> {
            smartParkingBoy.park(newCar);
        });
        assertEquals("No available position.", exception.getMessage());
    }
    @Test
    void should_return_parked_car_when_fetch_given_parkingLot_and_smart_parked_boy() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(new ArrayList<>(Arrays.asList(parkingLot)));
        Car car = new Car();
        Ticket ticket = smartParkingBoy.park(car);
        //when
        Car actual = smartParkingBoy.fetch(ticket);
        //then
        assertEquals(car, actual);
    }
    @Test
    void should_return_return_the_right_car_with_each_ticket_when_fetch_twice_given_two_parked_cars_a_smart_parking_boy_and_two_parking_ticket() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(5);
        ParkingLot parkingLot2 = new ParkingLot(5);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(new ArrayList<>(Arrays.asList(parkingLot1, parkingLot2)));
        Car car1 = new Car();
        Ticket ticket1 = smartParkingBoy.park(car1);
        Car car2 = new Car();
        Ticket ticket2 = smartParkingBoy.park(car2);
        //when
        Car actual1 = smartParkingBoy.fetch(ticket1);
        Car actual2 = smartParkingBoy.fetch(ticket2);
        //then
        assertEquals(car1, actual1);
        assertEquals(car2, actual2);
    }
}
