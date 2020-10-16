package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Map<ParkingTicket, Car> mapTicketCar = new HashMap<>();
    private int capacity;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public ParkingTicket park(Car car) {
        if (!isParkingLotFull()) {
            ParkingTicket newTicket = new ParkingTicket();
            mapTicketCar.put(newTicket, car);
            return newTicket;
        }
        return null;
    }

    public Car fetch(ParkingTicket parkingTicket) {
        Car car = mapTicketCar.get(parkingTicket);
        mapTicketCar.remove(parkingTicket);
        return car;
    }

    public Boolean isParkingLotFull() {
        return mapTicketCar.size() == capacity;
    }
}
