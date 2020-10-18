package com.oocl.cultivation;

import java.util.List;

public class ParkingLotManager extends ParkingBoy {
    private List<ParkingLot> parkingLotList;
    private List<ParkingBoy> parkingLotBoysList;

    public ParkingLotManager(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
        this.parkingLotList = parkingLotList;
    }

    public ParkingLotManager(List<ParkingBoy> parkingBoysList, List<ParkingLot> parkingLotList) {
        super(parkingLotList);
        this.parkingLotBoysList = parkingBoysList;
        this.parkingLotList = parkingLotList;
    }

    public int parkingBoysListCount() {
        return parkingLotBoysList.size();
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
