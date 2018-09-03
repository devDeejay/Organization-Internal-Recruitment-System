package com.demo.DAO.Implementation;

import com.demo.DAO.Interfaces.RMGExecutiveDAOInterface;
import com.demo.Model.Employee;
import com.demo.Model.RequisitionRequest;

import java.time.LocalDate;
import java.util.ArrayList;

public class RMGExecutiveImplementation implements RMGExecutiveDAOInterface {

    @Override
    public Employee searchEmployeeByIDFromDatabase(int ID) {
        Employee employeeToBeSearched = new Employee();
        //TODO: Get Values Accordingly From ID and Return the Employee Object
        return employeeToBeSearched;
    }

    @Override
    public ArrayList<Employee> searchEmployeeByDomainFromDatabase(String domainName) {
        ArrayList<Employee> employees = new ArrayList<>();
        //TODO: Get Employees Accordingly By Domain and Return the employee Array List
        return employees;
    }

    @Override
    public ArrayList<Employee> searchEmployeeByExperienceFromDatabase(int yearsOfExperience) {
        return null;
    }

    @Override
    public ArrayList<Employee> searchEmployeeBySkillsFromDatabase(ArrayList<String> skills) {
        String skillSet = convertSkillsToString(skills);

        //  TODO Search SkillSet As String From Database

        return null;
    }

    @Override
    public boolean AssignProjectToEmployeeFromDatabase(int empID, int projectID) {
        //  TODO Allocate Project to Employee and return status
        return false;
    }

    @Override
    public ArrayList<RequisitionRequest> viewAllRequsitionRequestsFromDatabase() {

        ArrayList<RequisitionRequest> allRequisitionRequests = new ArrayList<>();

        //TODO Iterate Result Set And Create Arraylist and Return it

        return allRequisitionRequests;
    }

    @Override
    public ArrayList<RequisitionRequest> getAllClosedRequestFromDatabase() {
        ArrayList<RequisitionRequest> allClosedRequisitionRequests = new ArrayList<>();

        //TODO Iterate Result Set And Create Array List and Return it

        return allClosedRequisitionRequests;
    }

    @Override
    public ArrayList<RequisitionRequest> getAllPendingRequestFromDatabase() {
        ArrayList<RequisitionRequest> allPendingRequisitionRequests = new ArrayList<>();

        //TODO Iterate Result Set And Create Arraylist and Return it

        return allPendingRequisitionRequests;
    }

    @Override
    public ArrayList<RequisitionRequest> getAllClosedRequestAfterDateFromDatabase(LocalDate date) {
        ArrayList<RequisitionRequest> allClosedRequests = new ArrayList<>();

        //TODO Iterate Result Set And Create Arraylist and Return it

        return allClosedRequests;
    }

    @Override
    public ArrayList<RequisitionRequest> getAllPendingRequestAfterDateFromDatabase(LocalDate date) {
        ArrayList<RequisitionRequest> allPendingRequests = new ArrayList<>();

        //TODO Iterate Result Set And Create Array List and Return it

        return allPendingRequests;
    }

    //Method To Convert Skills Array list to String For Storing in Database

    private String convertSkillsToString(ArrayList<String> skills) {
        StringBuilder skillsAsStrings = new StringBuilder();

        skillsAsStrings.append("[");
        for (String s: skills) {
            skillsAsStrings.append(s + ",");
        }
        skillsAsStrings.deleteCharAt(skillsAsStrings.length() - 1);
        skillsAsStrings.append("]");

        return skillsAsStrings.toString();
    }
}
