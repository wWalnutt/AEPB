package com.example.AEPB;


import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParkingLot {
    private  int size;

    private List<Car>  carList =  new ArrayList<>();;


    public ParkingLot(int size) {
        this.size = size;
    }

    public Optional<Ceritification> parkCar(Car car) throws Exception {
        if(carList.size() == size){
            return Optional.empty();
        }
        carList.add(car);
        Ceritification  ceritification =  new Ceritification();
        car.bind(ceritification);
       return Optional.of(ceritification);
    }

    public int count() {
        return carList.size();
    }

    public Optional<Car> getCar(Ceritification ceritification) {
        for(Car car : carList){
            if (ceritification.equals(car.getCeritification())) {
                return Optional.of(car);
            }
        }
        return Optional.empty();
    }
}
