package com.example.AEPB;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {

	@Test
	void should_parking_car_when_can_parking(){
		//Given
		ParkingLot parkinglot = new ParkingLot(10);
		Car car = new Car();
		//When
		Ceritification ceritification = parkinglot.parkCar(car).get();
		//Then
		assertEquals(1, parkinglot.count());
	}

	@Test
	void should_not_parking_car_when_parking_no_place(){
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
	void should_not_get_car_when_certification_is_no_verify(){
		//Given
		ParkingLot parkinglot = new ParkingLot(10);
		Car car1 = new Car();
		parkinglot.parkCar(car1);
		//When
		Ceritification ceritification = new Ceritification();
		//Then
		assertEquals(Optional.empty(), parkinglot.getCar(ceritification));
	}

	@Test
	void should_get_car_when_certification_is_verify(){
		//Given
		ParkingLot parkinglot = new ParkingLot(10);
		Car car1 = new Car();
		//When
		Ceritification ceritification = parkinglot.parkCar(car1).get();
		//Then
		assertEquals(car1, parkinglot.getCar(ceritification).get());
	}


	@Test
	void should_not_get_car_when_parkingLot_is_empty(){
		//Given
		ParkingLot parkinglot = new ParkingLot(10);
		//When
		Ceritification ceritification = new Ceritification();
		//Then
		assertEquals(Optional.empty(), parkinglot.getCar(ceritification));
	}
}
