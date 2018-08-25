package com.demo.DAO;

import com.demo.Model.User;
import com.demo.Util.IRSValues;

public class UserDAOInterfaceImplementation implements UserDAOInterface {
    @Override
    public User checkUserCredentialsInDatabase(User newUser) {

        String username = newUser.getUsername();
        String password = newUser.getPassword();

        /*
        *   TODo:
        *       Validate The User Details
        *       Get The User Details From Database
        *       Set The Values In LoggedIn User Object
        */

        User loggedInUser = new User();

        if (username.equals("Admin") && password.equals("Root")) {
            loggedInUser.setUserID(12132);
            loggedInUser.setName("Dhananjay Trivedi");
            loggedInUser.setUserGrade(IRSValues.ADMIN);
            loggedInUser.setValidUser(true);
        }

        else if (username.equals("RMG") && password.equals("Root")) {
            loggedInUser.setUserID(31244);
            loggedInUser.setName("Utkarsh Trehan");
            loggedInUser.setUserGrade(IRSValues.RMG_EXECUTIVE);
            loggedInUser.setValidUser(true);
        }

        else if (username.equals("Manager") && password.equals("Root")) {
            loggedInUser.setUserID(2341);
            loggedInUser.setName("Piyush Dubey");
            loggedInUser.setUserGrade(IRSValues.RESOURCE_MANAGER);
            loggedInUser.setValidUser(true);
        }

        else {
            loggedInUser.setValidUser(false);
            loggedInUser.setUserGrade(IRSValues.INVALID_USER);
        }

        return loggedInUser;

    }
}
