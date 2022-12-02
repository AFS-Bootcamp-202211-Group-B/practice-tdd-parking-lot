package com.parkinglot;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingBoyTest {

    @Test
    void should_return_ticket_when_park_car_given_parking_boy_and_car() {
        ///Given
        ParkingLot parkingLot = new ParkingLot();
        StandardParkingBoy parKingBoy = new StandardParkingBoy(parkingLot);
        Car car = new Car();

        //When
        Ticket ticket = parKingBoy.park(car);

        //Then
        assertNotNull(ticket);
    }
    @Test
    void should_return_parked_car_when_get_car_given_parking_boy_with_the_parked_car(){
        ///Given
        ParkingLot parkingLot = new ParkingLot();
        StandardParkingBoy parKingBoy = new StandardParkingBoy(parkingLot);
        Car car = new Car();
        Ticket ticket = parKingBoy.park(car);

        //When
        Car parkedCar = parKingBoy.getCar(ticket);

        //Then
        assertEquals(car , parkedCar);
    }

    @Test
    void should_return_the_right_car_with_each_ticket_when_get_car_twice_given_a_parking_boy_with_two_parked_cars(){
        ///Given
        ParkingLot parkingLot = new ParkingLot();
        StandardParkingBoy parKingBoy = new StandardParkingBoy(parkingLot);
        Car car = new Car();
        Car car2 = new Car();

        Ticket ticket = parKingBoy.park(car);
        Ticket ticket2= parKingBoy.park(car2);

        //When
        Car parkedCar = parKingBoy.getCar(ticket);
        Car parkedCar2 = parKingBoy.getCar(ticket2);

        //Then
        assertEquals(car , parkedCar);
        assertEquals(car2 , parkedCar2);
    }

    @Test
    void should_return_exception_when_giving_parking_boy_unrecognized_ticket_to_get_the_car(){
        ///Given
        ParkingLot parkingLot = new ParkingLot();
        StandardParkingBoy parKingBoy = new StandardParkingBoy(parkingLot);
        Ticket unrecognizedParkingTicket = new Ticket();

        //When

        //Then
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () -> parKingBoy.getCar(unrecognizedParkingTicket));
        assertEquals("Unrecognized Parking Ticket", exception.getMessage());

    }
}