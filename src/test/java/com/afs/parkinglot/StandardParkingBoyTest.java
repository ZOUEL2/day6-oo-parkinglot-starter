package com.afs.parkinglot;

import com.afs.parkinglot.parkingBoy.StandardParkingBoy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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

    // Case 3: 每个停车场都有车，用正确的票取车
    @Test
    void should_fetch_car_with_correct_ticket_from_both_lots() {
        Car car1 = new Car();
        Car car2 = new Car();

        PlateTicket ticket1 = standardParkingBoy.park(car1);
        PlateTicket ticket2 = standardParkingBoy.park(car2);

        assertEquals(car1, standardParkingBoy.fetch(ticket1));
        assertEquals(car2, standardParkingBoy.fetch(ticket2));
    }

    // Case 4: 管理两个停车场，用错误的票取车
    @Test
    void should_not_fetch_car_with_wrong_ticket() {
        PlateTicket unrecognizedTicket = new PlateTicket();

        Car result = standardParkingBoy.fetch(unrecognizedTicket);

        assertNull(result);
        assertEquals("Unrecognized parking ticket.", standardParkingBoy.getLastErrorMessage());
    }

    // Case 5: 使用过的票取车
    @Test
    void should_not_fetch_car_with_used_ticket() {
        PlateTicket ticket = standardParkingBoy.park(testCar);
        assertEquals(testCar, standardParkingBoy.fetch(ticket));

        Car result = standardParkingBoy.fetch(ticket);

        assertNull(result);
        assertEquals("Unrecognized parking ticket.", standardParkingBoy.getLastErrorMessage());
    }

    // Case 6: 两个停车场都满了，无法停车
    @Test
    void should_not_park_when_both_lots_are_full() {
        parkingLot1.park(new Car());
        parkingLot2.park(new Car());

        PlateTicket ticket = standardParkingBoy.park(testCar);

        assertNull(ticket);
        assertEquals("No available position.", standardParkingBoy.getLastErrorMessage());
    }



}
