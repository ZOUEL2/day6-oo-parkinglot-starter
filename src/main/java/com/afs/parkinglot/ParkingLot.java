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
        if (capacity > 0) {
            PlateTicket plateTicket = new PlateTicket();
            carsInParking.put(plateTicket, car);
            return plateTicket;
        } else {
            throw new RuntimeException("车位已满");
        }
    }

    public Car fetch(PlateTicket plateTicket) {
        if (plateTicket == null || !carsInParking.containsKey(plateTicket)) {
            throw new RuntimeException("无效的车票");
        }
        return carsInParking.remove(plateTicket);
    }

}
