package com.pathivu.screens.login;

import com.pathivu.datalayer.PathivuRepository;
import com.pathivu.dto.User;

class LoginViewModel {
    private LoginListener loginListener;

    public LoginViewModel(Login login) {
        loginListener=login;
    }


    public void validateUser(String userID, String userPassword) {
        User loggedInUser= PathivuRepository.getInstance().userValidation(userID,userPassword);
        if(loggedInUser!=null){
            loginListener.loginSuccess(loggedInUser);
        }else{
            loginListener.loginFailed();
        }
    }
}
