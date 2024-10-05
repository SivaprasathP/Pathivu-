package com.pathivu.datalayer;


import com.pathivu.dto.*;
import java.util.*;


public class PathivuRepository {
    private static PathivuRepository pathivuRepository;

    private List<User> users=new ArrayList<>();

    private Map<String,User> userPasswordMap=new HashMap<>(){{
        for(User user:users){
            put(user.getUserID(), user);
        }
    }};

    private List<Bus> buses=new ArrayList<>();

    private PathivuRepository(){

    }

    public static PathivuRepository getInstance(){
        if(pathivuRepository==null){
            pathivuRepository=new PathivuRepository();
        }
        return pathivuRepository;
    }


    public User userValidation(String userID,String userPassword) {
        for(User user:users){
            if(user.getUserID().equals(userID) && user.getUserPassword().equals(userPassword)){
                return user;
            }
        }

        return null;
    }

    public List<Bus> getBusList() {
        return buses;
    }

    public List<Bus> getAvailableBusesFromDB(String boardingPlace, String droppingPlace, Date date) {
        List<Bus> availableBuses=new ArrayList<>();
        for(Bus bus:buses){
            if(bus.getBoardingPlace().equalsIgnoreCase(boardingPlace) && bus.getDroppingPlace().equalsIgnoreCase(droppingPlace) && bus.getDate().equals(date)){
                availableBuses.add(bus);
            }
        }
        return availableBuses;
    }

    public boolean checkAvailableSeatsInBusByID(String busID, int neededSeats) {
        for(Bus bus:buses){
            if(bus.getBusID().equals(busID)){
                if(neededSeats<=bus.getSeats()){
                    return true;
                }else{
                    return false;
                }
            }
        }
        return false;
    }

    public void bookTicketOfUser(String busID, int bookingSeats, User user) {
        for(Bus bus:buses){
            if(bus.getBusID().equals(busID)){
                bus.setSeats(bus.getSeats()-bookingSeats);
                Ticket ticket=new Ticket(user,bus,bus.getDriver(),bus.getStartTime(),bus.getEndTime(),bus.getBoardingPlace(),bus.getDroppingPlace(),bookingSeats,bus.getDate());
                user.getTicketsBookedByUser().add(ticket);
            }
        }
    }

    public User addUserToDB(String userPassword, String userName, int userAge, Gender userGender) {
        User newUser=new User(userPassword,userName,userAge,userGender);
        users.add(newUser);
        userPasswordMap.put(newUser.getUserID(),newUser);
        return newUser;
    }

    public int getUserListSize() {
        return users.size();
    }




}
