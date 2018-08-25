package com.demo.DAO;

import com.demo.Model.Employee;
import com.demo.Model.RequsitionRequest;

import java.time.LocalDate;
import java.util.ArrayList;

public class RMGExecutiveImplementation implements RMGExecutiveDAOInterface{

    @Override
    public Employee searchEmployeeByIDFromDatabase(int ID) {
        Employee employeeToBeSearched = new Employee();
        //TODO: Get Values Accordingly From ID and Return the employee object
        return employeeToBeSearched;
    }

    @Override
    public ArrayList<Employee> searchEmployeeByDomainFromDatabase(String domainName) {
        ArrayList<Employee> employees = new ArrayList<>();
        //TODO: Get Employees Accordingly By Domain and Return the employee Arraylist
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
    public ArrayList<RequsitionRequest> viewAllRequsitionRequestsFromDatabase() {

        ArrayList<RequsitionRequest> allRequisitionRequests = new ArrayList<>();

        //TODO Iterate Result Set And Create Arraylist and Return it

        return allRequisitionRequests;
    }

    @Override
    public ArrayList<RequsitionRequest> getAllClosedRequestFromDatabase() {
        ArrayList<RequsitionRequest> allClosedRequisitionRequests = new ArrayList<>();

        //TODO Iterate Result Set And Create Arraylist and Return it

        return allClosedRequisitionRequests;
    }

    @Override
    public ArrayList<RequsitionRequest> getAllPendingRequestFromDatabase() {
        ArrayList<RequsitionRequest> allPendingRequisitionRequests = new ArrayList<>();

        //TODO Iterate Result Set And Create Arraylist and Return it

        return allPendingRequisitionRequests;
    }

    @Override
    public ArrayList<RequsitionRequest> getAllClosedRequestAfterDateFromDatabase(LocalDate date) {
        ArrayList<RequsitionRequest> allClosedRequests = new ArrayList<>();

        //TODO Iterate Result Set And Create Arraylist and Return it

        return allClosedRequests;
    }

    @Override
    public ArrayList<RequsitionRequest> getAllPendingRequestAfterDateFromDatabase(LocalDate date) {
        ArrayList<RequsitionRequest> allPendingRequests = new ArrayList<>();

        //TODO Iterate Result Set And Create Arraylist and Return it

        return allPendingRequests;
    }

    //Method To Convert Skills Arraylist to String For Storing in Database

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
