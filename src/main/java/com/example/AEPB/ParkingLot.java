package com.example.AEPB;


import java.util.*;

public class ParkingLot {
    private static int totalParkingLotNum = 0;
    private int parkingLotNum;
    private int parkingLotSize;
    private Map<Certification, Car> parkingSpace;


    public ParkingLot(int parkingLotSize) {
        totalParkingLotNum ++;
        this.parkingLotNum = totalParkingLotNum;
        this.parkingLotSize = parkingLotSize;
        this.parkingSpace = new HashMap<>();
    }

    public int getParkingLotNum(){
        return this.parkingLotNum;
    }

    public int remainParkingSpaceCount(){
        return parkingLotSize - parkingSpace.size();
    }

    public boolean isContainCar(Certification certification){
        return parkingSpace.containsKey(certification);
    }

    public boolean isFull(){
        return parkingSpace.size()== parkingLotSize;
    }

    public Optional<Certification> parkCar(Car car){
        if(count() == parkingLotSize){
            return Optional.empty();
        }
        Certification certification =  new Certification();
        certification.setParkingLotNum(this.parkingLotNum);
        parkingSpace.put(certification,car);
       return Optional.of(certification);
    }

    public int count() {
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
