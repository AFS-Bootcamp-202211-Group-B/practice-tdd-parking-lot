package com.parkinglot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class StandardParkingBoyTest {
    // Given a parking lot, a parking boy, and a car, when park the car, then return
    // a parking ticket.
    @Test
    public void should_return_ticket_when_park_given_parking_lot_and_car() {
        // given
        StandardParkingBoy parkingBoy = new StandardParkingBoy(new ParkingLot());
        Car car = new Car();
        // when
        Ticket ticket = parkingBoy.park(car);
        // then
        assertNotNull(ticket);

    }

    // Given a parking lot with a parked car, a parking boy, and a ticket, when
    // fetch the car, them return the parked car.
    @Test
    public void should_return_parked_car_when_fetch_given_parked_parking_lot_and_car() {
        // given
        StandardParkingBoy parkingBoy = new StandardParkingBoy(new ParkingLot());
        Car car = new Car();
        Ticket ticket = parkingBoy.park(car);
        // when
        Car fetchedCar = parkingBoy.fetch(ticket);
        // then
        assertEquals(car, fetchedCar);
    }

    // Given a parking lot, a parking boy, two cars, and two tickets, when fetch the
    // car twice, them return corresponding cars.

    // Given a parking lot, a parking boy, and a wrong ticket, when fetch the car,
    // then return null, and throw "Unrecognized parking ticket".

    // Given a parking lot, a parking boy, and a used ticket, when fetch the car,
    // then return null, and throw "Unrecognized parking ticket".

    // Given a full parking lot, a parking boy, and a car, when park the car, then
    // return null, and throw "No available position".

}
