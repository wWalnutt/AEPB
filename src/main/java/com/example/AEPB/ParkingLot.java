package com.example.AEPB;


import java.util.*;

public class ParkingLot {
    private int parkingLotSize;
    private Map<Certification, Car> parkingSpace;


    public ParkingLot(int parkingLotSize) {
        this.parkingLotSize = parkingLotSize;
        this.parkingSpace = new HashMap<>();
    }

    public boolean isContainCar(Certification certification){
        return parkingSpace.containsKey(certification);
    }

    public boolean isFull(){
        return parkingSpace.size()== parkingLotSize;
    }

    public Optional<Certification> parkCar(Car car){
        if(size() == parkingLotSize){
            return Optional.empty();
        }
        Certification certification =  new Certification();
        parkingSpace.put(certification,car);
       return Optional.of(certification);
    }

    public int size() {
        return parkingSpace.size();
    }

    public Optional<Car> getCar(Certification certification) {
        if(parkingSpace.containsKey(certification)){
            Car car = parkingSpace.get(certification);
            parkingSpace.remove(certification);
            return Optional.of(car);
        }
        return Optional.empty();
    }
}
