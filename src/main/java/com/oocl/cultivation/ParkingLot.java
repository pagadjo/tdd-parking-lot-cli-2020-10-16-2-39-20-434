package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final Map<ParkingTicket, Car> mapTicketCar = new HashMap<>();

    public ParkingTicket park(Car car) {
        ParkingTicket newTicket = new ParkingTicket();
        mapTicketCar.put(newTicket, car);
        return newTicket;
    }

    public Car fetch(ParkingTicket parkingTicket) {
        return mapTicketCar.get(parkingTicket);
    }
}
