package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SmartParkingBoyTest {
    @Test
    void should_park_to_first_parking_lot_when_park_given_2_parking_lots_both_with_same_available_position() {
        //given
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(firstParkingLot);
        parkingLots.add(secondParkingLot);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Car car = new Car();
        //when
        smartParkingBoy.park(car);
        //then
        assertEquals(1,firstParkingLot.getParkedCar().size());
        assertEquals(0,secondParkingLot.getParkedCar().size());
    }

    @Test
    void should_park_to_second_parking_lot_when_park_given_2_parking_lots_first_one_has_less_available_postiion_than_second_one() {
        //given
        ParkingLot firstParkingLot = new ParkingLot(2);
        ParkingLot secondParkingLot = new ParkingLot(2);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(firstParkingLot);
        parkingLots.add(secondParkingLot);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Car aliceCar = new Car();
        smartParkingBoy.park(aliceCar);
        Car bobCar = new Car();
        //when
        smartParkingBoy.park(bobCar);
        //then
        assertEquals(1,firstParkingLot.getParkedCar().size());
        assertEquals(1,secondParkingLot.getParkedCar().size());
    }

    @Test
    void should_return_right_car_when_fetch_twice_given_2_parked_cars_and_2_parking_lots() {
        //given
        ParkingLot firstParkingLot = new ParkingLot(2);
        ParkingLot secondParkingLot = new ParkingLot(2);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(firstParkingLot);
        parkingLots.add(secondParkingLot);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Car aliceCar = new Car();
        Ticket aliceTicket = smartParkingBoy.park(aliceCar);
        Car bobCar = new Car();
        Ticket bobTicket = smartParkingBoy.park(bobCar);
        //when
        Car fetchedAliceCar = smartParkingBoy.fetch(aliceTicket);
        Car fetchedBobCar = smartParkingBoy.fetch(bobTicket);
        //then
        assertEquals(aliceCar,fetchedAliceCar);
        assertEquals(bobCar,fetchedBobCar);
    }

    @Test
    void should_return_exception_with_error_message_when_fetch_given_unrecognized_ticket_and_2_parking_lots() {
        //given
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(firstParkingLot);
        parkingLots.add(secondParkingLot);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Car car = new Car();
        Ticket ticket = new Ticket();
        //then
        Exception exception = assertThrows(unrecognizedTicketException.class, () -> smartParkingBoy.fetch(ticket));
        assertEquals("Unrecognized parking ticket.",exception.getMessage());

    }

    @Test
    void should_return_exception_when_fetch_given_used_ticket_and_2_parking_lots() {
        //given
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(firstParkingLot);
        parkingLots.add(secondParkingLot);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Car car = new Car();
        //when
        Ticket ticket = smartParkingBoy.park(car);
        smartParkingBoy.fetch(ticket);
        //then
        Exception exception = assertThrows(unrecognizedTicketException.class, () -> smartParkingBoy.fetch(ticket));
        assertEquals("Unrecognized parking ticket.",exception.getMessage());
    }

    @Test
    void should_return_exception_when_park_given_without_position_in_2_parking_lots() {
        //given
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(firstParkingLot);
        parkingLots.add(secondParkingLot);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Car aliceCar = new Car();
        smartParkingBoy.park(aliceCar);
        Car bobCar = new Car();
        smartParkingBoy.park(bobCar);
        Car tomCar = new Car();
        //then
        Exception exception = assertThrows(noAnyPositionException.class, () -> smartParkingBoy.park(tomCar));
        assertEquals("No available position.",exception.getMessage());
    }
}
