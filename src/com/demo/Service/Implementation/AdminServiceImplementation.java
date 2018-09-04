package com.demo.Service.Implementation;

import com.demo.DAO.Implementation.AdminDAOImplementation;
import com.demo.Model.User;
import com.demo.Service.Interface.AdminServiceInterface;

import java.util.ArrayList;

public class AdminServiceImplementation implements AdminServiceInterface {

    private AdminDAOImplementation adminDAOImplementation = new AdminDAOImplementation();

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
