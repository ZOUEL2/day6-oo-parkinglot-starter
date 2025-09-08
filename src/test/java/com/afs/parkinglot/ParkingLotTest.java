package com.afs.parkinglot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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



}
