package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SmartParkingBoyTest extends ParkingBoyTest{
    private Car car1 = new Car();
    private Car car2 = new Car();
    private ParkingLot parkingLot1 = new ParkingLot();
    private ParkingLot parkingLot2 = new ParkingLot();
    private List<ParkingLot> parkingLotList = new ArrayList<>();

    @Test
    void should_park_in_second_parking_lot_when_parking_cars_given_second_parking_lot_has_more_spaces() {
        //given
        parkingLot1.setCapacity(10);
        parkingLot2.setCapacity(15);
        parkingLotList.add(parkingLot1);
        parkingLotList.add(parkingLot2);

        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLotList);
        //when
        smartParkingBoy.park(car1);
        smartParkingBoy.park(car2);
        //then
        assertEquals(2, parkingLot2.parkedCarsCount());

    }
}