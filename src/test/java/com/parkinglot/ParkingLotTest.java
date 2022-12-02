package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {
    @Test
    void should_return_a_ticket_when_park_given_a_car() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        //when
        Ticket ticket = parkingLot.park(car);
        //then
        assertNotNull(ticket);
    }

    @Test
    void should_return_parked_car_when_fetch_given_a_parked_car() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);
        //when
        Car fetchedCar = parkingLot.fetch(ticket);
        //then
        assertEquals(car, fetchedCar);
    }

    @Test
    void should_return_right_car_when_fetch_twice_given_2_parked_cars() {
        //given
        ParkingLot parkingLot = new ParkingLot(2);
        Car aliceCar = new Car();
        Car bobCar = new Car();
        Ticket aliceTicket = parkingLot.park(aliceCar);
        Ticket bobTicket = parkingLot.park(bobCar);
        //when
        Car fetchedAliceCar = parkingLot.fetch(aliceTicket);
        Car fetchedBobCar = parkingLot.fetch(bobTicket);
        //then
        assertEquals(aliceCar,fetchedAliceCar);
        assertEquals(bobCar,fetchedBobCar);
    }

    @Test
    void should_return_exception_with_error_message_when_fetch_given_unrecognized_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        Ticket ticket = new Ticket();


        //then
        Exception exception = assertThrows(unrecognizedTicketException.class, () -> parkingLot.fetch(ticket));
        assertEquals("Unrecognized parking ticket.",exception.getMessage());
    }

    @Test
    void should_return_exception_when_fetch_given_used_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);
        parkingLot.fetch(ticket);
        //when
        //then
        Exception exception = assertThrows(unrecognizedTicketException.class, () -> parkingLot.fetch(ticket));
        assertEquals("Unrecognized parking ticket.",exception.getMessage());

    }

    @Test
    void should_return_exception_when_park_given_without_position() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        Car car2 = new Car();
        parkingLot.park(car);
        //when

        //then
        Exception exception = assertThrows(noAnyPositionException.class, () -> parkingLot.park(car2));
        assertEquals("No available position.",exception.getMessage());
    }
}
