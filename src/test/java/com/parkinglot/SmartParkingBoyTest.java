package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmartParkingBoyTest {
    @Test
    void should_park_to_first_parking_lot_when_park_given_2_parking_lots_both_with_same_available_position() {
        //given
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(firstParkingLot);
        parkingLots.add(secondParkingLot);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Car car = new Car();
        //when
        smartParkingBoy.park(car);
        //then
        assertEquals(1,firstParkingLot.getParkedCar().size());
        assertEquals(0,secondParkingLot.getParkedCar().size());
    }

    @Test
    void should_park_to_second_parking_lot_when_park_given_2_parking_lots_first_one_has_less_available_postiion_than_second_one() {
        //given
        ParkingLot firstParkingLot = new ParkingLot(2);
        ParkingLot secondParkingLot = new ParkingLot(2);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(firstParkingLot);
        parkingLots.add(secondParkingLot);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Car aliceCar = new Car();
        smartParkingBoy.park(aliceCar);
        Car bobCar = new Car();
        //when
        smartParkingBoy.park(bobCar);
        //then
        assertEquals(1,firstParkingLot.getParkedCar().size());
        assertEquals(1,secondParkingLot.getParkedCar().size());
    }
}
