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
    public boolean assignProjectToEmployee(int empID, int projectID) {
        return false;
    }

    @Override
    public ArrayList<RequsitionRequest> viewAllRequisitionRequests(int rmgExecutiveID) {
        return null;
    }

    @Override
    public ArrayList<RequsitionRequest> getAllClosedRequest(int rmgExecutiveID) {
        return null;
    }

    @Override
    public ArrayList<RequsitionRequest> getAllPendingRequest(int rmgExecutiveID) {
        return null;
    }

    @Override
    public ArrayList<RequsitionRequest> getAllClosedRequestAfterDate(int rmgExecutiveID, LocalDate date) {
        return null;
    }

    @Override
    public ArrayList<RequsitionRequest> getAllPendingRequestAfterDate(int rmgExecutiveID, LocalDate date) {
        return null;
    }
}
