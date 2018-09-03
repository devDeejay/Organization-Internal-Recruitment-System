package com.demo.DAO.Interfaces;

import com.demo.Model.User;

public interface UserDAOInterface {
    public User checkUserCredentialsInDatabase(User newUser);
}
