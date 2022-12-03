package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

    @Test
    void should_return_ticket_when_parking_boy_park_given_one_full_and_one_available_parking_lot_and_a_car() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot1);
        ParkingLot parkingLot2 = new ParkingLot(10);
        parkingBoy.addParkingLot(parkingLot2);
        Car car = new Car();
        parkingLot1.park(car);
        Car car2 = new Car();

        //when
        ParkingTicket ticket = parkingBoy.park(car2);

        //then
        assertNotNull(ticket);
    }

    @Test
    void shoud_return_car_when_parking_boy_fetch_given_two_ticket_and_two_parking_lots(){
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);
        Car car = new Car();
        ParkingLot parkingLot2 = new ParkingLot(10);
        parkingBoy.addParkingLot(parkingLot2);
        Car car2 = new Car();
        ParkingTicket ticket = parkingLot.park(car);
        ParkingTicket ticket2 = parkingLot2.park(car2);


        //when
        Car fetchedCar = parkingBoy.fetch(ticket);
        Car fetchedCar2 = parkingBoy.fetch(ticket2);

        //then
        assertEquals(car, fetchedCar);
        assertEquals(car2, fetchedCar2);
    }
    
}
