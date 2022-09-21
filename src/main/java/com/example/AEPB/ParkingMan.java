package com.example.AEPB;

import java.util.*;

public class ParkingMan {
    private int parkingLotCount = 0;
    private Map<Integer, ParkingLot> parkingLots = new HashMap<>();
    public ParkingMan(List<ParkingLot> parkinglots) {
        for(ParkingLot parkingLot : parkinglots){
            parkingLotCount++;
            parkingLots.put(parkingLotCount,parkingLot);
        }
    }

    public Optional<Certification> parkCar(Car car) {
        for(int i = 1; i <= parkingLotCount ; i++){
            if(!parkingLots.get(i).isFull()){
                Certification certification = parkingLots.get(i).parkCar(car).get();
                certification.setParkingLotNum(i);
                return Optional.of(certification);
            }
        }
        return Optional.empty();
    }
}
