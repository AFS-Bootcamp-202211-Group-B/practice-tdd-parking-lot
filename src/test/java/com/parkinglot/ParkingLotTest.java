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
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);
        assertNotNull(ticket);

    }

    // Given a parking lot with a parked car, and a ticket, when fetch the car, then
    // return the parked car.
    @Test
    public void should_return_parked_car_when_fetch_given_parked_car() {
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);
        Car fetchedCar = ticket.fetch();
        assertEquals(car, fetchedCar);
    }

    // AC2
    // Given a parking lot, two cars, and two tickets, when fetch the car twice,
    // them return corresponding cars.

    // AC3
    // Given a parking lot, and a wrong ticket, when fetch the car, then return
    // null.
    // Given a parking lot, and no ticket, when fetch the car, then return null.
    // AC4
    // Given a parking lot, and a used ticket, when fetch the car, then return null.
    // AC5
    // Given a full parking lot, and a car, when park the car, then return null.
}
