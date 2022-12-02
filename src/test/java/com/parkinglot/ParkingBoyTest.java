package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingBoyTest {

    @Test
    void shoud_return_ticket_when_parking_boy_park_given_car(){

        //given
        ParkingLot parkingLot = new ParkingLot(10);
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);
        Car car = new Car();

        //when
        ParkingTicket ticket = parkingBoy.park(car);

        //then
        assertNotNull(ticket);
    }

    @Test
    void shoud_return_car_when_parking_boy_fetch_given_a_ticket(){
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);
        Car car = new Car();
        ParkingTicket ticket = parkingBoy.park(car);

        //when
        Car fetchedCar = parkingBoy.fetch(ticket) ;

        //then
        assertEquals(car, fetchedCar);
    }

    @Test
    void should_return_right_car_when_parking_boy_fetch_twice_given_two_parked_cars_and_tickets(){
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);
        Car aliceCar = new Car();
        Car bobCar = new Car();
        ParkingTicket aliceTicket = parkingBoy.park(aliceCar);
        ParkingTicket bobTicket = parkingBoy.park(bobCar);

        //when
        Car aliceFetchedCar = parkingBoy.fetch(aliceTicket) ;
        Car bobFetchedCar = parkingBoy.fetch(bobTicket) ;

        //then
        assertEquals(aliceCar, aliceFetchedCar);
        assertEquals(bobCar, bobFetchedCar);
    }

    @Test
    void should_return_exception_with_error_message_when_fetch_given_unrecognized_ticket(){
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        ParkingTicket unrecognizedParkingTicket = new ParkingTicket();
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);

        //when
        // Car fetchedCar = parkingLot.fetch(unrecognizedParkingTicket) ;

        //then
        Exception exception = assertThrows(UnrecognizeedTicketException.class,
                () -> parkingBoy.fetch(unrecognizedParkingTicket));
        assertEquals("Unrecognized parking ticket",exception.getMessage());
    }

    @Test
    void should_return_exception_with_error_message_when_fetch_given_used_ticket(){
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        Car bobCar = new Car();
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);
        ParkingTicket usedTicket = parkingBoy.park(bobCar);
        Car bob = parkingBoy.fetch(usedTicket) ;

        //when

        //then
        Exception exception = assertThrows(UnrecognizeedTicketException.class,
                () -> parkingBoy.fetch(usedTicket));
        assertEquals("Unrecognized parking ticket",exception.getMessage());
    }

    @Test
    void should_return_exception_with_error_message_when_park_car_given_parking_lot_without_position_and_car(){
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        //when
        Car bob = new Car();
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);
        ParkingTicket bobTickete = parkingBoy.park(bob);
        Car aliceCar = new Car();

        //then
        Exception exception = assertThrows(NoAvailablePositionException.class,
                () -> parkingBoy.park(aliceCar));
        assertEquals("No available position",exception.getMessage());
    }
}
