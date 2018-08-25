package com.demo.DAO;

import com.demo.Model.User;

public interface UserDAOInterface {
    public User checkUserCredentialsInDatabase(User newUser);
}
