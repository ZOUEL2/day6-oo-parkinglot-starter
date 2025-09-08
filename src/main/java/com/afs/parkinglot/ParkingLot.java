package com.afs.parkinglot;

import java.util.HashMap;

public class ParkingLot {

    private final int capacity;

    private HashMap<PlateTicket, Car> carsInParking = new HashMap<>();

    public ParkingLot(int capacity) {
        this.capacity = capacity;
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
