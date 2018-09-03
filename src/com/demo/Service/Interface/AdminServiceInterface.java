package com.demo.Service.Interface;

import com.demo.Model.User;

import java.util.ArrayList;

public interface AdminServiceInterface {

    /*
     * TODO : Add Users and their Roles.
     * TODO : View Users and their Roles.
     * TODO : Modify Users and their Roles.
     * TODO : Delete Users.
     */

    boolean addUser (User userToBeAdded);

    ArrayList<User> viewUsers ();

    boolean modifyUser (User userToBeModified);

    boolean deleteUser (User userToBeDeleted);

}
