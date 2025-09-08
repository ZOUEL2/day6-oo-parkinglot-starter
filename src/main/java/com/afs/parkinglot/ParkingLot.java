package com.afs.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private final int capacity;

    private Map<PlateTicket, Car> carsInParking;

    public ParkingLot() {
        this(10);
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.carsInParking = new HashMap<>();
    }

    public PlateTicket park(Car car) {
        if (car == null || isFull()) {
            return null;
        }
        PlateTicket plateTicket = new PlateTicket();
        carsInParking.put(plateTicket, car);
        return plateTicket;

    }

    public Car fetch(PlateTicket plateTicket) {
        if (plateTicket == null || !carsInParking.containsKey(plateTicket)) {
            return null;
        }
        return carsInParking.remove(plateTicket);
    }

    public boolean isFull() {
        return carsInParking.size() >= capacity;
    }

    public int getAvailableSpots() {
        return capacity - carsInParking.size();
    }
}
