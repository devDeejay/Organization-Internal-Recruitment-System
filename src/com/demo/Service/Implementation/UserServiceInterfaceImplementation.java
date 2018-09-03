package com.demo.Service.Implementation;

import com.demo.DAO.Implementation.UserDAOInterfaceImplementation;
import com.demo.Model.User;
import com.demo.Service.Interface.UserServiceInterface;

public class UserServiceInterfaceImplementation implements UserServiceInterface {

    UserDAOInterfaceImplementation user = new UserDAOInterfaceImplementation();

    @Override
    public User loginUser(User newUser) {
        User loggedInUser = user.checkUserCredentialsInDatabase(newUser);
        return loggedInUser;
    }
}
