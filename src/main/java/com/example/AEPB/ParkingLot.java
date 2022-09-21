package com.example.AEPB;


import java.util.*;

public class ParkingLot {
    private int size;
    private Map<Certification, Car> carCerMap;


    public ParkingLot(int size) {
        this.size = size;
        this.carCerMap = new HashMap<>();
    }

    public boolean containCar(Certification certification){
        return carCerMap.containsKey(certification);
    }

    public boolean isFull(){
        return carCerMap.size()==size;
    }

    public Optional<Certification> parkCar(Car car){
        if(count() == size){
            return Optional.empty();
        }
        Certification certification =  new Certification();
        carCerMap.put(certification,car);
       return Optional.of(certification);
    }

    public int count() {
        return carCerMap.size();
    }

    public Optional<Car> getCar(Certification certification) {
        if(carCerMap.containsKey(certification)){
            Car car = carCerMap.get(certification);
            carCerMap.remove(certification);
            return Optional.of(car);
        }
        return Optional.empty();
    }
}
