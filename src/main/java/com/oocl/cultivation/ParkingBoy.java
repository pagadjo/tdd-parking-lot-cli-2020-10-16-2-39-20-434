package com.oocl.cultivation;

public class ParkingBoy {
    final ParkingLot parkingLot;
    public ParkingBoy(ParkingLot parkingLot){
        this.parkingLot = parkingLot;
    }
    public ParkingTicket park(Car car){
        return new ParkingTicket();
    }

    public Car fetch(ParkingTicket parkingTicket) {
        return null;
    }
}
