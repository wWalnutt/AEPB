package com.example.AEPB;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public abstract class ParkingMan {
    protected int parkingLotQuantity = 0;
    protected Map<Integer, ParkingLot> parkingLots = new HashMap<>();
    public ParkingMan(List<ParkingLot> parkinglots) {
        for(ParkingLot parkingLot : parkinglots){
            parkingLotQuantity++;
            parkingLots.put(parkingLot.getParkingLotNum(),parkingLot);
        }
    }

    public abstract Optional<Certification> parkCar(Car car);

    public Optional<Car> getCar(Certification certification) {
        int num = certification.getParkingLotNum();
        if(num == 0)
            return Optional.empty();
        if(parkingLots.get(num).isContainCar(certification)){
            return parkingLots.get(num).getCar(certification);
        }
        return Optional.empty();
    }
}
