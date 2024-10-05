package com.pathivu.screens.login;

import com.pathivu.dto.User;

public interface LoginListener {
    public void loginSuccess(User user);

    public void loginFailed();
}
