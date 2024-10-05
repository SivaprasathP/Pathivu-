package com.pathivu.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Bus {
    private String busID;
    private String busName;
    private BusType busType;
    private BusDriver driver;
    private String startTime;
    private String endTime;
    private String boardingPlace;
    private String droppingPlace;
    private int seats;
    private Date date;

    public Bus(String busID, String busName, BusType busType, BusDriver driver, String startTime, String endTime, String boardingPlace, String droppingPlace, int seats, String date) {
        this.busID = busID;
        this.busName = busName;
        this.busType = busType;
        this.driver = driver;
        this.startTime = startTime;
        this.endTime = endTime;
        this.boardingPlace = boardingPlace;
        this.droppingPlace = droppingPlace;
        this.seats = seats;
        try {
            this.date = new SimpleDateFormat("dd-MM-yyyy").parse(date);
        } catch (ParseException e) {
            System.out.println("ERROR:Wrong Date Format");
        }
    }

    public Bus(String busID, String busName, BusType busType, BusDriver driver, String startTime, String endTime, String boardingPlace, String droppingPlace) {
        this.busID = busID;
        this.busName = busName;
        this.busType = busType;
        this.driver = driver;
        this.startTime = startTime;
        this.endTime = endTime;
        this.boardingPlace = boardingPlace;
        this.droppingPlace = droppingPlace;
    }

    public Bus(String busID, String busName, BusType busType, BusDriver driver, String startTime, String endTime, String boardingPlace, String droppingPlace, int seats) {
        this.busID = busID;
        this.busName = busName;
        this.busType = busType;
        this.driver = driver;
        this.startTime = startTime;
        this.endTime = endTime;
        this.boardingPlace = boardingPlace;
        this.droppingPlace = droppingPlace;
        this.seats = seats;
    }



    public String getBusID() {
        return busID;
    }

    public void setBusID(String busID) {
        this.busID = busID;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public BusType getBusType() {
        return busType;
    }

    public void setBusType(BusType busType) {
        this.busType = busType;
    }

    public BusDriver getDriver() {
        return driver;
    }

    public void setDriver(BusDriver driver) {
        this.driver = driver;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getBoardingPlace() {
        return boardingPlace;
    }

    public void setBoardingPlace(String boardingPlace) {
        this.boardingPlace = boardingPlace;
    }

    public String getDroppingPlace() {
        return droppingPlace;
    }

    public void setDroppingPlace(String droppingPlace) {
        this.droppingPlace = droppingPlace;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "\n"+busName +
                "\nBus ID: " + busID +
                ", Bus Type: " + busType +
                ", Start Time: '" + startTime + '\'' +
                ", End Time: '" + endTime + '\'' +
                ", Start Place: '" + boardingPlace + '\'' +
                ", End Place: '" + droppingPlace + '\'' +
                ", Available Seats: "+seats+
                ", Date: "+new SimpleDateFormat("dd-MM-yyyy").format(date);
    }
}
