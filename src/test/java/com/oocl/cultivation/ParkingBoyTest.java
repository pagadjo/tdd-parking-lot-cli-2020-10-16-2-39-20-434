package com.oocl.cultivation;

import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParkingBoyTest {

    void parkManyCars(ParkingBoy parkingBoy, int carCount) {
        Car car = new Car();
        for (int x = 0; x < carCount; x++) {
            parkingBoy.park(car);
        }
    }

    private Car car = new Car();
    private Car car1 = new Car();
    private Car car2 = new Car();
    private Car car3 = new Car();
    private ParkingLot parkingLot1 = new ParkingLot();
    private ParkingLot parkingLot2 = new ParkingLot();
    private ParkingLot parkingLot3 = new ParkingLot();
    private ParkingBoy parkingBoy = new ParkingBoy(Collections.singletonList(parkingLot1));
    ;

    @Test
    void should_return_ticket_when_parking_boy_park_car_given_car() {
        //given

        //when
        ParkingTicket parkingTicket = parkingBoy.park(car);
        //then
        assertNotNull(parkingTicket);

    }

    @Test
    void should_return_correct_car_when_fetch_given_correct_ticket() {
        //given
        ParkingTicket parkingTicket = parkingBoy.park(car);
        //when
        Car expectedCar = parkingBoy.fetch(parkingTicket);
        //then
        assertSame(car, expectedCar);
    }

    @Test
    void should_return_two_correct_cars_when_fetch_with_corresponding_tickets_given_two_cars_and_parked() {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingTicket parkingTicket1 = parkingBoy.park(car1);
        ParkingTicket parkingTicket2 = parkingBoy.park(car2);
        //when
        Car expectedCar1 = parkingBoy.fetch(parkingTicket1);
        Car expectedCar2 = parkingBoy.fetch(parkingTicket2);
        //then
        assertSame(car1, expectedCar1);
        assertSame(car2, expectedCar2);
    }

    @Test
    void should_return_no_car_when_fetch_given_wrong_ticket() {
        //given
        parkingBoy.park(car);
        ParkingTicket wrongTicket = new ParkingTicket();
        //when
        //then
        assertThrows(UnrecognizedParkingTicketException.class, () -> parkingBoy.fetch(wrongTicket));
    }

    @Test
    void should_return_no_car_when_fetch_given_no_ticket() {
        //given
        parkingBoy.park(car);
        //when
        //then
        assertThrows(TicketNotProvidedException.class, () -> parkingBoy.fetch(null));
    }

    @Test
    void should_return_no_car_when_fetch_given_used_ticket() {
        //given
        ParkingTicket parkingTicket = parkingBoy.park(car);
        //when
        parkingBoy.fetch(parkingTicket);
        //then
        assertThrows(UnrecognizedParkingTicketException.class, () -> parkingBoy.fetch(parkingTicket));
    }

    @Test
    void should_return_failed_and_no_ticket_returned_when_park_car_given_parking_capacity_1_and_car_parked() {
        //given
        parkingLot1.setCapacity(1);
        ParkingBoy parkingBoy = new ParkingBoy(Collections.singletonList(parkingLot1));
        //then
        assertThrows(NotEnoughPositionException.class, () -> {

            //when
            parkingBoy.park(car1);
            parkingBoy.park(car2);

        });
    }

    @Test
    void should_park_in_next_parking_lot_when_parking_cars_given_first_parking_lot_is_full() {
        //given

        parkingLot1.setCapacity(2);
        parkingLot2.setCapacity(5);
        parkingLot3.setCapacity(7);
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(parkingLot1);
        parkingLotList.add(parkingLot2);
        parkingLotList.add(parkingLot3);
        parkingBoy = new ParkingBoy(parkingLotList);
        parkManyCars(parkingBoy, 13);
        //when
        ParkingTicket parkingTicketOfCar3 = parkingBoy.park(car3);
        //then
        assertNotNull(parkingBoy.fetch(parkingTicketOfCar3));
    }
}
