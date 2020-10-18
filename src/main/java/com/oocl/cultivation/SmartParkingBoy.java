package com.oocl.cultivation;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class SmartParkingBoy extends ParkingBoy {
    private List<ParkingLot> parkingLotList;

    public SmartParkingBoy(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
        this.parkingLotList = parkingLotList;
    }

    @Override
    public ParkingTicket park(Car car) {
        ParkingLot parkingLot = Collections.max(parkingLotList, Comparator.comparing(ParkingLot::availableParkingSpace));
        return parkingLot.park(car);
    }

}


