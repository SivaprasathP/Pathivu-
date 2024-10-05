package com.pathivu.dto;

public class BusDriver {
    private String driverName;
    private String driverID;
    private int driverAge;

    public BusDriver(String driverName, String driverID, int driverAge) {
        this.driverName = driverName;
        this.driverID = driverID;
        this.driverAge = driverAge;
    }



    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverID() {
        return driverID;
    }

    public void setDriverID(String driverID) {
        this.driverID = driverID;
    }

    public int getDriverAge() {
        return driverAge;
    }

    public void setDriverAge(int driverAge) {
        this.driverAge = driverAge;
    }

    @Override
    public String toString() {
        return "BusDriver" +
                "\nDriver Name=" + driverName +
                "\nDriver ID=" + driverID +
                "\nDriver Age=" + driverAge ;
    }
}
