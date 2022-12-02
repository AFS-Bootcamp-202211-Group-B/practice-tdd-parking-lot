package com.parkinglot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    public void should_return_parked_car_when_fetch_given_parking_lot_and_parked_car() {
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
    @Test
    public void should_return_corresponding_cars_when_fetch_twice_given_parking_lot_and_two_cars() {
        // given
        StandardParkingBoy parkingBoy = new StandardParkingBoy(new ParkingLot());
        Car car1 = new Car();
        Car car2 = new Car();
        Ticket ticket1 = parkingBoy.park(car1);
        Ticket ticket2 = parkingBoy.park(car2);
        // when
        Car fetchedCar1 = parkingBoy.fetch(ticket1);
        Car fetchedCar2 = parkingBoy.fetch(ticket2);
        // then
        assertEquals(car1, fetchedCar1);
        assertEquals(car2, fetchedCar2);

    }

    // Given a parking lot, a parking boy, and a wrong ticket, when fetch the car,
    // then return null, and throw "Unrecognized parking ticket".
    @Test
    public void should_return_unrecognized_parking_ticket_exception_when_fetch_given_parking_lot_and_unrecognized_ticket() {
        // given
        StandardParkingBoy parkingBoy = new StandardParkingBoy(new ParkingLot());
        Ticket ticket = new Ticket();
        // when
        // then
        Exception exception = assertThrows(UnrecognizedTicketException.class, () -> parkingBoy.fetch(ticket));
        assertEquals("Unrecognized parking ticket.", exception.getMessage());

    }

    // Given a parking lot, a parking boy, and a used ticket, when fetch the car,
    // then return null, and throw "Unrecognized parking ticket".
    @Test
    public void should_return_unrecognized_parking_ticket_exception_when_fetch_given_parking_lot_and_used_ticket() {
        // given
        StandardParkingBoy parkingBoy = new StandardParkingBoy(new ParkingLot());
        Car car = new Car();
        Ticket ticket = parkingBoy.park(car);
        parkingBoy.fetch(ticket);
        // when
        // then
        Exception exception = assertThrows(UnrecognizedTicketException.class, () -> parkingBoy.fetch(ticket));
        assertEquals("Unrecognized parking ticket.", exception.getMessage());

    }

    // Given a full parking lot, a parking boy, and a car, when park the car, then
    // return null, and throw "No available position".
    @Test
    public void should_return_no_available_position_exception_when_park_given_full_parking_lot() {
        // given
        StandardParkingBoy parkingBoy = new StandardParkingBoy(new ParkingLot(3));
        for (int i = 0; i < 3; i++) {
            Car car = new Car();
            parkingBoy.park(car);
        }
        // when
        // then
        Exception exception = assertThrows(NoAvailablePositionException.class, () -> parkingBoy.park(new Car()));
        assertEquals("No available position.", exception.getMessage());

    }

    // Story 4
    // Given two empty parking lots, a parking boy, and a car, when park the car,
    // then return a parking ticket.
    @Test
    public void should_return_ticket_when_park_given_two_empty_parking_lot_and_car() {
        // given
        List<ParkingLot> parkingLotList = Arrays.asList(new ParkingLot(), new ParkingLot());
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLotList);
        Car car = new Car();
        // when
        Ticket ticket = parkingBoy.park(car);
        // then
        assertNotNull(ticket);
    }

    // Given first full parking lot and second parking lot with available positions,
    // a parking boy, and a car, when park the car, then return a parking ticket.
    @Test
    public void should_return_ticket_when_park_given_one_full_parking_lot_one_with_positions_and_a_car() {
        // given
        ParkingLot fullParkingLot = new ParkingLot(1);
        fullParkingLot.park(new Car());
        ParkingLot availableParkingLot = new ParkingLot(1);
        List<ParkingLot> parkingLotList = Arrays.asList(fullParkingLot, availableParkingLot);
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLotList);
        // when
        Ticket ticket = parkingBoy.park(new Car());
        // then
        assertNotNull(ticket);

    }

    // Given two parking lots with a parked car each, a parking boy, two cars, and
    // two tickets, when fetch the car twice, then return corresponding cars.
    @Test
    public void should_return_corresponding_cars_when_fetch_twice_given_two_parking_lots_with_a_parked_car_each_and_two_tickets_and_two_cars() {
        // given
        ParkingLot parkingLot1 = new ParkingLot();
        Car car1 = new Car();
        Ticket ticket1 = parkingLot1.park(car1);
        ParkingLot parkingLot2 = new ParkingLot();
        Car car2 = new Car();
        Ticket ticket2 = parkingLot2.park(car2);
        List<ParkingLot> parkingLotList = Arrays.asList(parkingLot1, parkingLot2);
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLotList);
        // when
        Car fetchedCar1 = parkingBoy.fetch(ticket1);
        Car fetchedCar2 = parkingBoy.fetch(ticket2);
        // then
        assertEquals(car1, fetchedCar1);
        assertEquals(car2, fetchedCar2);

    }
    // Given two parking lots, a parking boy, and an unrecognized ticket in any
    // parking lots, when fetch the car, then throw "Unrecognized parking ticket".

    // Given two parking lots, a parking boy, and a used ticket in any one of the
    // parking lots, when fetch the car, then and throw "Unrecognized parking
    // ticket".

    // Given two full parking lots, a parking boy, and a car, when park the car,
    // then throw "No available position".

}
