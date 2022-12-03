package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotManagerTest {

    @Test
    void should_return_park_ticket_to_first_parking_lot_when_two_parking_lots_both_available() {
        // given
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();

        List<ParkingLot> parkingLots = new ArrayList<>();

        parkingLots.add(firstParkingLot);
        parkingLots.add(secondParkingLot);

        ParkingLotManager parkingLotManager = new ParkingLotManager(parkingLots);

        // when
        Ticket ticket = parkingLotManager.park(new Car());

        // then
        assertNotNull(ticket);
        assertEquals(9, firstParkingLot.getAvailablePositionCount());
        assertEquals(10, secondParkingLot.getAvailablePositionCount());
    }
    @Test
    void should_return_park_car_ticket_when_only_second_parking_lots_available_first_parking_lots_is_full() {
        // given
        ParkingLot firstParkingLot = new ParkingLot(0);
        ParkingLot secondParkingLot = new ParkingLot();

        List<ParkingLot> parkingLots = new ArrayList<>();

        parkingLots.add(firstParkingLot);
        parkingLots.add(secondParkingLot);
        ParkingLotManager parkingLotManager = new ParkingLotManager(parkingLots);

        // when
        Ticket ticket = parkingLotManager.park(new Car());

        // then
        assertNotNull(ticket);
        assertEquals(0, firstParkingLot.getAvailablePositionCount());
        assertEquals(9, secondParkingLot.getAvailablePositionCount());
    }
    @Test
    void should_return_the_right_car_with_each_ticket_when_get_car_twice_two_lots_both_with_parked_cars_and_two_parking_tickets() {

        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();

        List<ParkingLot> parkingLots = new ArrayList<>();



        Car firstCar = new Car();
        Car secondCar = new Car();

        Ticket firstTicket = firstParkingLot.park(firstCar);
        Ticket secondTicket = secondParkingLot.park(secondCar);


        parkingLots.add(firstParkingLot);
        parkingLots.add(secondParkingLot);

        ParkingLotManager parkingLotManager = new ParkingLotManager(parkingLots);


    }
}