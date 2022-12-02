package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingBoyTest {
    @Test
    void should_return_ticket_when_park_given_parkingLot_and_parkingBoy_car(){
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
    void should_return_Car_when_Fetch_given_parkingLot_and_Ticket(){
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
    void should_return_right_Car_when_Fetch_given_parkingLot_and_two_parked_cars_and_tickets(){
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
    void should_return_Exception_when_fetch_given_parkingLot_and_unrecognized_ticket(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Ticket wrongParkingTicket= new Ticket();

        //when

        //then
        Exception e = assertThrows(UnrecognizedParkingTicketException.class, ()-> parkingBoy.fetch(wrongParkingTicket));
        assertEquals("Unrecognized parking ticket.",e.getMessage());
    }

    @Test
    void should_return_Exception_and_errorMsg_when_fetch_given_parkingLot_and_used_ticket(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();

        Ticket oldTicket = parkingBoy.park(car);
        parkingBoy.fetch(oldTicket);

        //then
        Exception e = assertThrows(UnrecognizedParkingTicketException.class, ()-> parkingBoy.fetch(oldTicket));
        assertEquals("Unrecognized parking ticket.",e.getMessage());
    }

    @Test
    void should_return_Exception_and_errorMsg_when_park_given_parkingLog_and_fulled_parkingLot(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        for(int i=0;i<10;i++){
            Car tempCar=new Car();
            parkingBoy.park(tempCar);
        }
        Car extraCar = new Car();

        //then
        Exception e = assertThrows(FullParkingLotException.class,
                ()-> parkingBoy.park(extraCar));
        assertEquals("No available position.",e.getMessage());
    }

//    Given a standard parking boy, who manage two parking lots, both with available position, and a car, When park the
//    car, Then the car will be parked to the first parking lot
    @Test
    void should_return_ticket_from_first_parkingLot_when_park_given_two_available_parkingLots_and_car(){
        //given
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(parkingLot1, parkingLot2));

        Car car = new Car();
        //when
        Ticket ticket = parkingBoy.park(car);

        //then
        assertTrue(parkingLot1.has(ticket));
    }

//   Given a standard parking boy, who manage two parking lots, first is full and second with available position, and a
//   car, When park the car, Then the car will be parked to the second parking lot
    @Test
    void should_return_ticket_from_second_parkingLot_when_park_given_1stFullParkingLot_and_2ndAvaParkingLot_and_car(){
        //given
        ParkingLot parkingLot1 = new ParkingLot();
        for(int i=0;i<10;i++){
            Car tempCar=new Car();
            parkingLot1.park(tempCar);
        }
        ParkingLot parkingLot2 = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(parkingLot1, parkingLot2));
        Car car = new Car();
        //when
        Ticket ticket = parkingBoy.park(car);

        //then
        assertFalse(parkingLot1.has(ticket));
        assertTrue(parkingLot2.has(ticket));
    }

//    Given a standard parking boy, who manage two parking lots, both with a parked car, and two parking ticket, When
//    fetch the car twice, Then return the right car with each ticket
    @Test
    void should_return_two_right_car_from_corresponding_ticket_when_fetch_given_2parkingLots_both_with_parked_car_and_two_ticket(){
        //given
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        Car car1 = new Car();
        Car car2 = new Car();
        Ticket ticket1 = parkingLot1.park(car1);
        Ticket ticket2 = parkingLot2.park(car2);
        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(parkingLot1, parkingLot2));
        //when
        Car returnCar1 = parkingBoy.fetch(ticket1);
        Car returnCar2 = parkingBoy.fetch(ticket2);

        //then
        assertEquals(car1,returnCar1);
        assertEquals(car2,returnCar2);
    }
}
