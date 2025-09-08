package com.afs.parkinglot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {
    private ParkingLot parkingLot;
    private Car testCar;

    @BeforeEach
    void setUp() {
        parkingLot = new ParkingLot(2);
        testCar = new Car();
    }

    @Test
    void should_return_a_parking_ticket_when_given_parkingLot_and_car() {
        PlateTicket plateTicket = parkingLot.park(testCar);
        assertNotNull(plateTicket);
        assertEquals(testCar, parkingLot.fetch(plateTicket));
    }

    @Test
    void should_park_multiple_cars_and_fetch_them_correctly() {
        Car car1 = new Car();
        Car car2 = new Car();
        PlateTicket ticket1 = parkingLot.park(car1);
        PlateTicket ticket2 = parkingLot.park(car2);
        assertNotEquals(ticket1, ticket2);
        assertEquals(car1, parkingLot.fetch(ticket1));
        assertEquals(car2, parkingLot.fetch(ticket2));
    }

    @Test
    void should_not_fetch_car_with_wrong_and_not_ticket() {
        parkingLot.park(testCar);
        PlateTicket wrongTicket = new PlateTicket();

        assertNull(parkingLot.fetch(wrongTicket));
        assertNull(parkingLot.fetch(null));
    }

    @Test
    void should_not_fetch_car_with_used_ticket() {
        PlateTicket plateTicket = parkingLot.park(testCar);

        Car fetchedCar = parkingLot.fetch(plateTicket);
        assertEquals(testCar, fetchedCar);

        assertNull(parkingLot.fetch(plateTicket));
    }


    @Test
    void should_not_park_when_parkinglot_is_full() {
        // 停满停车场
        parkingLot.park(new Car());
        parkingLot.park(new Car());

        assertTrue(parkingLot.isFull());
        assertNull(parkingLot.park(new Car()));
    }






}
