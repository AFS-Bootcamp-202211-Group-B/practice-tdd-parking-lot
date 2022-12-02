package com.parkinglot;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingBoyTest {

    @Test
    void should_return_ticket_when_park_car_given_parking_boy_and_car() {


        ParkingLot parkingLot = new ParkingLot();
        List<ParkingLot> parkingLots = new ArrayList<>();
        Car car = new Car();
        parkingLots.add(parkingLot);
        StandardParkingBoy parKingBoy = new StandardParkingBoy(parkingLots);

        //When
        Ticket ticket = parKingBoy.park(car);

        //Then
        assertNotNull(ticket);
    }
    @Test
    void should_return_parked_car_when_get_car_given_parking_boy_with_the_parked_car(){
        ///Given
        ParkingLot parkingLot = new ParkingLot();
        List<ParkingLot> parkingLots = new ArrayList<>();
        Car car = new Car();
        parkingLots.add(parkingLot);
        StandardParkingBoy parKingBoy = new StandardParkingBoy(parkingLots);
        Ticket ticket = parKingBoy.park(car);

        //When
        Car parkedCar = parKingBoy.getCar(ticket);

        //Then
        assertEquals(car , parkedCar);
    }

    @Test
    void should_return_the_right_car_with_each_ticket_when_get_car_twice_given_a_parking_boy_with_two_parked_cars(){
        ///Given

        ParkingLot parkingLots1 = new ParkingLot();
        ParkingLot parkingLots2 = new ParkingLot();

        List<ParkingLot> parkingLots = new ArrayList<>();

        StandardParkingBoy parKingBoy = new StandardParkingBoy(parkingLots);
        Car car = new Car();
        Car car2 = new Car();

        parkingLots.add(parkingLots1);
        parkingLots.add(parkingLots2);

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
        List<ParkingLot> parkingLots = new ArrayList<>();
        StandardParkingBoy parKingBoy = new StandardParkingBoy(parkingLots);
        Ticket unrecognizedParkingTicket = new Ticket();

        //When

        //Then
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () -> parKingBoy.getCar(unrecognizedParkingTicket));
        assertEquals("Unrecognized Parking Ticket", exception.getMessage());

    }
    @Test
    void should_return_null_when_parking_boy_get_a_car_use_a_used_ticket(){
        ///Given
        ParkingLot parkingLot = new ParkingLot();
        List<ParkingLot> parkingLots = new ArrayList<>();
        Car car = new Car();
        parkingLots.add(parkingLot);
        StandardParkingBoy parKingBoy = new StandardParkingBoy(parkingLots);
        Ticket ticket = parKingBoy.park(car);
        parKingBoy.getCar(ticket);
        //When

        //Then
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () -> parKingBoy.getCar(ticket));
        assertEquals("Unrecognized Parking Ticket", exception.getMessage());
    }
    @Test
    void should_return_null_when_park_given_full_parking_lot(){
        ///Given
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);

        Car firstCar = new Car();
        Car secondCar = new Car();


        firstParkingLot.park(firstCar);
        secondParkingLot.park(secondCar);

        List<ParkingLot> parkingLots = new ArrayList<>();

        parkingLots.add(firstParkingLot);
        parkingLots.add(secondParkingLot);

        StandardParkingBoy parkingBoy = new StandardParkingBoy(parkingLots);


        Exception exception = assertThrows(NoAvailablePosition.class, () -> parkingBoy.park(new Car()));
        assertEquals("No available position", exception.getMessage());

    }

}