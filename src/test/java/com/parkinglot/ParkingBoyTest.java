package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingBoyTest {
    @Test
    void should_return_ticket_when_park_given_parkingLot_parkingBoy_car(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        //when
        Ticket ticket = parkingBoy.park(car);

        //then
        assertNotNull(ticket);
    }


    @Test
    void should_return_Car_when_Fetch_given_parkingLot_Ticket(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        Ticket ticket = parkingBoy.park(car);
        //when
        Car returnCar = parkingBoy.fetch(ticket);
        //then
        assertEquals(car,returnCar);
    }

    @Test
    void should_return_right_Car_when_Fetch_given_parkingLot_two_parked_cars_and_tickets(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car1 = new Car();
        Car car2 = new Car();
        Ticket ticket1 = parkingBoy.park(car1);
        Ticket ticket2 = parkingBoy.park(car2);
        //when
        Car returnCar1 = parkingBoy.fetch(ticket1);
        Car returnCar2 = parkingBoy.fetch(ticket2);
        //then
        assertEquals(car1,returnCar1);
        assertEquals(car2,returnCar2);
    }

    @Test
    void should_return_Exception_when_fetch_given_parkingLot_unrecognized_ticket(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Ticket wrongParkingTicket= new Ticket();

        //when

        //then
        Exception e = assertThrows(UnrecognizedParkingTicketException.class, ()-> parkingBoy.fetch(wrongParkingTicket));
        assertEquals("Ticket not found",e.getMessage());
    }
}
