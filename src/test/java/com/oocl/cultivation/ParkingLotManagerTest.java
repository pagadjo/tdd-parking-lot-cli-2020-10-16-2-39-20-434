package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
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
        parkingLotList.add(parkingLot3);
//        when
        ParkingLotManager parkingLotManager;
        ParkingBoy parkingBoy = new ParkingBoy(Collections.singletonList(parkingLot1));
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(Collections.singletonList(parkingLot2));
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(Collections.singletonList(parkingLot3));
        parkingLotManager = new ParkingLotManager(parkingLotList);
        parkingLotManager.addParkingBoyToList(parkingBoy);
        parkingLotManager.addParkingBoyToList(smartParkingBoy);
        parkingLotManager.addParkingBoyToList(superSmartParkingBoy);
        //then

        assertEquals(3, parkingLotManager.parkingBoysListCount());
    }

    @Test
    void should_return_error_message_when_manager_park_a_car_given_parking_boy_fetch_the_car() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        ParkingLot parkingLot3 = new ParkingLot(1);
        List<ParkingLot> parkingLotList = new ArrayList<>();
        List<ParkingBoy> parkingBoysList = new ArrayList<>();
        parkingLotList.add(parkingLot1);
        parkingLotList.add(parkingLot2);
        ParkingLotManager parkingLotManager;
        ParkingBoy parkingBoy = new ParkingBoy(Collections.singletonList(parkingLot1));
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(Collections.singletonList(parkingLot2));
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(Collections.singletonList(parkingLot3));
        parkingBoysList.add(parkingBoy);
        parkingBoysList.add(smartParkingBoy);
        parkingBoysList.add(superSmartParkingBoy);
        parkingLotManager = new ParkingLotManager(parkingLotList);
        parkingLotManager.getParkingLotBoysList(parkingBoysList);
//        when
        Car car1 = new Car();
        ParkingTicket parkingTicket = parkingLotManager.park(car1);
        //then

        assertThrows(UnrecognizedParkingTicketException.class, () ->
                smartParkingBoy.fetch(parkingTicket)
        );
    }

    @Test
    void should_parking_boy_fetch_car_when_manager_assign_parking_boy_and_car_given_parking_boy_and_a_car(){
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(Collections.singletonList(parkingLot1));
        ParkingLotManager parkingLotManager = new ParkingLotManager(Collections.singletonList(parkingLot1));
        parkingLotManager.addParkingBoyToList(parkingBoy);
        //when
        Car car = new Car();
        ParkingTicket parkingTicket = parkingLotManager.park(car, parkingBoy);
        //then
        assertNotNull(parkingLotManager.fetch(parkingTicket, parkingBoy));
    }

}