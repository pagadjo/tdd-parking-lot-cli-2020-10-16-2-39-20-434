package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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

    @Test
    void should_return_list_of_parking_boys_when_get_list_given_three_parking_boys() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(15);
        ParkingLot parkingLot2 = new ParkingLot(20);
        ParkingLot parkingLot3 = new ParkingLot(20);
        List<ParkingLot> parkingLotList = new ArrayList<>();
        List<ParkingBoy> parkingBoysList = new ArrayList<>();
        parkingLotList.add(parkingLot1);
        parkingLotList.add(parkingLot2);
//        when
        ParkingLotManager parkingLotManager;
        ParkingBoy parkingBoy = new ParkingBoy(Collections.singletonList(parkingLot1));
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(Collections.singletonList(parkingLot2));
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(Collections.singletonList(parkingLot3));
        parkingBoysList.add(parkingBoy);
        parkingBoysList.add(smartParkingBoy);
        parkingBoysList.add(superSmartParkingBoy);
        parkingLotManager = new ParkingLotManager(parkingBoysList,parkingLotList);
        //then

        assertEquals(3, parkingLotManager.parkingBoysListCount());
    }

}