package com.pathivu.screens.login;

import com.pathivu.dto.User;
import com.pathivu.screens.bookingTicket.BookingTicket;

import java.util.Scanner;

public class Login implements LoginListener {
    private LoginViewModel loginViewModel;

    public Login(){
        loginViewModel=new LoginViewModel(this);
    }
    public void onCreate() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter User ID: ");
        String userID=scanner.next();

        System.out.println("Enter User Password: ");
        String userPassword=scanner.next();

        loginViewModel.validateUser(userID,userPassword);
    }

    @Override
    public void loginSuccess(User user) {
        System.out.println("Logged In Successfully");

        BookingTicket bookingTicket=new BookingTicket();
        bookingTicket.init(user);
    }

    @Override
    public void loginFailed() {
        System.out.println("ERROR:Log in failed");
    }
}
