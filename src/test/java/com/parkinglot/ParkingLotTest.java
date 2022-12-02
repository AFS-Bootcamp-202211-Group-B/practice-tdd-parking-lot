package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {

    @Test
    void should_return_ticket_when_park_car_given_parking_lot_and_car(){
        ///Given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();

        //When
        Ticket ticket = parkingLot.park(car);

        //Then
        assertNotNull(ticket);
    }

    @Test
    void should_return_parked_car_when_get_car_given_parking_lot_with_the_parked_car(){
        ///Given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);

        //When
        Car parkedCar = parkingLot.getCar(ticket);

        //Then
        assertEquals(car , parkedCar);
    }

    @Test
    void should_return_the_right_car_with_each_ticket_when_get_car_twice_given_a_parking_with_two_parked_cars(){
        ///Given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        Car car2 = new Car();

        Ticket ticket = parkingLot.park(car);
        Ticket ticket2= parkingLot.park(car2);

        //When
        Car parkedCar = parkingLot.getCar(ticket);
        Car parkedCar2 = parkingLot.getCar(ticket2);

        //Then
        assertEquals(car , parkedCar);
        assertEquals(car2 , parkedCar2);
    }

    @Test
    void should_return_null_when_giving_wrong_ticket_to_get_the_car(){
        ///Given
        ParkingLot parkingLot = new ParkingLot();

        //When
        Ticket ticket = new Ticket();
        Car car = parkingLot.getCar(ticket);

        //Then
        assertNull(car);
    }



}
