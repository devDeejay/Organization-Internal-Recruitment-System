package com.demo.Service;

import com.demo.DAO.AdminDAOInterfaceImplementation;
import com.demo.Model.User;

import java.util.ArrayList;

public class AdminServiceInterfaceImplementation implements AdminServiceInterface {

    private AdminDAOInterfaceImplementation adminDAOImplementation = new AdminDAOInterfaceImplementation();

    @Override
    public boolean addUser(User userToBeAdded) {
        return adminDAOImplementation.addUserToDatabase(userToBeAdded);
    }

    @Override
    public ArrayList<User> viewUsers() {
        return adminDAOImplementation.viewUsersInDatabase();
    }

    @Override
    public boolean modifyUser(User userToBeModified) {
        return adminDAOImplementation.modifyUserFromDatabase(userToBeModified);
    }

    @Override
    public boolean deleteUser(User userToBeDeleted) {
        return adminDAOImplementation.deleteUserFromDatabase(userToBeDeleted);
    }
}
