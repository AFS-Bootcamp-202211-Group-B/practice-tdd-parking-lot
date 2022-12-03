package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SmartParkingBoyTest {

    @Test
    void should_return_second_parking_lot_ticket_when_park_car_given_second_parking_lot_more_position_than_first_one(){
        //given
        ParkingLot parkingLot = new ParkingLot(3);
        ParkingLot parkingLot2 = new ParkingLot(5);
        //when
        Car bob = new Car();
        SmartParkingBoy parkingBoy = new SmartParkingBoy(parkingLot);
        parkingBoy.addParkingLot(parkingLot2);
        parkingBoy.park(bob);

        //then
        assertEquals(4, parkingLot2.getEmptyPosition());
    }

    @Test
    void should_return_exception_with_error_message_when_fetch_given_two_parking_lots_and_a_unrecognized_ticket(){
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        ParkingTicket unrecognizedParkingTicket = new ParkingTicket();
        SmartParkingBoy parkingBoy = new SmartParkingBoy(parkingLot);
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
        SmartParkingBoy parkingBoy = new SmartParkingBoy(parkingLot);
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
        SmartParkingBoy parkingBoy = new SmartParkingBoy(parkingLot);
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
