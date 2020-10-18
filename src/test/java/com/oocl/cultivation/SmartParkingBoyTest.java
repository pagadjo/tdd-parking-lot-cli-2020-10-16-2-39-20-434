package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SmartParkingBoyTest {

//    void parkManyCars(SmartParkingBoy smartParkingBoy, int carCount) {
//        Car car = new Car();
//        for (int x = 0; x <= carCount; x++) {
//            smartParkingBoy.park(car);
//        }
//    }

    @Test
    void should_park_in_second_parking_lot_when_parking_cars_given_second_parking_lot_has_more_spaces() {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        ParkingLot parkingLot1 = new ParkingLot(2);
        ParkingLot parkingLot2 = new ParkingLot(10);
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(parkingLot1);
        parkingLotList.add(parkingLot2);

        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLotList);
        //when
        smartParkingBoy.park(car1);
        smartParkingBoy.park(car2);
        ParkingTicket parkingTicketOfCar3 = smartParkingBoy.park(car3);
        //then
        assertNotNull(parkingLot2.fetch(parkingTicketOfCar3));

    }

}