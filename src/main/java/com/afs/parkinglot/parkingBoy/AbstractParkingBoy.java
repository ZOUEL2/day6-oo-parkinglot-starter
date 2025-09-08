package com.afs.parkinglot.parkingBoy;

// AbstractParkingBoy.java
import com.afs.parkinglot.Car;
import com.afs.parkinglot.ParkingLot;
import com.afs.parkinglot.PlateTicket;

import java.util.List;


public abstract class AbstractParkingBoy implements ParkingBoy {
    protected final List<ParkingLot> parkingLots;
    protected String lastErrorMessage;
    private static final String UNRECOGNIZED_PARKING_TICKET = "Unrecognized parking ticket.";


    public AbstractParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
        this.lastErrorMessage = null;
    }

    @Override
    public Car fetch(PlateTicket plateTicket) {
        clearErrorMessage();

        if (plateTicket == null) {
            lastErrorMessage = UNRECOGNIZED_PARKING_TICKET;
            return null;
        }

        for (ParkingLot parkingLot : parkingLots) {
            Car car = parkingLot.fetch(plateTicket);
            if (car != null) {
                return car;
            }
        }

        lastErrorMessage = UNRECOGNIZED_PARKING_TICKET;
        return null;
    }

    @Override
    public String getLastErrorMessage() {
        return lastErrorMessage;
    }

    @Override
    public void clearErrorMessage() {
        lastErrorMessage = null;
        for (ParkingLot parkingLot : parkingLots) {
            parkingLot.clearErrorMessage();
        }
    }

    public abstract PlateTicket park(Car car);
}