package com.demo.Model;

import java.util.ArrayList;

public class Employee {

    int employeeID;
    int employeeProjectID;
    int employeeStatus;
    int yearsOfExperience;
    String employeeName;
    String employeeDomain;
    ArrayList<String> employeeSkills;

    public Employee() {
        // Default Constructor
    }

    public Employee(int employeeID, int employeeProjectID, int employeeStatus, int yearsOfExperience, String employeeName, String employeeDomain, ArrayList<String> employeeSkills) {
        this.employeeID = employeeID;
        this.employeeProjectID = employeeProjectID;
        this.employeeStatus = employeeStatus;
        this.yearsOfExperience = yearsOfExperience;
        this.employeeName = employeeName;
        this.employeeDomain = employeeDomain;
        this.employeeSkills = employeeSkills;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int getEmployeeProjectID() {
        return employeeProjectID;
    }

    public void setEmployeeProjectID(int employeeProjectID) {
        this.employeeProjectID = employeeProjectID;
    }

    public int getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(int employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeDomain() {
        return employeeDomain;
    }

    public void setEmployeeDomain(String employeeDomain) {
        this.employeeDomain = employeeDomain;
    }

    public ArrayList<String> getEmployeeSkills() {
        return employeeSkills;
    }

    public void setEmployeeSkills(ArrayList<String> employeeSkills) {
        this.employeeSkills = employeeSkills;
    }
}
