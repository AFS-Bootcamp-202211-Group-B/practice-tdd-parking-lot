package com.parkinglot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class ParkingLotTest {
    // AC1
    // Given a parking lot, and a car, when park the car, then return a parking
    // ticket.
    @Test
    public void should_return_ticket_when_park_given_car() {
        // given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        // when
        Ticket ticket = parkingLot.park(car);
        // then
        assertNotNull(ticket);

    }

    // Given a parking lot with a parked car, and a ticket, when fetch the car, then
    // return the parked car.
    @Test
    public void should_return_parked_car_when_fetch_given_parked_car() {
        // given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);
        // when
        Car fetchedCar = parkingLot.fetch(ticket);
        // then
        assertEquals(car, fetchedCar);
    }

    // AC2
    // Given a parking lot, two cars, and two tickets, when fetch the car twice,
    // them return corresponding cars.
    @Test
    public void should_return_corresponding_cars_when_fetch_twice_given_two_cars() {
        // given
        ParkingLot parkingLot = new ParkingLot();
        Car car1 = new Car();
        Car car2 = new Car();
        Ticket ticket1 = parkingLot.park(car1);
        Ticket ticket2 = parkingLot.park(car2);
        // when
        Car fetchedCar1 = parkingLot.fetch(ticket1);
        Car fetchedCar2 = parkingLot.fetch(ticket2);
        // then
        assertEquals(car1, fetchedCar1);
        assertEquals(car2, fetchedCar2);

    }

    // AC3
    // Given a parking lot, and a wrong ticket, when fetch the car, then return
    // null.
    @Test
    public void should_return_null_when_fetch_given_wrong_ticket() {
        // given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        Ticket ticket = new Ticket();
        // when
        Car fetchedCar = parkingLot.fetch(ticket);
        // then
        assertEquals(null, fetchedCar);

    }

    // Given a parking lot, and no ticket, when fetch the car, then return null.

    // AC4
    // Given a parking lot, and a used ticket, when fetch the car, then return null.
    @Test
    public void should_return_null_when_fetch_given_used_ticket() {
        // given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);
        parkingLot.fetch(ticket);
        // when
        Car fetchedCar = parkingLot.fetch(ticket);
        // then
        assertEquals(null, fetchedCar);

    }

    // AC5
    // Given a full parking lot, and a car, when park the car, then return null.
    @Test
    public void should_return_null_when_fetch_given_full_parking_lot() {
        // given
        ParkingLot parkingLot = new ParkingLot(3);
        for (int i = 0; i < 3; i++) {
            Car car = new Car();
            parkingLot.park(car);
        }

        // when
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);
        // then
        assertEquals(null, ticket);

    }
}
