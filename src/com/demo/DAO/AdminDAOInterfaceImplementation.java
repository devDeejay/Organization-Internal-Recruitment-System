package com.demo.DAO;

import com.demo.Model.User;

import java.util.ArrayList;

public class AdminDAOInterfaceImplementation implements AdminDAOInterface {
    @Override
    public ArrayList<User> viewUsersInDatabase() {

        //TODO : Add Users To Arraylist From Database


        return new ArrayList<>();
    }

    @Override
    public boolean addUserToDatabase(User userToBeAdded) {

        String username = userToBeAdded.getUsername();
        String name = userToBeAdded.getName();
        String password = userToBeAdded.getPassword();
        int userGrade = userToBeAdded.getUserGrade();

        // TODO : Insert User In Table And Return Boolean

        return true;
    }

    @Override
    public boolean modifyUserFromDatabase(User userToBeModified) {

        int id = userToBeModified.getUserID();
        String username = userToBeModified.getUsername();
        String name = userToBeModified.getName();
        String password = userToBeModified.getPassword();
        int userGrade = userToBeModified.getUserGrade();

        // TODO: Modify User In Database

        return true;
    }

    @Override
    public boolean deleteUserFromDatabase(User userToBeDeleted) {

        int id = userToBeDeleted.getUserID();

        // TODO : Delete User With UserId = id and then return boolean;

        return true;
    }
}
