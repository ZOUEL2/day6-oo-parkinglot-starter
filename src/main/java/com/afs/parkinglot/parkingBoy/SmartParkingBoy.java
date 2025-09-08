package com.afs.parkinglot.parkingBoy;

import com.afs.parkinglot.Car;
import com.afs.parkinglot.ParkingLot;
import com.afs.parkinglot.PlateTicket;

import java.util.List;

public class SmartParkingBoy extends AbstractParkingBoy {

    private static final String NO_AVAILABLE_POSITION = "No available position.";

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public PlateTicket park(Car car) {
        clearErrorMessage();
        ParkingLot selectedLot = null;
        int maxAvailableSpots = -1;

        for (ParkingLot parkingLot : parkingLots) {
            int availableSpots = parkingLot.getAvailableSpots();
            if (availableSpots > maxAvailableSpots) {
                maxAvailableSpots = availableSpots;
                selectedLot = parkingLot;
            }
        }

        if (selectedLot != null && !selectedLot.isFull()) {
            return selectedLot.park(car);
        }

        lastErrorMessage = NO_AVAILABLE_POSITION;
        return null;
    }


}
