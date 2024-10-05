package com.pathivu.screens.bookingTicket;

import com.pathivu.datalayer.PathivuRepository;
import com.pathivu.dto.Bus;
import com.pathivu.dto.User;

import java.util.Date;
import java.util.List;

public class BookingTicketViewModel {
    private BookingTicket bookingTicket;

    public BookingTicketViewModel(BookingTicket bookingTicket) {
        this.bookingTicket=bookingTicket;
    }

    public List<Bus> getAvailableBuses(String boardingPlace, String droppingPlace, Date date) {
        return PathivuRepository.getInstance().getAvailableBusesFromDB(boardingPlace,droppingPlace,date);
    }

    public boolean isSeatsAvailable(String busID, int busSeats) {
        return PathivuRepository.getInstance().checkAvailableSeatsInBusByID(busID,busSeats);
    }

    public void bookTicket(String busID, int busSeats, User user) {
        PathivuRepository.getInstance().bookTicketOfUser(busID,busSeats,user);
    }
}
