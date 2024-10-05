package com.pathivu.screens.bookingTicket;

import com.pathivu.dto.Bus;
import com.pathivu.dto.User;
import com.pathivu.screens.displayBookedTicketsOfUser.DisplayBookedTicketsOfUser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class BookingTicket {
    private BookingTicketViewModel bookingTicketViewModel;

    public BookingTicket(){
        bookingTicketViewModel=new BookingTicketViewModel(this);
    }
    public void init(User user) {
        this.startBooking(user);
    }

    private void startBooking(User user) {
        System.out.println("=========================");
        System.out.println("Ticket Booking");
        System.out.println("=========================");

        Scanner scanner=new Scanner(System.in);

        outer:while(true){
            System.out.println("\n1.Book Ticket \n2.Display Booked Tickets \n3.Exit");
            System.out.println("Enter your Choice:");
            int choice=scanner.nextInt();

            if(choice==1){
                if(!this.getDetailsFromUser(user)) continue ;

                System.out.println("Enter ID of the bus that you want to book:");
                String busID=scanner.next();
                System.out.println("Enter number of seats you want to book:");
                int busSeats=scanner.nextInt();

                if(bookingTicketViewModel.isSeatsAvailable(busID,busSeats)){
                    bookingTicketViewModel.bookTicket(busID,busSeats,user);
                    System.out.println("Ticket Booked Successfully");
                }else{
                    System.out.println("Sorry seats not available");
                }
            }else if(choice==2){
                DisplayBookedTicketsOfUser displayBookedTicketsOfUser=new DisplayBookedTicketsOfUser();
                displayBookedTicketsOfUser.onCreate(user);
            }else if(choice==3){
                return;
            }else{
                System.out.println("Please enter a valid option");
            }
        }

    }

    private boolean getDetailsFromUser(User user) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter Boarding Place:");
        String boardingPlace=scanner.next();
        System.out.println("Enter Dropping Place:");
        String droppingPlace=scanner.next();
        System.out.println("Enter the Date(DD-MM-YYYY):");
        String dateString=scanner.next();
        Date date = null;

        try {
            date=new SimpleDateFormat("dd-MM-yyyy").parse(dateString);//MM-> month,mm-> minutes
        } catch (ParseException e) {
            System.out.println("Error:Please enter a valid date");
            this.startBooking(user);
        }



        List<Bus> availableBuses=bookingTicketViewModel.getAvailableBuses(boardingPlace,droppingPlace,date);
        if(availableBuses.isEmpty()){
            System.out.println("Sorry no buses are there on this date and place");
            return false;
        }
        this.displayBuses(availableBuses);
        return true;
    }

    private void displayBuses(List<Bus> availableBuses){
        for(Bus bus:availableBuses){
            System.out.println(bus);
            System.out.println();
        }
    }

}
