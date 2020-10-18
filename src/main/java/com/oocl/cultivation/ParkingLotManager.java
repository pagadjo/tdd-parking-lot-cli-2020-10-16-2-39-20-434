package com.oocl.cultivation;

import java.util.List;

public class ParkingLotManager extends ParkingBoy {
    List<ParkingLot> parkingLotList;

    public ParkingLotManager(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
    }

    public ParkingTicket park(Car car) {
        if (parkingLotList.size() > 1) {
            for (int x = 0; x < parkingLotList.size(); x++) {
                if (parkingLotList.get(x).isParkingLotFull()) {
                    continue;
                } else {
                    return parkingLotList.get(x).park(car);
                }
            }
        }
        return parkingLotList.get(0).park(car);
    }
}
