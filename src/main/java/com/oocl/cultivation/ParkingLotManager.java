package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotManager extends ParkingBoy {
    private List<ParkingLot> parkingLotList;
    private List<ParkingBoy> parkingLotBoysList;

    public ParkingLotManager(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
        parkingLotBoysList = new ArrayList<>();
    }


    public void addParkingBoyToList(ParkingBoy parkingBoy){
        parkingLotBoysList.add(parkingBoy);
    }

    public int parkingBoysListCount() {
        return parkingLotBoysList.size();
    }

    List<ParkingBoy> getParkingLotBoysList(List<ParkingBoy> parkingBoysList){
        return this.parkingLotBoysList = parkingBoysList;
    }
}
