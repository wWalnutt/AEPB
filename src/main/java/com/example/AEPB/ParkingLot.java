package com.example.AEPB;


import java.util.*;

public class ParkingLot {
    private int size;
    private Map<Ceritification, Car> carCerMap;


    public ParkingLot(int size) {
        this.size = size;
        this.carCerMap = new HashMap<>();
    }

    public Optional<Ceritification> parkCar(Car car){
        if(count() == size){
            return Optional.empty();
        }
        Ceritification  ceritification =  new Ceritification();
        carCerMap.put(ceritification,car);
       return Optional.of(ceritification);
    }

    public int count() {
        return carCerMap.size();
    }

    public Optional<Car> getCar(Ceritification ceritification) {
        if(carCerMap.containsKey(ceritification)){
            Car car = carCerMap.get(ceritification);
            carCerMap.remove(ceritification);
            return Optional.of(car);
        }
        return Optional.empty();
    }
}
