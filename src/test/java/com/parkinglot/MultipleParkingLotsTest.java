package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MultipleParkingLotsTest {

    @Test
    void should_return_ticket_when_parking_boy_park_given_two_available_parking_lots_and_a_car() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(10);
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot1);
        ParkingLot parkingLot2 = new ParkingLot(10);
        parkingBoy.addParkingLot(parkingLot2);
        Car car = new Car();

        //when
        ParkingTicket ticket = parkingBoy.park(car);

        //then
        assertNotNull(ticket);
    }


}
