package com.example.AEPB;

import java.util.*;

public class PracticeParkingMan extends ParkingMan{
    public PracticeParkingMan(List<ParkingLot> parkinglots) {
        super(parkinglots);
    }
    @Override
    public Optional<Certification> parkCar(Car car) {
        for(Map.Entry<Integer, ParkingLot> entry : parkingLots.entrySet()){
            int key = entry.getKey();
            ParkingLot value = entry.getValue();
            if(!value.isFull())
                return value.parkCar(car);
        }
        return Optional.empty();
    }
}
