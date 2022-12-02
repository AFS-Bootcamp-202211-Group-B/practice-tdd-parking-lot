package com.parkinglot;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingBoyTest {

    @Test
    void should_return_ticket_when_park_car_given_parking_boy_and_car() {
        ///Given
        ParkingLot parkingLot = new ParkingLot();
        StandardParkingBoy parkingboy = new StandardParkingBoy(parkingLot);
        Car car = new Car();

        //When
        Ticket ticket = parkingboy.park(car);

        //Then
        assertNotNull(ticket);
    }

}