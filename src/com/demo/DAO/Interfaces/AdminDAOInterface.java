package com.demo.DAO.Interfaces;

import com.demo.Model.User;

import java.util.ArrayList;

public interface AdminDAOInterface {

    /*
     * TODO : Add Users and their Roles.
     * TODO : Modify Users and their Roles.
     * TODO : Delete Users.
     */

    ArrayList<User> viewUsersInDatabase();

    boolean addUserToDatabase (User userToBeAdded);

    boolean modifyUserFromDatabase (User userToBeModified);

    boolean deleteUserFromDatabase (User userToBeDeleted);

}
