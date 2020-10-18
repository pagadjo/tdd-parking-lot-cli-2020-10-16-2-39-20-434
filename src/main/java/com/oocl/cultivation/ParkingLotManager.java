package com.oocl.cultivation;

import java.util.List;

public class ParkingLotManager extends ParkingBoy{
    private List<ParkingLot> parkingLotList;
    public ParkingLotManager(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
        this.parkingLotList = parkingLotList;
    }
    public ParkingTicket park(Car car) {
        if (parkingLotList.size() > 1) {
            for (ParkingLot parkingLot : parkingLotList) {
                if (parkingLot.isParkingLotFull()) {
                    continue;
                } else {
                    return parkingLot.park(car);
                }
            }
        }
        return parkingLotList.get(0).park(car);
    }
}
