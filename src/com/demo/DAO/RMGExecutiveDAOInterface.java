package com.demo.DAO;

import com.demo.Model.Employee;
import com.demo.Model.RequsitionRequest;

import java.time.LocalDate;
import java.util.ArrayList;

public interface RMGExecutiveDAOInterface {
    //  TODO : Search Employee By ID.

    Employee searchEmployeeByIDFromDatabase(int id);

    //  TODO : Search Employee By Domain.

    ArrayList<Employee> searchEmployeeByDomainFromDatabase(String domainName);

    //  TODO : Search Employee By Experience.

    ArrayList<Employee> searchEmployeeByExperienceFromDatabase(int yearsOfExperience);

    //  TODO : Search Employee By Skills.

    ArrayList<Employee> searchEmployeeBySkillsFromDatabase(ArrayList<String> skills);

    //  TODO : Assign RMG Project To Employee.

    boolean AssignProjectToEmployeeFromDatabase(int empID, int projectID);

    //  TODO : View All Requisition Requests.

    ArrayList<RequsitionRequest> viewAllRequsitionRequestsFromDatabase();

    //  TODO : Generate Reports For Closed

    ArrayList<RequsitionRequest> getAllClosedRequestFromDatabase();

    //  TODO : Generate Reports For Pending Requests

    ArrayList<RequsitionRequest> getAllPendingRequestFromDatabase();

    //  TODO : Generate Reports For Closed Requests After This Date

    ArrayList<RequsitionRequest> getAllClosedRequestAfterDateFromDatabase(LocalDate date);

    //  TODO : Generate Reports For Pending Requests After This Date

    ArrayList<RequsitionRequest> getAllPendingRequestAfterDateFromDatabase(LocalDate date);
}
