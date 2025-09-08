package com.afs.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingLotTest {

    @Test
    void should_return_a_parking_ticket_when_given_parkingLot_and_car(){
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car();
        PlateTicket plateTicket = parkingLot.park(car);

        assertNotNull(plateTicket);
    }

    @Test
    void should_return_a_car_when_given_parkingLot_and_plateTicket(){
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car();
        PlateTicket plateTicket = parkingLot.park(car);
        Car fetchedCar = parkingLot.fetch(plateTicket);

        assertNotNull(fetchedCar);
    }


}
