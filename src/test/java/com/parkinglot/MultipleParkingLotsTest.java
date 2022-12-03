package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void should_return_exception_with_error_message_when_fetch_given_two_parking_lots_and_a_unrecognized_ticket(){
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        ParkingTicket unrecognizedParkingTicket = new ParkingTicket();
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);
        ParkingLot parkingLot2 = new ParkingLot(10);
        parkingBoy.addParkingLot(parkingLot2);

        //when
        // Car fetchedCar = parkingLot.fetch(unrecognizedParkingTicket) ;

        //then
        Exception exception = assertThrows(UnrecognizeedTicketException.class,
                () -> parkingBoy.fetch(unrecognizedParkingTicket));
        assertEquals("Unrecognized parking ticket",exception.getMessage());
    }

    @Test
    void should_return_exception_with_error_message_when_fetch_given_two_parking_lots_and_a_used_ticket(){
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        Car bobCar = new Car();
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);
        ParkingTicket usedTicket = parkingBoy.park(bobCar);
        ParkingLot parkingLot2 = new ParkingLot(10);
        parkingBoy.addParkingLot(parkingLot2);
        parkingBoy.fetch(usedTicket) ;

        //when
        // Car fetchedCar = parkingLot.fetch(unrecognizedParkingTicket) ;

        //then
        Exception exception = assertThrows(UnrecognizeedTicketException.class,
                () -> parkingLot.fetch(usedTicket));
        assertEquals("Unrecognized parking ticket",exception.getMessage());
    }

    @Test
    void should_return_exception_with_error_message_when_park_car_given_two_parking_lots_without_position_and_car(){
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        //when
        Car bob = new Car();
        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLot);
        parkingBoy.park(bob);
        parkingBoy.addParkingLot(parkingLot2);
        Car aliceCar = new Car();
        parkingBoy.park(aliceCar);
        Car chrisCar = new Car();

        //then
        Exception exception = assertThrows(NoAvailablePositionException.class,
                () -> parkingBoy.park(chrisCar));
        assertEquals("No available position",exception.getMessage());
    }


}
