package com.example.AEPB;

import java.util.*;

public class ParkingMan {
    private int parkingLotQuantity = 0;
    private Map<Integer, ParkingLot> parkingLots = new HashMap<>();
    public ParkingMan(List<ParkingLot> parkinglots) {
        for(ParkingLot parkingLot : parkinglots){
            parkingLotQuantity++;
            parkingLots.put(parkingLotQuantity,parkingLot);
        }
    }

    public Optional<Certification> parkCar(Car car) {
        for(int i = 1; i <= parkingLotQuantity; i++){
            if(!parkingLots.get(i).isFull()){
                Certification certification = parkingLots.get(i).parkCar(car).get();
                certification.setParkingLotNum(i);
                return Optional.of(certification);
            }
        }
        return Optional.empty();
    }

    public Optional<Car> getCar(Certification certification) {
        for(int i = 1; i <= parkingLotQuantity; i++){
            if(parkingLots.get(i).isContainCar(certification)){
                return parkingLots.get(i).getCar(certification);
            }
        }
        return Optional.empty();
    }
}
