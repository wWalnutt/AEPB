package com.example.AEPB;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ParkingManagerTest {

	@Test
	void should_park_a_car_when_have_two_parkingMan_and_all_parkingMans_parkingLot_is_not_full(){
		//Given
		ParkingLot parkinglot1 = new ParkingLot(6);
		ParkingLot parkinglot2 = new ParkingLot(5);
		ParkingLot parkinglot3 = new ParkingLot(6);
		ParkingLot parkinglot4 = new ParkingLot(5);
		SmartParkingMan smartParkingMan = new SmartParkingMan(List.of(parkinglot1,parkinglot2));
		PracticeParkingMan practiceParkingMan = new PracticeParkingMan(List.of(parkinglot3,parkinglot4));
		Car car1 = new Car();
		Car car2 = new Car();
		smartParkingMan.parkCar(car1);
		practiceParkingMan.parkCar(car2);
		ParkingManager parkingManager = new ParkingManager(List.of(smartParkingMan,practiceParkingMan), List.of());
		Car car3 = new Car();
		//When
		Certification certification = parkingManager.parkCar(car3).get();
		//Then
		assertEquals(2, parkinglot1.count());
		assertEquals(1, parkinglot3.count());
	}
	@Test
	void should_park_a_car_when_have_two_parkingMan_and_first_parkingMans_parkingLot_is_full(){
		//Given
		ParkingLot parkinglot1 = new ParkingLot(1);
		ParkingLot parkinglot2 = new ParkingLot(5);
		ParkingLot parkinglot3 = new ParkingLot(6);
		SmartParkingMan smartParkingMan = new SmartParkingMan(List.of(parkinglot1));
		PracticeParkingMan practiceParkingMan = new PracticeParkingMan(List.of(parkinglot2,parkinglot3));
		Car car1 = new Car();
		Car car2 = new Car();
		smartParkingMan.parkCar(car1);
		practiceParkingMan.parkCar(car2);
		ParkingManager parkingManager = new ParkingManager(List.of(smartParkingMan,practiceParkingMan), List.of());
		Car car3 = new Car();
		//When
		Certification certification = parkingManager.parkCar(car3).get();
		//Then
		assertEquals(1, parkinglot1.count());
		assertEquals(2, parkinglot2.count());
		assertEquals(0, parkinglot3.count());
	}
}
