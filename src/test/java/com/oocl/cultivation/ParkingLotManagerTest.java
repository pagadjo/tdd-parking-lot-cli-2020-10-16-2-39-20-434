package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotManagerTest {

    @Test
    void should_return_ticket_when_parking_boy_park_car_given_car() {
        //given
        Car car = new Car();
        List<ParkingLot> parkingLotList = Collections.singletonList(new ParkingLot(10));
        ParkingLotManager parkingLotManager = new ParkingLotManager(parkingLotList);
        //when
        ParkingTicket parkingTicket = parkingLotManager.park(car);
        //then
        assertNotNull(parkingTicket);

    }

    @Test
    void should_return_correct_car_when_fetch_given_correct_ticket() {
        //given
        Car car = new Car();
        List<ParkingLot> parkingLotList = Collections.singletonList(new ParkingLot(10));
        ParkingLotManager parkingLotManager = new ParkingLotManager(parkingLotList);
        ParkingTicket parkingTicket = parkingLotManager.park(car);
        //when
        Car expectedCar = parkingLotManager.fetch(parkingTicket);
        //then
        assertSame(car, expectedCar);
    }
}