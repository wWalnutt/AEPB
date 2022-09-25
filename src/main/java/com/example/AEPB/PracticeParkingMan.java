package com.example.AEPB;

import java.util.*;

public class PracticeParkingMan extends ParkingMan{
    public PracticeParkingMan(List<ParkingLot> parkinglots) {
        super(parkinglots);
    }
    @Override
    public Optional<Certification> parkCar(Car car) {
        for(int i = 1; i <= parkingLotQuantity; i++){
            if(!parkingLots.get(i).isFull()){
                Certification certification = parkingLots.get(i).parkCar(car).get();
                return Optional.of(certification);
            }
        }
        return Optional.empty();
    }
}
