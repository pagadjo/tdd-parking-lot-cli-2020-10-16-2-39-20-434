package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SuperSmartParkingBoyTest extends ParkingBoyTest{

    private ParkingLot parkingLot1 = new ParkingLot();
    private ParkingLot parkingLot2 = new ParkingLot();
    @Test
    void should_park_in_first_parking_lot_when_parking_a_car_given_first_parking_lot_has_larger_available_position_rate() {
        //given
        parkingLot1.setCapacity(15);
        parkingLot2.setCapacity(20);
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(parkingLot1);
        parkingLotList.add(parkingLot2);

        SuperSmartParkingBoy superSmartParkingBoy;
        superSmartParkingBoy = new SuperSmartParkingBoy(parkingLotList);
        //when
        parkManyCars(superSmartParkingBoy, 3);
        //then
        assertEquals(2, parkingLot2.parkedCarsCount());

    }

}