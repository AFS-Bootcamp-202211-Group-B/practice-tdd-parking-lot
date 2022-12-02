package com.parkinglot;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingBoyTest {

    @Test
    void should_return_ticket_when_park_car_given_parking_boy_and_car() {
        ///Given
        ParkingLot parkingLot = new ParkingLot();
        StandardParkingBoy parKingBoy = new StandardParkingBoy(parkingLot);
        Car car = new Car();

        //When
        Ticket ticket = parKingBoy.park(car);

        //Then
        assertNotNull(ticket);
    }
    @Test
    void should_return_parked_car_when_get_car_given_parking_boy_with_the_parked_car(){
        ///Given
        ParkingLot parkingLot = new ParkingLot();
        StandardParkingBoy parKingBoy = new StandardParkingBoy(parkingLot);
        Car car = new Car();
        Ticket ticket = parKingBoy.park(car);

        //When
        Car parkedCar = parKingBoy.getCar(ticket);

        //Then
        assertEquals(car , parkedCar);
    }

}