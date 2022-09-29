package com.example.AEPB;

import java.util.List;
import java.util.Optional;

public class ParkingManager extends ParkingMan{
    private final List<ParkingMan> parkingManList;

    public ParkingManager(List<ParkingMan> parkingManList, List<ParkingLot> parkinglots){
        super(parkinglots);
        this.parkingManList = parkingManList;
    }
    @Override
    public Optional<Certification> parkCar(Car car){
        Optional<Certification> certification;
        for(ParkingMan parkingMan : parkingManList){
            certification = parkingMan.parkCar(car);
            if(!certification.isEmpty())
                return certification;
        }
        for(int i = 1; i <= parkingLotQuantity; i++){
            if(!parkingLots.get(i).isFull())
                return parkingLots.get(i).parkCar(car);
        }
        return Optional.empty();
    }
}
