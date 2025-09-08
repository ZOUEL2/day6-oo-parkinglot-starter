package com.afs.parkinglot;


import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private final int capacity;

    private Map<PlateTicket, Car> carsInParking;

    private String lastErrorMessage;
    private static final String UNRECOGNIZED_PARKING_TICKET = "Unrecognized parking ticket.";
    private static final String NO_AVAILABLE_POSITION = "No available position.";


    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.carsInParking = new HashMap<>();
        this.lastErrorMessage = null;
    }

    public void clearErrorMessage() {
        lastErrorMessage = null;
    }

    public PlateTicket park(Car car) {
        clearErrorMessage();
        if (car == null || isFull()) {
            lastErrorMessage = NO_AVAILABLE_POSITION;
            return null;
        }
        PlateTicket plateTicket = new PlateTicket();
        carsInParking.put(plateTicket, car);
        return plateTicket;

    }

    public Car fetch(PlateTicket plateTicket) {
        clearErrorMessage();
        if (plateTicket == null || !carsInParking.containsKey(plateTicket)) {
            lastErrorMessage = UNRECOGNIZED_PARKING_TICKET;
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

    public String getLastErrorMessage() {
        return lastErrorMessage;
    }

    public int getCapacity() {
        return capacity;
    }

}
