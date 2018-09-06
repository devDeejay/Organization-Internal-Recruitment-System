package com.demo.Service.Implementation;

import com.demo.DAO.Implementation.ExecutiveDAOImplementation;
import com.demo.Model.Employee;
import com.demo.Model.RequisitionRequest;
import com.demo.Service.Interface.ExecutiveInterface;

import java.sql.Date;
import java.util.ArrayList;

public class ExecutiveServiceImplementation implements ExecutiveInterface {

    private ExecutiveDAOImplementation executiveDAO = new ExecutiveDAOImplementation();

    @Override
    public Employee searchEmployeeByID(int id) {
        return executiveDAO.searchEmployeeByIDFromDatabase(id);
    }

    @Override
    public ArrayList<Employee> searchEmployeeByDomain(String domainName) {

        String refinedDomainName = domainName.trim();
        refinedDomainName = refinedDomainName.substring(0, 1).toUpperCase() + refinedDomainName.substring(1);

        System.out.println("CHECKING : Getting Domain Name " + refinedDomainName);

        return executiveDAO.searchEmployeeByDomainFromDatabase(refinedDomainName);
    }

    @Override
    public ArrayList<Employee> searchEmployeeByExperience(int yearsOfExperience) {
        return executiveDAO.searchEmployeeByExperienceFromDatabase(yearsOfExperience);
    }

    @Override
    public ArrayList<Employee> searchEmployeeBySkills(String skills) {
        return executiveDAO.searchEmployeeBySkillsFromDatabase(skills);
    }

    @Override
    public boolean assignProjectToEmployee(int empID, int projectID, int executiveID) {
        return executiveDAO.assignProjectToEmployeeFromDatabase(empID, projectID, executiveID);
    }

    @Override
    public ArrayList<RequisitionRequest> viewAllRequisitionRequests(int rmgExecutiveID, int requestCode, Date date) {
        return executiveDAO.viewAllOpenRequisitionRequestsFromDatabase(rmgExecutiveID, requestCode, date);
    }

    @Override
    public boolean giveSuggestion(int executiveID, int requestID, String combineEmployeeID) {
        return executiveDAO.giveSuggestion(executiveID, requestID, combineEmployeeID);
    }


}
