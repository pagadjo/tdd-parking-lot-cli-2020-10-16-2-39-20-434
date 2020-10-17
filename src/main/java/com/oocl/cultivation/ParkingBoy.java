package com.oocl.cultivation;

import java.util.List;

import static java.util.Objects.isNull;

public class ParkingBoy {
    private List<ParkingLot> parkingLotList;

    public ParkingBoy(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    public ParkingTicket park(Car car) {
        for (int x = 0; x < parkingLotList.size(); x++) {
            if (parkingLotList.get(0).isParkingLotFull()) {
                if (parkingLotList.size() > 1) {
                    return parkingLotList.get(1).park(car);
                } else {
                    throw new NotEnoughPositionException("Not Enough Position!");
                }
            }
        }
        return parkingLotList.get(0).park(car);
    }

    public Car fetch(ParkingTicket parkingTicket) {
        if (isNull(parkingTicket)) {
            throw new TicketNotProvidedException("Please provide your parking ticket.");
        }
        return parkingLotList.get(0).fetch(parkingTicket);
    }
}
