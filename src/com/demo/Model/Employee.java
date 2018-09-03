package com.demo.Model;

import java.util.ArrayList;

public class Employee {

    //  Employee Class
    int employeeID;
    int employeeProjectID;
    int employeeStatus;
    int yearsOfExperience;
    String employeeName;
    String employeeDomain;
    String employeeSkillsAsString;
    ArrayList<String> employeeSkills;

    //  Constructor for Builder
    public Employee(Builder builder) {
        this.employeeID = builder.employeeID;
        this.employeeProjectID = builder.employeeProjectID;
        this.employeeStatus = builder.employeeStatus;
        this.yearsOfExperience = builder.yearsOfExperience;
        this.employeeName = builder.employeeName;
        this.employeeDomain = builder.employeeDomain;
        this.employeeSkillsAsString = builder.employeeSkillsAsString;
        this.employeeSkills = builder.employeeSkills;
    }

    public Employee() {

    }

    //  Getter Methods For Employee Class (Immutable Object)
    public int getEmployeeID() {
        return employeeID;
    }

    public int getEmployeeProjectID() {
        return employeeProjectID;
    }

    public int getEmployeeStatus() {
        return employeeStatus;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeeDomain() {
        return employeeDomain;
    }

    public ArrayList<String> getEmployeeSkills() {
        return employeeSkills;
    }

    public static class Builder {
        int employeeID;
        int employeeProjectID;
        int employeeStatus;
        int yearsOfExperience;
        String employeeName;
        String employeeDomain;
        String employeeSkillsAsString;
        ArrayList<String> employeeSkills;

        public Builder() {

        }

        public Employee build() {
            return new Employee(this);
        }

        public Builder employeeID(int employeeID) {
            this.employeeID = employeeID;
            return this;
        }

        public Builder employeeProjectID(int employeeProjectID) {
            this.employeeProjectID = employeeProjectID;
            return this;
        }

        public Builder employeeStatus(int employeeStatus) {
            this.employeeStatus = employeeStatus;
            return this;
        }

        public Builder yearsOfExperience(int yearsOfExperience) {
            this.yearsOfExperience = yearsOfExperience;
            return this;
        }

        public Builder employeeDomain(String employeeDomain) {
            this.employeeDomain = employeeDomain;
            return this;
        }

        public Builder employeeSkillsAsString(String employeeSkillsAsString) {
            this.employeeSkillsAsString = employeeSkillsAsString;
            return this;
        }

        public Builder employeeName(String employeeName) {
            this.employeeName = employeeName;
            return this;
        }

        public Builder employeeSkills(ArrayList<String> employeeSkills) {
            this.employeeSkills = employeeSkills;
            return this;
        }
    } //    End Of Builder Class
}
