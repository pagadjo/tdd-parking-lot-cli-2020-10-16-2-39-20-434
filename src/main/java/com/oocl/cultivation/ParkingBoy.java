package com.oocl.cultivation;

import static java.util.Objects.isNull;

public class ParkingBoy {
    private final ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingTicket park(Car car){
        return parkingLot.park(car);
    }

    public Car fetch(ParkingTicket parkingTicket){
        if (isNull(parkingTicket)) {
            throw new TicketNotProvidedException("Please provide your parking ticket.");
        }
        return parkingLot.fetch(parkingTicket);
    }
}
