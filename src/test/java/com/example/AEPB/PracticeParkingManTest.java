package com.example.AEPB;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PracticeParkingManTest {
    @Test
    void should_parking_car_and_get_a_certification_when_use_parkingMan_with_two_parkingLots(){
        //Given
        ParkingLot parkinglot1 = new ParkingLot(5);
        ParkingLot parkinglot2 = new ParkingLot(6);
        ParkingMan parkingMan = new PracticeParkingMan(List.of(parkinglot1,parkinglot2));
        Car car = new Car();
        //When
        Certification certification = parkingMan.parkCar(car).get();
        //Then
        assertEquals(1, parkinglot1.count());
        assertEquals(0, parkinglot2.count());
    }

    @Test
    void should_parking_car_and_get_a_certification_when_use_parkingMan_with_two_parkingLots_and_first_parkingLot_is_full(){
        //Given
        ParkingLot parkinglot1 = new ParkingLot(1);
        ParkingLot parkinglot2 = new ParkingLot(2);
        ParkingMan parkingMan = new PracticeParkingMan(List.of(parkinglot1,parkinglot2));
        Car car1 = new Car();
        parkinglot1.parkCar(car1);
        Car car2 = new Car();
        //When
        Certification certification = parkingMan.parkCar(car2).get();
        //Then
        assertEquals(1, parkinglot1.count());
        assertEquals(1, parkinglot2.count());
    }

    @Test
    void should_not_parking_car_when_use_parkingMan_with_two_parkingLots_and_all_parkingLot_is_full(){
        //Given
        ParkingLot parkinglot1 = new ParkingLot(1);
        ParkingLot parkinglot2 = new ParkingLot(1);
        ParkingMan parkingMan = new PracticeParkingMan(List.of(parkinglot1,parkinglot2));
        Car car1 = new Car();
        parkinglot1.parkCar(car1);
        Car car2 = new Car();
        parkinglot2.parkCar(car2);
        Car car3 = new Car();
        //When
        Optional<Certification> certification = parkingMan.parkCar(car3);
        //Then
        assertEquals(Optional.empty(), certification);
        assertEquals(1, parkinglot1.count());
        assertEquals(1, parkinglot2.count());
        assertTrue(parkinglot1.isFull());
        assertTrue(parkinglot2.isFull());
    }

    @Test
    void should_get_a_car_when_use_parkingMan_with_right_certification(){
        //Given
        ParkingLot parkinglot1 = new ParkingLot(5);
        ParkingLot parkinglot2 = new ParkingLot(5);
        ParkingMan parkingMan = new PracticeParkingMan(List.of(parkinglot1,parkinglot2));
        Car car = new Car();
        Certification certification = parkingMan.parkCar(car).get();
        //When
        Car myCar = parkingMan.getCar(certification).get();
        //Then
        assertEquals(0,parkinglot1.count());
        assertEquals(0,parkinglot2.count());
        assertEquals(car, myCar);
    }

    @Test
    void should_not_get_a_car_when_use_parkingMan_with_wrong_certification(){
        //Given
        ParkingLot parkinglot1 = new ParkingLot(5);
        ParkingLot parkinglot2 = new ParkingLot(5);
        ParkingMan parkingMan = new PracticeParkingMan(List.of(parkinglot1,parkinglot2));
        Car car = new Car();
        parkingMan.parkCar(car);
        Certification wrongCertification = new Certification();
        //When
        Optional<Car> myCar = parkingMan.getCar(wrongCertification);
        //Then
        assertEquals(Optional.empty(), myCar);
        assertEquals(1,parkinglot1.count());
        assertEquals(0,parkinglot2.count());
    }

    @Test
    void should_not_get_a_car_when_use_parkingMan_with_empty_parkingLot(){
        //Given
        ParkingLot parkinglot1 = new ParkingLot(5);
        ParkingLot parkinglot2 = new ParkingLot(5);
        ParkingMan parkingMan = new PracticeParkingMan(List.of(parkinglot1,parkinglot2));
        Certification certification = new Certification();
        //When
        Optional<Car> myCar = parkingMan.getCar(certification);
        //Then
        assertEquals(Optional.empty(), myCar);
        assertEquals(0,parkinglot1.count());
        assertEquals(0,parkinglot2.count());
    }

    @Test
    void should_get_car_when_park_car_by_myself_and_get_car_by_parkingMan(){
        //Given
        ParkingLot parkinglot1 = new ParkingLot(5);
        ParkingLot parkinglot2 = new ParkingLot(5);
        ParkingMan parkingMan = new PracticeParkingMan(List.of(parkinglot1,parkinglot2));
        Car car = new Car();
        Certification certification = parkinglot1.parkCar(car).get();
        //When
        Car myCar = parkingMan.getCar(certification).get();
        //Then
        assertEquals(car, myCar);
        assertEquals(0,parkinglot1.count());
        assertEquals(0,parkinglot2.count());
    }

    @Test
    void should_get_car_when_park_car_by_parkingMan_and_get_car_by_myself(){
        //Given
        ParkingLot parkinglot1 = new ParkingLot(5);
        ParkingLot parkinglot2 = new ParkingLot(5);
        ParkingMan parkingMan = new PracticeParkingMan(List.of(parkinglot1,parkinglot2));
        Car car = new Car();
        Certification certification = parkingMan.parkCar(car).get();
        //When
        Car myCar = parkinglot1.getCar(certification).get();
        //Then
        assertEquals(car, myCar);
        assertEquals(0,parkinglot1.count());
        assertEquals(0,parkinglot2.count());
    }
}
