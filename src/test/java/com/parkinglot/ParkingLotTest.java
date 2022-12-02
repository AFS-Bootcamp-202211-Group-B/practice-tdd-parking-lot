package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {

    @Test
    void should_return_ticket_when_park_given_a_car(){
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car();

        //when
        ParkingTicket ticket = parkingLot.park(car);

        //then
        assertNotNull(ticket);
    }

    @Test
    void should_return_car_when_fetch_given_a_ticket(){
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car();
        ParkingTicket ticket = parkingLot.park(car);

        //when
         Car fetchedCar = parkingLot.fetch(ticket) ;

        //then
        assertEquals(car, fetchedCar);
    }

    @Test
    void should_return_right_car_when_fetch_twice_given_two_parked_cars_and_tickets(){
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        Car aliceCar = new Car();
        Car bobCar = new Car();
        ParkingTicket aliceTicket = parkingLot.park(aliceCar);
        ParkingTicket bobTicket = parkingLot.park(bobCar);

        //when
        Car aliceFetchedCar = parkingLot.fetch(aliceTicket) ;
        Car bobFetchedCar = parkingLot.fetch(bobTicket) ;

        //then
        assertEquals(aliceCar, aliceFetchedCar);
        assertEquals(bobCar, bobFetchedCar);
    }

    @Test
    void should_return_nothing_when_fetch_car_given_a_parking_lot_and_wrong_ticket(){
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        Car bobCar = new Car();

        //when
        Car aliceFetchedCar = parkingLot.fetch(new ParkingTicket()) ;

        //then
        assertEquals(null, aliceFetchedCar);
    }

    @Test
    void should_return_nothing_when_fetch_car_given_a_parking_lot_and_used_ticket(){
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        Car bobCar = new Car();
        ParkingTicket bobTicket = parkingLot.park(bobCar);
        Car bob = parkingLot.fetch(bobTicket) ;

        //when
        Car aliceFetchedCar = parkingLot.fetch(bobTicket) ;

        //then
        assertEquals(null, aliceFetchedCar);
    }

    @Test
    void should_return_nothing_when_park_car_given_a_parking_lot_without_any_position_and_car(){
        //given
        ParkingLot parkingLot = new ParkingLot(1);

        //when
        Car bob = new Car();
        ParkingTicket bobTickete = parkingLot.park(bob);
        Car aliceCar = new Car();
        ParkingTicket aliceTicket = parkingLot.park(aliceCar);
        aliceCar =  parkingLot.fetch(aliceTicket) ;

        //then
        assertEquals(null, aliceCar);
    }

    @Test
    void should_return_exception_with_error_message_when_fetch_given_unrecognized_ticket(){
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        ParkingTicket unrecognizedParkingTicket = new ParkingTicket();

        //when
       // Car fetchedCar = parkingLot.fetch(unrecognizedParkingTicket) ;

        //then
       Exception exception = assertThrows(UnrecognizeedTicketException.class,
               () -> parkingLot.fetch(unrecognizedParkingTicket));
        assertEquals("Unrecognized parking ticket",exception.getMessage());
    }

    @Test
    void should_return_exception_with_error_message_when_fetch_given_used_ticket(){
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        Car bobCar = new Car();
        ParkingTicket usedTicket = parkingLot.park(bobCar);
        Car bob = parkingLot.fetch(usedTicket) ;

        //when

        //then
        Exception exception = assertThrows(UnrecognizeedTicketException.class,
                () -> parkingLot.fetch(usedTicket));
        assertEquals("Unrecognized parking ticket",exception.getMessage());
    }

    @Test
    void should_return_exception_with_error_message_when_park_car_given_parking_lot_without_position_and_car(){
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        //when
        Car bob = new Car();
        ParkingTicket bobTickete = parkingLot.park(bob);
        Car aliceCar = new Car();

        //then
        Exception exception = assertThrows(NoAvailablePositionException.class,
                () -> parkingLot.park(aliceCar));
        assertEquals("No available position",exception.getMessage());
    }

}
