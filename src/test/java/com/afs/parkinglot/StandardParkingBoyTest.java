package com.afs.parkinglot;

import com.afs.parkinglot.parkingBoy.StandardParkingBoy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StandardParkingBoyTest  {
    private ParkingLot parkingLot1;
    private ParkingLot parkingLot2;
    private StandardParkingBoy standardParkingBoy;
    private Car testCar;

    @BeforeEach
    void setUp() {
        parkingLot1 = new ParkingLot(1);
        parkingLot2 = new ParkingLot(1);
        List<ParkingLot> parkingLots = Arrays.asList(parkingLot1, parkingLot2);
        standardParkingBoy = new StandardParkingBoy(parkingLots);
        testCar = new Car();
    }

    // Case 1: 两个停车场都有空位，停在靠前的停车场
    @Test
    void should_park_in_first_lot_when_given_both_lots_have_space() {
        PlateTicket ticket = standardParkingBoy.park(testCar);
        assertNotNull(ticket);
        assertEquals(testCar, parkingLot1.fetch(ticket));
    }

    // Case 2: 第一个停车场满了，停在第二个
    @Test
    void should_park_in_another_lot_when_given_first_lot_is_full() {
        parkingLot1.park(new Car());
        PlateTicket ticket = standardParkingBoy.park(testCar);
        assertNotNull(ticket);
        assertEquals(testCar, parkingLot2.fetch(ticket));
    }

}
