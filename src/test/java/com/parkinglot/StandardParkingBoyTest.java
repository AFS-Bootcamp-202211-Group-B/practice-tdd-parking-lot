package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StandardParkingBoyTest {
    @Test
    void should_return_ticket_when_park_given_parking_lot_and_a_car() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);
        Car car = new Car();
        //when
        Ticket ticket = parkingBoy.park(car);
        //then
        assertNotNull(ticket);
    }

    @Test
    void should_return_car_when_fetch_given_parking_lot_and_a_car() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);
        Car car = new Car();
        Ticket ticket = parkingBoy.park(car);
        //when
        Car fetchedCar = parkingBoy.fetch(ticket);
        //then
        assertEquals(car, fetchedCar);

    }

    @Test
    void should_return_right_car_when_fetch_twice_given_2_parked_cars() {
        //given
        ParkingLot parkingLot = new ParkingLot(2);
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);
        Car car1 = new Car();
        Ticket ticket1 = parkingBoy.park(car1);
        Car car2 = new Car();
        Ticket ticket2 = parkingBoy.park(car2);
        //when
        Car fetchedCar1 = parkingBoy.fetch(ticket1);
        Car fetchedCar2 = parkingBoy.fetch(ticket2);
        //then
        assertEquals(car1,fetchedCar1);
        assertEquals(car2,fetchedCar2);
    }

    @Test
    void should_return_exception_with_error_message_when_fetch_given_unrecognized_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);
        Car car = new Car();
        Ticket ticket = new Ticket();
        //then
        Exception exception = assertThrows(unrecognizedTicketException.class, () -> parkingBoy.fetch(ticket));
        assertEquals("Unrecognized parking ticket.",exception.getMessage());

    }

    @Test
    void should_return_exception_when_fetch_given_used_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);
        parkingLot.fetch(ticket);
        //then
        Exception exception = assertThrows(unrecognizedTicketException.class, () -> parkingBoy.fetch(ticket));
        assertEquals("Unrecognized parking ticket.",exception.getMessage());

    }

    @Test
    void should_return_exception_when_park_given_without_position() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);
        Car car = new Car();
        Car car2 = new Car();
        parkingLot.park(car);
        //then
        Exception exception = assertThrows(noAnyPositionException.class, () -> parkingBoy.park(car2));
        assertEquals("No available position.",exception.getMessage());
    }

    @Test
    void should_park_first_parking_lot_when_park_given_2_parking_lots_with_available_position() {
        //given
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(firstParkingLot);
        parkingLots.add(secondParkingLot);
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLots);
        Car car = new Car();
        //when
        parkingBoy.park(car);
        //then
        assertEquals(1,firstParkingLot.getParkedCar().size());
        assertEquals(0,secondParkingLot.getParkedCar().size());
    }

    @Test
    void should_park_to_second_parking_lot_when_park_given_2_parking_lots_first_is_full_second_with_available_position() {
        //given
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(firstParkingLot);
        parkingLots.add(secondParkingLot);
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLots);
        Car aliceCar = new Car();
        parkingBoy.park(aliceCar);
        Car bobCar = new Car();
        //when
        parkingBoy.park(bobCar);
        //then
        assertEquals(1,firstParkingLot.getParkedCar().size());
        assertEquals(1,secondParkingLot.getParkedCar().size());
    }
}
