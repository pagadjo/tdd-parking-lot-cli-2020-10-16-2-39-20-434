package com.oocl.cultivation;

import java.util.List;

import static java.util.Objects.isNull;

public class ParkingBoy {
    private List<ParkingLot> parkingLotList;

    public ParkingBoy(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
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

    public Car fetch(ParkingTicket parkingTicket) {
        if (isNull(parkingTicket)) {
            throw new TicketNotProvidedException("Please provide your parking ticket.");
        }

        Car car = null;
        for (ParkingLot parkingLot : parkingLotList) {
            car = parkingLot.fetch(parkingTicket);
        }
        if (isNull(car)) {
            throw new UnrecognizedParkingTicketException("Wrong Ticket! Kindly provide a correct one.");
        }
        return car;
    }
}
