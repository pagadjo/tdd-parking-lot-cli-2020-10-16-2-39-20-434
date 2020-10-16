package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingBoyTest {
    @Test
    void should_return_ticket_when_parking_boy_park_car_given_car() {
        //given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(10));
        //when
        ParkingTicket parkingTicket = parkingBoy.park(car);
        //then
        assertNotNull(parkingTicket);
    }

    @Test
    void should_return_correct_car_when_fetch_given_correct_ticket() {
        //given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(10));
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
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(10));
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
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(10));
        Car car = new Car();
        parkingBoy.park(car);
        ParkingTicket wrongTicket = new ParkingTicket();
        //when
        Car fetchedCar = parkingBoy.fetch(wrongTicket);
        //then
        assertNull(fetchedCar);
    }

    @Test
    void should_return_no_car_when_fetch_given_no_ticket() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(10));
        Car car = new Car();
        parkingBoy.park(car);
        //when
        Car fetchedCar = parkingBoy.fetch(null);
        //then
        assertNull(fetchedCar);
    }


    @Test
    void should_return_no_car_when_fetch_given_used_ticket() {
        //given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(10));
        ParkingTicket parkingTicket = parkingBoy.park(car);
        //when
        parkingBoy.fetch(parkingTicket);
        //then
        assertNull(parkingBoy.fetch(parkingTicket));
    }


    @Test
    void should_return_failed_and_no_ticket_returned_when_park_car_given_parking_capacity_1_and_car_parked() {
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(1));
        ParkingTicket parkingTicket1 = parkingBoy.park(car1);
        ParkingTicket parkingTicket2 = parkingBoy.park(car2);
        //when
        parkingBoy.fetch(parkingTicket1);
        //then
        assertNull(parkingBoy.fetch(parkingTicket2));
    }
}
