package com.demo.Service;

import com.demo.Model.Employee;
import com.demo.Model.RequsitionRequest;

import java.time.LocalDate;
import java.util.ArrayList;

public class RMGExecutiveImplementation implements RMGExecutiveInterface {
    @Override
    public Employee searchEmployeByID(int id) {
        return null;
    }

    @Override
    public ArrayList<Employee> searchEmployeeByDomain(String domainName) {
        return null;
    }

    @Override
    public ArrayList<Employee> searchEmployeeByExperience(int yearsOfExperience) {
        return null;
    }

    @Override
    public ArrayList<Employee> searchEmployeeBySkills(ArrayList<String> skills) {
        return null;
    }

    @Override
    public boolean AssignProjectToEmployee(int empID, int projectID) {
        return false;
    }

    @Override
    public ArrayList<RequsitionRequest> viewAllRequsitionRequests() {
        return null;
    }

    @Override
    public ArrayList<RequsitionRequest> getAllClosedRequest() {
        return null;
    }

    @Override
    public ArrayList<RequsitionRequest> getAllPendingRequest() {
        return null;
    }

    @Override
    public ArrayList<RequsitionRequest> getAllClosedRequestAfterDate(LocalDate date) {
        return null;
    }

    @Override
    public ArrayList<RequsitionRequest> getAllPendingRequestAfterDate(LocalDate date) {
        return null;
    }
}
