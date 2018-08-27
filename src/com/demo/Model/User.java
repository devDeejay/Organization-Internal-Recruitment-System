package com.demo.Model;

public class User {
    int userID;
    int userGrade;
    String username;
    String password;
    String name;
    boolean isValidUser;

    public User(){}

    public User(int userID) {
        this.userID = userID;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(int userID, String name, String username, String password, int userGrade) {
        this.userID = userID;
        this.name = name;
        this.username = username;
        this.password = password;
        this.userGrade = userGrade;
    }

    public User(String name, String username, String password, int userRole) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.userGrade = userGrade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public boolean isValidUser() {
        return isValidUser;
    }

    public void setValidUser(boolean validUser) {
        isValidUser = validUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserGrade() {
        return userGrade;
    }

    public void setUserGrade(int userGrade) {
        this.userGrade = userGrade;
    }
}
