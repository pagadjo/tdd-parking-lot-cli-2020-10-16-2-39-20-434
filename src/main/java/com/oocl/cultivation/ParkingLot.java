package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.isNull;

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
            System.out.println(capacity);
            return newTicket;
        } else {
            throw new NotEnoughPositionException("Not Enough Position!");
        }
    }

    public Car fetch(ParkingTicket parkingTicket) {
        Car car = mapTicketCar.get(parkingTicket);
        mapTicketCar.remove(parkingTicket);
        if (isNull(car)) {
            throw new UnrecognizedParkingTicketException("Wrong Ticket! Kindly provide a correct one.");
        }
        return car;
    }

    public Boolean isParkingLotFull() {
        return mapTicketCar.size() >= capacity;
    }
}
