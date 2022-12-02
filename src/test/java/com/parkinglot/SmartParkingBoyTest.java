package com.parkinglot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class SmartParkingBoyTest {
    // Story 5
    // Given two empty parking lots, a smart parking boy, and a car, when park the
    // car, then return a parking ticket.
    @Test
    public void should_return_ticket_when_park_given_parking_lot_and_car() {
        // given
        SmartParkingBoy parkingBoy = new SmartParkingBoy(new ParkingLot());
        Car car = new Car();
        // when
        Ticket ticket = parkingBoy.park(car);
        // then
        assertNotNull(ticket);

    }

    // Given first full parking lot and second parking lot with available positions,
    // a smart parking boy, and a car, when park the car, then return a parking
    // ticket from second parking lot.
    @Test
    public void should_return_parked_car_from_second_parking_lot_when_fetch_given_first_full_parking_lot_and_second_parking_lot_with_empty_position() {
        // given
        ParkingLot fullParkingLot = new ParkingLot(1);
        fullParkingLot.park(new Car());
        ParkingLot availableParkingLot = new ParkingLot(1);
        List<ParkingLot> parkingLotList = Arrays.asList(fullParkingLot, availableParkingLot);
        SmartParkingBoy parkingBoy = new SmartParkingBoy(parkingLotList);
        // when
        Ticket ticket = parkingBoy.park(new Car());
        // then
        assertNotNull(ticket);
    }

    // Given first parking lot with 1 empty position, capacity 5, and second parking
    // lot with 2 empty positions, capacity 3, a smart parking boy, and a car, when
    // park the car, then return a parking ticket from second parking lot.

    // Given two parking lots with a parked car each, a smart parking boy, two cars,
    // and two tickets, when fetch the car twice, then return corresponding cars.

    // Given two parking lots, a smart parking boy, and an unrecognized ticket in
    // any parking lots, when fetch the car, then throw "Unrecognized parking
    // ticket".

    // Given two parking lots, a smart parking boy, and a used ticket in any one of
    // the parking lots, when fetch the car, then and throw "Unrecognized parking
    // ticket".

    // Given two full parking lots, a smart parking boy, and a car, when park the
    // car, then throw "No available position".
}
