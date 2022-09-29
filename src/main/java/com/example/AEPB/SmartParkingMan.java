package com.example.AEPB;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class SmartParkingMan extends ParkingMan{

    public SmartParkingMan(List<ParkingLot> parkinglots) {
        super(parkinglots);
    }

    @Override
    public Optional<Certification> parkCar(Car car) {
        ParkingLot parkingLot = null;
        int mostRemainParkingSpaceNum = 0;
        for(Map.Entry<Integer, ParkingLot> entry : parkingLots.entrySet()){
            int key = entry.getKey();
            ParkingLot value = entry.getValue();
            if(!value.isFull() && value.remainParkingSpaceCount() > mostRemainParkingSpaceNum){
                parkingLot = value;
                mostRemainParkingSpaceNum = value.remainParkingSpaceCount();
            }
        }
        if(parkingLot != null)
            return parkingLot.parkCar(car);
        return Optional.empty();
    }
}
