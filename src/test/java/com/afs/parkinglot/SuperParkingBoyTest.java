package com.afs.parkinglot;

import com.afs.parkinglot.parkingBoy.SuperParkingBoy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SuperParkingBoyTest {
    private ParkingLot parkingLot1;
    private ParkingLot parkingLot2;
    private SuperParkingBoy superParkingBoy;
    private Car testCar;

    @BeforeEach
    void setUp() {
        parkingLot1 = new ParkingLot(2);
        parkingLot2 = new ParkingLot(5);
        List<ParkingLot> parkingLots = Arrays.asList(parkingLot1, parkingLot2);
        superParkingBoy = new SuperParkingBoy(parkingLots);
        testCar = new Car();
    }

    // Case1: 两个停车场都有空位，停在空置率更高的停车场
    @Test
    void should_park_in_lot_with_highest_vacancy_rate() {
        PlateTicket ticket = superParkingBoy.park(testCar);

        assertNotNull(ticket);
        assertEquals(testCar, parkingLot1.fetch(ticket));
        assertNull(parkingLot2.fetch(ticket));
    }

    // Case2: 两个停车场都有空位且空置率一致，停在靠前的停车场
    @Test
    void should_park_in_first_lot_when_both_lots_have_same_vacancy_rate() {
      // 初始空置率相同，均为100%

        PlateTicket ticket = superParkingBoy.park(testCar);
        assertNotNull(ticket);
        assertEquals(testCar, parkingLot1.fetch(ticket));
        assertNull(parkingLot2.fetch(ticket));
    }

}
