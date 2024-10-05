package com.pathivu.dto;

import com.pathivu.datalayer.PathivuRepository;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String userID;
    private String userPassword;
    private String userName;
    private int userAge;
    private Gender gender;
    private List<Ticket> ticketsBookedByUser;



    public User(String userPassword, String userName, int userAge, Gender gender) {
        int currentNoOfUsers=PathivuRepository.getInstance().getUserListSize();
        this.userID = "U"+(currentNoOfUsers+1);
        this.userPassword = userPassword;
        this.userName = userName;
        this.userAge = userAge;
        this.gender = gender;
        ticketsBookedByUser=new ArrayList<>();
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<Ticket> getTicketsBookedByUser() {
        return ticketsBookedByUser;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID='" + userID + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userName='" + userName + '\'' +
                ", userAge=" + userAge +
                ", gender=" + gender +
                ", ticketsBookedByUser=" + ticketsBookedByUser +
                '}';
    }
}
