package com.afs.parkinglot.parkingBoy;

import com.afs.parkinglot.Car;
import com.afs.parkinglot.PlateTicket;

public interface ParkingBoy {
    PlateTicket park(Car car);

    Car fetch(PlateTicket plateTicket);

    String getLastErrorMessage();

    void clearErrorMessage();
}
