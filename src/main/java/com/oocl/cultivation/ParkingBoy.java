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
