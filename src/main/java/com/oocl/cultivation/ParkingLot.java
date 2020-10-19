package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

import static com.oocl.cultivation.Constants.NOT_ENOUGH_POSITION;

public class ParkingLot {
    private Map<ParkingTicket, Car> mapTicketCar = new HashMap<>();
    private int capacity;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    ParkingTicket park(Car car) {
        if (Boolean.FALSE.equals(isParkingLotFull())) {
            ParkingTicket newTicket = new ParkingTicket();
            mapTicketCar.put(newTicket, car);
            return newTicket;
        } else {
            throw new NotEnoughPositionException(NOT_ENOUGH_POSITION);
        }
    }

    Car fetch(ParkingTicket parkingTicket) {
        Car car = mapTicketCar.get(parkingTicket);
        mapTicketCar.remove(parkingTicket);
        return car;
    }

    Boolean isParkingLotFull() {
        return mapTicketCar.size() >= capacity;
    }

    int availableParkingSpace() {
        return capacity - mapTicketCar.size();
    }

    double positionRate() {
        return (double) availableParkingSpace() / (double) capacity;
    }

    int parkedCarsCount(){
        return mapTicketCar.size();
    }
}
