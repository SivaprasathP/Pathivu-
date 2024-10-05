package com.pathivu.screens.displayBookedTicketsOfUser;

import com.pathivu.dto.Bus;
import com.pathivu.dto.Ticket;
import com.pathivu.dto.User;
import com.pathivu.screens.bookingTicket.BookingTicket;

import java.util.List;

public class DisplayBookedTicketsOfUser {
    private DisplayBookedTicketsOfUserViewModel displayBookedTicketsOfUserViewModel;

    public DisplayBookedTicketsOfUser(){
        displayBookedTicketsOfUserViewModel =new DisplayBookedTicketsOfUserViewModel(this);
    }
    public void onCreate(User user) {
        this.displayBookedTicketsOfCurrentUser(user);
    }

    private void displayBookedTicketsOfCurrentUser(User user) {
        if(user.getTicketsBookedByUser().isEmpty()){
            System.out.println("No Tickets Booked");
            return;
        }
        for(Ticket ticket:user.getTicketsBookedByUser()){
            System.out.println(ticket);
        }
    }


}
