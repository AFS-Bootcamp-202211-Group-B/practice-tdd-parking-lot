package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
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

        ParkingLotManager parkingLotManager = new ParkingLotManager(parkingLots,null);

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
        ParkingLotManager parkingLotManager = new ParkingLotManager(parkingLots,null);

        // when
        Ticket ticket = parkingLotManager.park(new Car());

        // then
        assertNotNull(ticket);
        assertEquals(0, firstParkingLot.getAvailablePositionCount());
        assertEquals(9, secondParkingLot.getAvailablePositionCount());
    }
    @Test
    void should_return_the_right_car_with_each_ticket_when_get_car_twice_two_lots_both_with_parked_cars_and_two_parking_tickets() {
        //given
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot secondParkingLot = new ParkingLot();

        List<ParkingLot> parkingLots = new ArrayList<>();



        Car firstCar = new Car();
        Car secondCar = new Car();

        Ticket firstTicket = firstParkingLot.park(firstCar);
        Ticket secondTicket = secondParkingLot.park(secondCar);



        parkingLots.add(firstParkingLot);
        parkingLots.add(secondParkingLot);

        ParkingLotManager parkingLotManager = new ParkingLotManager(parkingLots,null);
        //when
        Car firstParkedCar = parkingLotManager.getCar(firstTicket);
        Car secondParkedCar = parkingLotManager.getCar(secondTicket);
        //then
        assertEquals(firstCar, firstParkedCar);
        assertEquals(secondCar, secondParkedCar);

    }

    @Test
    void should_throw_unrecognized_parking_ticket_exception_when__parking_boys_with_a_lot_an_unrecognized_ticket() {
        // given
        ParkingLot firstBoyParkingLot = new ParkingLot();
        ParkingLot secondBoyParkingLot = new ParkingLot();

        firstBoyParkingLot.park(new Car());
        secondBoyParkingLot.park(new Car());

        List<ParkingLot> firstBoyParkingLots = new ArrayList<>();
        List<ParkingLot> secondBoyParkingLots = new ArrayList<>();

        firstBoyParkingLots.add(firstBoyParkingLot);
        secondBoyParkingLots.add(secondBoyParkingLot);

        StandardParkingBoy firstParkingBoy = new StandardParkingBoy(firstBoyParkingLots);
        StandardParkingBoy secondParkingBoy = new StandardParkingBoy(secondBoyParkingLots);

        List<StandardParkingBoy> parkingBoys = Arrays.asList(firstParkingBoy, secondParkingBoy);

        ParkingLotManager parkingLotManager = new ParkingLotManager(null,parkingBoys);

        Ticket ticket = new Ticket();

        // when
        // then
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () -> parkingLotManager.getCar(firstParkingBoy, ticket));
        assertEquals("Unrecognized Parking Ticket", exception.getMessage());

    }

    @Test
    void should_throw_unrecognized_parking_ticket_exception_when_parking_boys_with_a_lot_an_used_ticket() {
        // given
        ParkingLot firstBoyParkingLot = new ParkingLot();
        ParkingLot secondBoyParkingLot = new ParkingLot();

        Ticket ticket = firstBoyParkingLot.park(new Car());
        secondBoyParkingLot.park(new Car());

        List<ParkingLot> firstBoyParkingLots = new ArrayList<>();
        List<ParkingLot> secondBoyParkingLots = new ArrayList<>();

        firstBoyParkingLots.add(firstBoyParkingLot);
        secondBoyParkingLots.add(secondBoyParkingLot);

        StandardParkingBoy firstParkingBoy = new StandardParkingBoy(firstBoyParkingLots);
        StandardParkingBoy secondParkingBoy = new StandardParkingBoy(secondBoyParkingLots);

        List<StandardParkingBoy> parkingBoys = Arrays.asList(firstParkingBoy, secondParkingBoy);

        ParkingLotManager parkingLotManager = new ParkingLotManager(null,parkingBoys);

        parkingLotManager.getCar(firstParkingBoy, ticket);

        // when
        // then
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () -> parkingLotManager.getCar(firstParkingBoy, ticket));
        assertEquals("Unrecognized Parking Ticket", exception.getMessage());

    }
    @Test
    void should_throw_no_available_position_exception_when_two_parking_boys_manage_two_lots_without_any_position() {
        // given
        ParkingLot firstBoyParkingLot = new ParkingLot(1);
        ParkingLot secondBoyParkingLot = new ParkingLot(1);

        firstBoyParkingLot.park(new Car());
        secondBoyParkingLot.park(new Car());

        List<ParkingLot> firstBoyParkingLots = new ArrayList<>();
        List<ParkingLot> secondBoyParkingLots = new ArrayList<>();

        firstBoyParkingLots.add(firstBoyParkingLot);
        secondBoyParkingLots.add(secondBoyParkingLot);

        StandardParkingBoy firstParkingBoy = new StandardParkingBoy(firstBoyParkingLots);
        StandardParkingBoy secondParkingBoy = new StandardParkingBoy(secondBoyParkingLots);

        List<StandardParkingBoy> parkingBoys = Arrays.asList(firstParkingBoy, secondParkingBoy);

        ParkingLotManager parkingLotManager = new ParkingLotManager(null, parkingBoys);

        // when
        // then
        Exception exception = assertThrows(NoAvailablePosition.class, () -> parkingLotManager.park(firstParkingBoy, new Car()));
        assertEquals("No available position", exception.getMessage());
    }
}


