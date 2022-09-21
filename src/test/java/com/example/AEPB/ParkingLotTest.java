package com.example.AEPB;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {

	@Test
	void should_parking_car_and_get_certification_when_parking_a_car_and_parkingLot_have_place(){
		//Given
		ParkingLot parkinglot = new ParkingLot(10);
		Car car = new Car();
		//When
		Certification certification = parkinglot.parkCar(car).get();
		//Then
		assertEquals(1, parkinglot.size());
	}

	@Test
	void should_not_parking_car_when_parking_a_car_and_parkingLot_have_no_place(){
		//Given
		ParkingLot parkinglot = new ParkingLot(2);
		Car car1 = new Car();
		Car car2 = new Car();
		Car car3 = new Car();
		parkinglot.parkCar(car1);
		parkinglot.parkCar(car2);
		//when&&Then
		assertEquals(true,parkinglot.parkCar(car3).isEmpty());
	}
	@Test
	void should_not_get_car_when_get_a_car_and_certification_is_no_verify(){
		//Given
		ParkingLot parkinglot = new ParkingLot(10);
		Car car1 = new Car();
		parkinglot.parkCar(car1);
		//When
		Certification certification = new Certification();
		//Then
		assertEquals(Optional.empty(), parkinglot.getCar(certification));
		assertEquals(1, parkinglot.size());
	}

	@Test
	void should_get_car_when_get_a_car_and_certification_is_verify(){
		//Given
		ParkingLot parkinglot = new ParkingLot(10);
		Car car1 = new Car();
		//When
		Certification certification = parkinglot.parkCar(car1).get();
		//Then
		assertEquals(car1, parkinglot.getCar(certification).get());
		assertEquals(0, parkinglot.size());
	}


	@Test
	void should_not_get_car_when_get_a_car_and_parkingLot_is_empty(){
		//Given
		ParkingLot parkinglot = new ParkingLot(10);
		//When
		Certification certification = new Certification();
		//Then
		assertEquals(Optional.empty(), parkinglot.getCar(certification));
	}
}
