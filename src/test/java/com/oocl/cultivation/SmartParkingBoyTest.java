package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SmartParkingBoyTest {

    @Test
    void should_park_in_second_parking_lot_when_parking_cars_given_second_parking_lot_has_more_spaces() {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingLot parkingLot1 = new ParkingLot(3);
        ParkingLot parkingLot2 = new ParkingLot(1);
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(parkingLot1);
        parkingLotList.add(parkingLot2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLotList);
        //when
        smartParkingBoy.park(car1);
        ParkingTicket parkingTicketOfCar2 = smartParkingBoy.park(car2);
        //then
        assertNotNull(parkingLot1.fetch(parkingTicketOfCar2));
    }

}