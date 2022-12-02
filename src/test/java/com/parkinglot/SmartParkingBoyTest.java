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
    @Test
    public void should_return_parked_car_from_second_parking_lot_when_fetch_given_first_parking_lot_with_1_empty_position_and_second_parking_lot_with_2_empty_positions() {
        // given
        ParkingLot parkingLot1 = new ParkingLot(5);
        for (int i = 0; i < 3; i++) {
            Car car = new Car();
            parkingLot1.park(car);
        }
        ParkingLot parkingLot2 = new ParkingLot(3);
        List<ParkingLot> parkingLotList = Arrays.asList(parkingLot1, parkingLot2);
        SmartParkingBoy parkingBoy = new SmartParkingBoy(parkingLotList);
        // when
        Ticket ticket = parkingBoy.park(new Car());
        // then
        // check ticket is from parkingLot2 and fetch does not return null/ exception
        assertEquals(parkingLot2.fetch(ticket).getClass(), Car.class);
    }

    // Given two parking lots with a parked car each, a smart parking boy, two cars,
    // and two tickets, when fetch the car twice, then return corresponding cars.
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
        SmartParkingBoy parkingBoy = new SmartParkingBoy(parkingLotList);
        // when
        Car fetchedCar1 = parkingBoy.fetch(ticket1);
        Car fetchedCar2 = parkingBoy.fetch(ticket2);
        // then
        assertEquals(car1, fetchedCar1);
        assertEquals(car2, fetchedCar2);

    }

    // Given two parking lots, a smart parking boy, and an unrecognized ticket in
    // any parking lots, when fetch the car, then throw "Unrecognized parking
    // ticket".
    @Test
    public void should_return_unrecognized_parking_ticket_exception_when_fetch_given_two_parking_lots_and_unrecognized_ticket() {
        // given
        List<ParkingLot> parkingLotList = Arrays.asList(new ParkingLot(), new ParkingLot());
        SmartParkingBoy parkingBoy = new SmartParkingBoy(parkingLotList);
        Ticket ticket = new Ticket();
        // when
        // then
        Exception exception = assertThrows(UnrecognizedTicketException.class, () -> parkingBoy.fetch(ticket));
        assertEquals("Unrecognized parking ticket.", exception.getMessage());

    }
    // Given two parking lots, a smart parking boy, and a used ticket in any one of
    // the parking lots, when fetch the car, then and throw "Unrecognized parking
    // ticket".

    // Given two full parking lots, a smart parking boy, and a car, when park the
    // car, then throw "No available position".
}
