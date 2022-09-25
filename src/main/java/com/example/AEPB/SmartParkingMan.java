package com.example.AEPB;

import java.util.List;
import java.util.Optional;

public class SmartParkingMan extends ParkingMan{

    public SmartParkingMan(List<ParkingLot> parkinglots) {
        super(parkinglots);
    }

    @Override
    public Optional<Certification> parkCar(Car car) {
        ParkingLot parkingLot = null;
        int mostRemainParkingSpaceNum = 0;
        for(int i = 1; i <= parkingLotQuantity; i++){
            ParkingLot currentParkingLot = parkingLots.get(i);
            if(!currentParkingLot.isFull() && currentParkingLot.remainParkingSpaceCount() > mostRemainParkingSpaceNum){
                parkingLot = currentParkingLot;
                mostRemainParkingSpaceNum = currentParkingLot.remainParkingSpaceCount();
            }
        }
        if(parkingLot != null)
            return parkingLot.parkCar(car);
        return Optional.empty();
    }
}
