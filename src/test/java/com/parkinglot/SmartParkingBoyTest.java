package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SmartParkingBoyTest {
    @Test
    void should_return_ticket_from_first_parkingLot_when_park_given_two_available_parkingLots_where_parkingLots1_has_the_most_space_and_car(){
        //given
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        for(int i=0;i<3;i++){
            parkingLot2.park(new Car());
        }
        ParkingBoy smartParkingBoy = new SmartParkingBoy(Arrays.asList(parkingLot1, parkingLot2));

        Car car = new Car();
        //when
        Ticket ticket = smartParkingBoy.park(car);

        //then
        assertTrue(parkingLot1.has(ticket));
    }
    @Test
    void should_return_ticket_from_first_parkingLot_when_park_given_two_available_parkingLots_where_parkingLots2_has_the_most_space_and_car(){
        //given
        ParkingLot parkingLot1 = new ParkingLot();
        for(int i=0;i<3;i++){
            parkingLot1.park(new Car());
        }
        ParkingLot parkingLot2 = new ParkingLot();

        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(Arrays.asList(parkingLot1, parkingLot2));

        Car car = new Car();
        //when
        Ticket ticket = smartParkingBoy.park(car);

        //then
        assertTrue(parkingLot2.has(ticket));
    }

    @Test
    void should_return_two_right_car_from_corresponding_ticket_when_fetch_given_2parkingLots_both_with_parked_car_and_two_ticket(){
        //given
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        Car car1 = new Car();
        Car car2 = new Car();
        Ticket ticket1 = parkingLot1.park(car1);
        Ticket ticket2 = parkingLot2.park(car2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(Arrays.asList(parkingLot1, parkingLot2));
        //when
        Car returnCar1 = smartParkingBoy.fetch(ticket1);
        Car returnCar2 = smartParkingBoy.fetch(ticket2);

        //then
        assertEquals(car1,returnCar1);
        assertEquals(car2,returnCar2);
    }

    @Test
    void should_raise_Exception_with_errorMsg_when_fetch_given_two_parkingLots_and_unrecognized_ticket(){
        //given
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(Arrays.asList(parkingLot1, parkingLot2));
        Ticket unrecognizedTicket1 = new Ticket();

        //when
        Exception e = assertThrows(UnrecognizedParkingTicketException.class,() ->smartParkingBoy.fetch(unrecognizedTicket1));

        //then
        assertEquals("Unrecognized parking ticket.",e.getMessage());
    }

    @Test
    void should_raise_Exception_with_errorMsg_when_fetch_given_two_parkingLots_and_used_ticket(){
        //given
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(Arrays.asList(parkingLot1, parkingLot2));
        Ticket usedTicket = smartParkingBoy.park(new Car());
        smartParkingBoy.fetch(usedTicket);

        //when
        Exception e = assertThrows(UnrecognizedParkingTicketException.class,() ->smartParkingBoy.fetch(usedTicket));

        //then
        assertEquals("Unrecognized parking ticket.",e.getMessage());
    }

    @Test
    void should_raise_Exception_with_errorMsg_when_park_given_two_fulled_parkingLogs_and_car(){
        //given
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        for(int i=0;i<10;i++){
            parkingLot1.park(new Car());
            parkingLot2.park(new Car());
        }
        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(parkingLot1, parkingLot2));
        Car car = new Car();
        //when
        Exception e = assertThrows(FullParkingLotException.class,() ->parkingBoy.park(car));
        assertEquals("No available position.",e.getMessage());
    }
}