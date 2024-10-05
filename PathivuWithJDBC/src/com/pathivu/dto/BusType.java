package com.pathivu.dto;

public enum BusType {
    SEMI_SLEEPER(false),SLEEPER(true),DELUXE(true);

    private boolean isAC;

    BusType(boolean isAC){
        this.isAC=isAC;
    }

    public boolean getIsAC(){
        return this.isAC;
    }
}
