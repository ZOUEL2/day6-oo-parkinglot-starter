package com.afs.parkinglot.parkingBoy;

import com.afs.parkinglot.Car;
import com.afs.parkinglot.ParkingLot;
import com.afs.parkinglot.PlateTicket;

import java.util.List;

public class SuperParkingBoy extends AbstractParkingBoy {
    private static final String NO_AVAILABLE_POSITION = "No available position.";

    public SuperParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public PlateTicket park(Car car) {
        ParkingLot selectedLot = null;
        double maxVacancyRate = -1.0;

        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.isFull()) {
                continue;
            }

            double vacancyRate = (double) parkingLot.getAvailableSpots() / parkingLot.getCapacity();
            if (vacancyRate > maxVacancyRate) {
                maxVacancyRate = vacancyRate;
                selectedLot = parkingLot;
            }
        }

        if (selectedLot != null) {
            return selectedLot.park(car);
        }

        lastErrorMessage = NO_AVAILABLE_POSITION;
        return null;
    }
}
