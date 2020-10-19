package com.oocl.cultivation;

import static com.oocl.cultivation.Constants.NOT_ENOUGH_POSITION;
import static com.oocl.cultivation.Constants.UNRECOGNIZED_PARKING_TICKET;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotManager extends ParkingBoy {
    private List<ParkingLot> parkingLotList;
    private List<ParkingBoy> parkingLotBoysList;

    public ParkingLotManager(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
        parkingLotBoysList = new ArrayList<>();
    }

    public void addParkingBoyToList(ParkingBoy parkingBoy) {
        parkingLotBoysList.add(parkingBoy);
    }

    public int parkingBoysListCount() {
        return parkingLotBoysList.size();
    }

    List<ParkingBoy> getParkingLotBoysList(List<ParkingBoy> parkingBoysList) {
        return this.parkingLotBoysList = parkingBoysList;
    }

    public ParkingTicket park(Car car, ParkingBoy parkingBoy) {
        if (parkingLotBoysList.contains(parkingBoy)) {
            return parkingBoy.park(car);
        } else {
            throw new NotEnoughPositionException(NOT_ENOUGH_POSITION);
        }
    }

    public Car fetch(ParkingTicket parkingTicket, ParkingBoy parkingBoy) {
        if (parkingLotBoysList.contains(parkingBoy)) {
            return parkingBoy.fetch(parkingTicket);
        } else {
            throw new UnrecognizedParkingTicketException(UNRECOGNIZED_PARKING_TICKET);
        }
    }
}
