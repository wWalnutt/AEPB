package com.example.AEPB;

public class Car {

    private Ceritification ceritification;

    public boolean verify(Ceritification ceritification) {
         return  ceritification.equals(this.ceritification);
    }

    public void bind(Ceritification ceritification) {
        this.ceritification = ceritification;
    }

    public Ceritification getCeritification() {
        return ceritification;
    }
}
