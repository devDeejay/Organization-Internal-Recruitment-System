package com.demo.Service.Implementation;

import com.demo.Model.Employee;
import com.demo.Model.RequisitionRequest;
import com.demo.Service.Interface.RMGExecutiveInterface;

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
    public ArrayList<RequisitionRequest> viewAllRequisitionRequests(int rmgExecutiveID) {
        return null;
    }

    @Override
    public ArrayList<RequisitionRequest> getAllClosedRequest(int rmgExecutiveID) {
        return null;
    }

    @Override
    public ArrayList<RequisitionRequest> getAllPendingRequest(int rmgExecutiveID) {
        return null;
    }

    @Override
    public ArrayList<RequisitionRequest> getAllClosedRequestAfterDate(int rmgExecutiveID, LocalDate date) {
        return null;
    }

    @Override
    public ArrayList<RequisitionRequest> getAllPendingRequestAfterDate(int rmgExecutiveID, LocalDate date) {
        return null;
    }
}
