package com.example.AEPB;

public class Certification {
    private int parkingLotNum = 0;
    protected void setParkingLotNum(int parkingLotNum){
        this.parkingLotNum = parkingLotNum;
    }

    public int getParkingLotNum(){
        return parkingLotNum;
    }
}
