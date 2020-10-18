package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SuperSmartParkingBoyTest {

    void parkManyCars(SuperSmartParkingBoy superSmartParkingBoy, int carCount) {
        Car car = new Car();
        for (int x = 0; x <= carCount; x++) {
            superSmartParkingBoy.park(car);
        }
    }

    @Test
    void should_park_in_second_parking_lot_when_parking_cars_given_second_parking_lot_has_larger_available_position_rate() {
        //given
        Car car1 = new Car();
        ParkingLot parkingLot1 = new ParkingLot(15);
        ParkingLot parkingLot2 = new ParkingLot(20);
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(parkingLot1);
        parkingLotList.add(parkingLot2);

        SuperSmartParkingBoy superSmartParkingBoy;
        superSmartParkingBoy = new SuperSmartParkingBoy(Collections.singletonList(parkingLot1));
        parkManyCars(superSmartParkingBoy, 3);
        superSmartParkingBoy = new SuperSmartParkingBoy(Collections.singletonList(parkingLot2));
        parkManyCars(superSmartParkingBoy, 5);
        //when
        superSmartParkingBoy = new SuperSmartParkingBoy(parkingLotList);
        superSmartParkingBoy.park(car1);
        ParkingTicket parkingTicketOfCar1 = superSmartParkingBoy.park(car1);
        //then
        assertNotNull(parkingLot1.fetch(parkingTicketOfCar1));

    }

}