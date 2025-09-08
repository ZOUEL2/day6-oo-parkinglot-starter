package com.afs.parkinglot;

import com.afs.parkinglot.parkingBoy.SmartParkingBoy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmartParkingBoyTest {
    private ParkingLot parkingLot1;
    private ParkingLot parkingLot2;
    private SmartParkingBoy smartParkingBoy;
    private Car testCar;

    @BeforeEach
    void setUp() {
        parkingLot1 = new ParkingLot(2);
        parkingLot2 = new ParkingLot(3);
        List<ParkingLot> parkingLots = Arrays.asList(parkingLot1, parkingLot2);
        smartParkingBoy = new SmartParkingBoy(parkingLots);
        testCar = new Car();
    }

    // Case1: 两个停车场都有空位，停在空位更多的停车场
    @Test
    void should_park_in_lot_with_more_available_positions() {
        PlateTicket ticket = smartParkingBoy.park(testCar);
        assert ticket != null;
        assertEquals(testCar, parkingLot2.fetch(ticket));
    }

}
