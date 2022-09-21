package com.example.AEPB;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParkingManTest {
    @Test
    void should_parking_car_and_get_a_certification_when_use_parkingMan_with_two_parkingLots(){
        //Given
        ParkingLot parkinglot1 = new ParkingLot(5);
        ParkingLot parkinglot2 = new ParkingLot(6);
        ParkingMan parkingMan = new ParkingMan(List.of(parkinglot1,parkinglot2));
        Car car = new Car();
        //When
        Certification certification = parkingMan.parkCar(car).get();
        //Then
        assertEquals(1, certification.getParkingLotNum());
        assertEquals(1, parkinglot1.count());
    }

    @Test
    void should_parking_car_and_get_a_certification_when_use_parkingMan_with_two_parkingLots_and_first_parkingLot_is_full(){
        //Given
        ParkingLot parkinglot1 = new ParkingLot(1);
        ParkingLot parkinglot2 = new ParkingLot(2);
        ParkingMan parkingMan = new ParkingMan(List.of(parkinglot1,parkinglot2));
        Car car1 = new Car();
        parkinglot1.parkCar(car1);
        Car car2 = new Car();
        //When
        Certification certification = parkingMan.parkCar(car2).get();
        //Then
        assertEquals(2, certification.getParkingLotNum());
        assertEquals(1, parkinglot1.count());
        assertEquals(1, parkinglot2.count());
    }

    @Test
    void should_not_parking_car_when_use_parkingMan_with_two_parkingLots_and_all_parkingLot_is_full(){
        //Given
        ParkingLot parkinglot1 = new ParkingLot(1);
        ParkingLot parkinglot2 = new ParkingLot(1);
        ParkingMan parkingMan = new ParkingMan(List.of(parkinglot1,parkinglot2));
        Car car1 = new Car();
        parkinglot1.parkCar(car1);
        Car car2 = new Car();
        parkinglot2.parkCar(car2);
        //When Then
        assertEquals(Optional.empty(), parkingMan.parkCar(car2));
    }

}
