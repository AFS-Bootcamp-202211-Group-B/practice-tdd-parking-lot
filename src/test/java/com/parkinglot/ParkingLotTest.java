package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
        Ticket ticket = ParkingLot.park(car);

        //When
        Car parkedCar = parkingLot.getCar(ticket);

        //Then
        assertEquals(car , parkedCar);
    }

}
