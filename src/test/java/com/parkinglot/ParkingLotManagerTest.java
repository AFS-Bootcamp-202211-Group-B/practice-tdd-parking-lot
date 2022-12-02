package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotManagerTest {

    @Test
    void should_park_to_first_parking_lot_when_park_car_given_standard_manager_manages_two_parking_lots_both_available() {
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


}