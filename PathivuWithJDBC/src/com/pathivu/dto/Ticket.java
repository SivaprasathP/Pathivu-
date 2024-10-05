package com.pathivu.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ticket {
    private static int nextTicketID=1;
    private String ticketID;
    private User bookedUSer;
    private Bus bookedBus;
    private BusDriver busDriver;
    private String startTime;
    private String endTime;
    private String boardingPlace;
    private String droppingPlace;
    private int bookedSeats;
    private Date date;

    public Ticket(User bookedUSer, Bus bookedBus, BusDriver busDriver, String startTime, String endTime, String boardingPlace, String droppingPlace, int bookedSeats, Date date) {
        this.ticketID = "T"+nextTicketID++;
        this.bookedUSer = bookedUSer;
        this.bookedBus = bookedBus;
        this.busDriver = busDriver;
        this.startTime = startTime;
        this.endTime = endTime;
        this.boardingPlace = boardingPlace;
        this.droppingPlace = droppingPlace;
        this.bookedSeats = bookedSeats;
        this.date = date;
    }


    public String getTicketID() {
        return ticketID;
    }

    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }

    public User getBookedUSer() {
        return bookedUSer;
    }

    public void setBookedUSer(User bookedUSer) {
        this.bookedUSer = bookedUSer;
    }

    public Bus getBookedBus() {
        return bookedBus;
    }

    public void setBookedBus(Bus bookedBus) {
        this.bookedBus = bookedBus;
    }

    public BusDriver getBusDriver() {
        return busDriver;
    }

    public void setBusDriver(BusDriver busDriver) {
        this.busDriver = busDriver;
    }

    @Override
    public String toString() {
        return "Ticket ID:" + ticketID +
                ", Booked USer:" + bookedUSer.getUserName() +
                ", Booked Bus:" + bookedBus.getBusName() +
                ", Bus Driver:" + busDriver.getDriverName() +
                ", Start Time:'" + startTime + '\'' +
                ", End Time:'" + endTime + '\'' +
                ", Boarding Place:" + boardingPlace +
                ", Dropping Place:" + droppingPlace  +
                ", Booked Seats:" + bookedSeats +
                ", Date:" +new SimpleDateFormat("dd-MM-yyyy").format(date);
    }
}
