package com.example.AEPB;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmartParkingManTest {
    @Test
    void should_parking_car_and_get_a_certification_when_use_smartParkingMan_with_two_parkingLots_and_second_parkingLot_have_more_remain_parking_space(){
        //Given
        ParkingLot parkinglot1 = new ParkingLot(6);
        ParkingLot parkinglot2 = new ParkingLot(5);
        ParkingMan parkingMan = new SmartParkingMan(List.of(parkinglot1,parkinglot2));
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        parkinglot1.parkCar(car1);
        parkinglot1.parkCar(car2);
        //When
        Certification certification = parkingMan.parkCar(car3).get();
        //Then
        assertEquals(2, certification.getParkingLotNum());
        assertEquals(2, parkinglot1.count());
        assertEquals(1, parkinglot2.count());
    }

    @Test
    void should_parking_car_and_get_a_certification_when_use_smartParkingMan_with_two_parkingLots_and_all_parkingLot_have_same_remain_parking_space(){
        //Given
        ParkingLot parkinglot1 = new ParkingLot(6);
        ParkingLot parkinglot2 = new ParkingLot(5);
        ParkingMan parkingMan = new SmartParkingMan(List.of(parkinglot1,parkinglot2));
        Car car1 = new Car();
        Car car2 = new Car();
        parkinglot1.parkCar(car1);
        //When
        Certification certification = parkingMan.parkCar(car2).get();
        //Then
        assertEquals(1, certification.getParkingLotNum());
        assertEquals(2, parkinglot1.count());
        assertEquals(0, parkinglot2.count());
    }
}
