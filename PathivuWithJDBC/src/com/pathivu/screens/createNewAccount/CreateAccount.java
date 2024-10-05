package com.pathivu.screens.createNewAccount;

import com.pathivu.dto.Gender;
import com.pathivu.dto.User;

import java.util.Scanner;

public class CreateAccount {
    private CreateAccountViewModel createAccountViewModel;

    public CreateAccount(){
        createAccountViewModel=new CreateAccountViewModel(this);
    }


    public User createNewAccount() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("=========================");
        System.out.println("Please enter your details");
        System.out.println("=========================");
        System.out.println("Enter your name");
        String userName=scanner.next();

        System.out.println("Enter your password:");
        String userPassword=scanner.next();

        System.out.println("Enter your age:");
        int userAge=scanner.nextInt();

        System.out.println("Enter your gender(Male/Female):");
        String gender=scanner.next();
        Gender userGender=null;
        if(gender.equalsIgnoreCase("Male")){
            userGender=Gender.MALE;
        }else if(gender.equalsIgnoreCase("Female")){
            userGender=Gender.FEMALE;
        }

        return createAccountViewModel.createAccountViewModel(userPassword,userName,userAge,userGender);


    }
}
