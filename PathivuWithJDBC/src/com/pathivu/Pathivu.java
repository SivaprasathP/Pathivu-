package com.pathivu;

import com.pathivu.dto.User;
import com.pathivu.screens.createNewAccount.CreateAccount;
import com.pathivu.screens.login.Login;

import java.util.Scanner;

public class Pathivu {
    public static void main(String[] args) {
        System.out.println("Welcome to Pathivu....");

        Scanner scanner=new Scanner(System.in);

        while(true){
            System.out.println("1.Login \n2.Create Account \n3.Exit");
            System.out.println("Enter your choice:");

            int choice=scanner.nextInt();
            if(choice==1){
                Login login=new Login();
                login.onCreate();
            }else if (choice==2){
                CreateAccount createAccount=new CreateAccount();
                User newUSer=createAccount.createNewAccount();
                System.out.println("Your user ID is "+newUSer.getUserID());
            }else if(choice==3){
                System.exit(0);
            }else {
                System.out.println("Error:Please enter a valid option");
            }
        }


    }
}
