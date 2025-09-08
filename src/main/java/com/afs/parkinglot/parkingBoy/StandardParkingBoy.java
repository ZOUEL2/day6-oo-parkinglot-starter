package com.afs.parkinglot.parkingBoy;

import com.afs.parkinglot.Car;
import com.afs.parkinglot.ParkingLot;
import com.afs.parkinglot.PlateTicket;

import java.util.List;

public class StandardParkingBoy extends AbstractParkingBoy {
    private static final String NO_AVAILABLE_POSITION = "No available position.";

    public StandardParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public PlateTicket park(Car car) {
        clearErrorMessage();

        if (car == null) {
            return null;
        }

        // 按照顺序查找第一个有空位的停车场
        for (ParkingLot parkingLot : parkingLots) {
            if (!parkingLot.isFull()) {
                return parkingLot.park(car);
            }
        }

        lastErrorMessage = NO_AVAILABLE_POSITION;
        return null;
    }
}