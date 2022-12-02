package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {
    @Test
    void should_return_Ticket_when_Park_given_ParkLot_and_Car(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car=new Car();
        //when
        Ticket ticket = parkingLot.park(car);

        //then
        assertNotNull(ticket);
    }

    @Test
    void should_return_Car_when_Fetch_given_Ticket(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);
        //when
        Car returnCar = parkingLot.fetch(ticket);
        //then
        assertEquals(car,returnCar);
    }

    @Test
    void should_return_right_Car_when_Fetch_given_two_parked_cars_and_tickets(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car1 = new Car();
        Car car2 = new Car();
        Ticket ticket1 = parkingLot.park(car1);
        Ticket ticket2 = parkingLot.park(car2);
        //when
        Car returnCar1 = parkingLot.fetch(ticket1);
        Car returnCar2 = parkingLot.fetch(ticket2);
        //then
        assertEquals(car1,returnCar1);
        assertEquals(car2,returnCar2);
    }

    @Test
    void should_return_Exception_when_fetch_given_unrecognized_ticket(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        Ticket wrongParkingTicket= new Ticket();

        //when

        //then
        Exception e = assertThrows(UnrecognizedParkingTicketException.class, ()-> parkingLot.fetch(wrongParkingTicket));
        assertEquals("Ticket not found",e.getMessage());
    }

    @Test
    void should_return_Exception_and_errorMsg_when_fetch_given_used_ticket(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();

        Ticket oldTicket = parkingLot.park(car);
        parkingLot.fetch(oldTicket);

        //then
        Exception e = assertThrows(UnrecognizedParkingTicketException.class, ()-> parkingLot.fetch(oldTicket));
        assertEquals("Ticket not found",e.getMessage());
    }

    @Test
    void should_return_Exception_and_errorMsg_when_park_given_fulled_parkingLot(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        for(int i=0;i<10;i++){
            Car tempCar=new Car();
            parkingLot.park(tempCar);
        }
        Car extraCar = new Car();

        //then
        Exception e = assertThrows(FullParkingLotException.class,
                ()-> parkingLot.park(extraCar));
        assertEquals("ParkingLot is fulled",e.getMessage());
    }
}
