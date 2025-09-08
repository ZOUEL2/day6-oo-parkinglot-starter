package com.afs.parkinglot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {
    private ParkingLot parkingLot;
    private Car testCar;

    @BeforeEach
    void setUp() {
        parkingLot = new ParkingLot();
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





}
