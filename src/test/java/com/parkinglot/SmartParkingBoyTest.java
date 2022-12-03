package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmartParkingBoyTest {


    @Test
    void should_park_to_the_first_parking_lot_when_park_car_given_a_smart_parking_boy_managing_two_lots_with_same_number_of_empty_positions_and_car() {
        // given
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();

        List<ParkingLot> parkingLots = Arrays.asList(firstParkingLot, secondParkingLot);

        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);

        // when
        smartParkingBoy.park(new Car());

        // then
        assertEquals(9, firstParkingLot.getAvailablePositionCount());
        assertEquals(10, secondParkingLot.getAvailablePositionCount());
    }

}
