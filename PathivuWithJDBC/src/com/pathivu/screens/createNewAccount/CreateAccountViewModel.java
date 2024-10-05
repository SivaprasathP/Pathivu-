package com.pathivu.screens.createNewAccount;

import com.pathivu.datalayer.PathivuRepository;
import com.pathivu.dto.Gender;
import com.pathivu.dto.User;

public class CreateAccountViewModel {
    private CreateAccount createAccount;

    public CreateAccountViewModel(CreateAccount createAccount) {
        this.createAccount=createAccount;
    }

    public User createAccountViewModel(String userPassword, String userName, int userAge, Gender userGender) {
        return PathivuRepository.getInstance().addUserToDB(userPassword,userName,userAge,userGender);
    }
}
