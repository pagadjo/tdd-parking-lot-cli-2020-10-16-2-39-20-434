package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotManagerTest {
    Car car = new Car();
    private ParkingLot parkingLot1 = new ParkingLot();
    private ParkingLot parkingLot2 = new ParkingLot();
    private ParkingLot parkingLot3 = new ParkingLot();
    private List<ParkingLot> parkingLotList = new ArrayList<>();


    @Test
    void should_return_ticket_when_parking_boy_park_car_given_car() {
        //given
        parkingLot1.setCapacity(1);
        List<ParkingLot> parkingLotList = Collections.singletonList(parkingLot1);
//
        ParkingLotManager parkingLotManager = new ParkingLotManager(parkingLotList);
        //when
        ParkingTicket parkingTicket = parkingLotManager.park(car);
        //then
        assertNotNull(parkingTicket);

    }

    @Test
    void should_return_correct_car_when_fetch_given_correct_ticket() {
        //given
        parkingLot1.setCapacity(10);
        ParkingLotManager parkingLotManager = new ParkingLotManager(Collections.singletonList(parkingLot1));
        ParkingTicket parkingTicket = parkingLotManager.park(car);
        //when
        Car expectedCar = parkingLotManager.fetch(parkingTicket);
        //then
        assertSame(car, expectedCar);
    }

    @Test
    void should_return_list_of_parking_boys_when_get_list_given_three_parking_boys() {
        //given
        ParkingLotManager parkingLotManager;
        ParkingBoy parkingBoy = new ParkingBoy(Collections.singletonList(parkingLot1));
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(Collections.singletonList(parkingLot2));
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(Collections.singletonList(parkingLot3));
        parkingLotManager = new ParkingLotManager(parkingLotList);
        //when
        parkingLotManager.addParkingBoyToList(parkingBoy);
        parkingLotManager.addParkingBoyToList(smartParkingBoy);
        parkingLotManager.addParkingBoyToList(superSmartParkingBoy);
        //then

        assertEquals(3, parkingLotManager.parkingBoysListCount());
    }

    @Test
    void should_return_error_message_when_failed_operation_given_parking_boy_fetch_the_car() {
        //given
        parkingLot1.setCapacity(1);
        ParkingBoy parkingBoy = new ParkingBoy(Collections.singletonList(parkingLot1));
        ParkingLotManager parkingLotManager = new ParkingLotManager(Collections.singletonList(parkingLot1));
        parkingLotManager.addParkingBoyToList(parkingBoy);
        //when
        ParkingTicket parkingTicket = parkingLotManager.park(car, parkingBoy);
        ParkingTicket newParkingTicket = new ParkingTicket();
        //then
        assertNotNull(parkingTicket);
        assertThrows(UnrecognizedParkingTicketException.class, () ->
                parkingLotManager.fetch(newParkingTicket, parkingBoy)
        );
    }

    @Test
    void should_parking_boy_fetch_car_when_manager_assign_parking_boy_and_car_given_parking_boy_and_a_car(){
        //given

        parkingLot1.setCapacity(1);
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