package com.demo.Service;

import com.demo.DAO.UserDAOInterfaceImplementation;
import com.demo.Model.User;

public class UserServiceInterfaceImplementation implements UserServiceInterface {

    UserDAOInterfaceImplementation user = new UserDAOInterfaceImplementation();

    @Override
    public User loginUser(User newUser) {
        User loggedInUser = user.checkUserCredentialsInDatabase(newUser);
        return loggedInUser;
    }
}
