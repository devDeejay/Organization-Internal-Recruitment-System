package com.demo.Service;

import com.demo.Model.Employee;
import com.demo.Model.RequsitionRequest;

import java.time.LocalDate;
import java.util.ArrayList;

public interface RMGExecutiveInterface {

    //  TODO : Search Employee By ID.

    Employee searchEmployeByID(int id);

    //  TODO : Search Employee By Domain.

    ArrayList<Employee> searchEmployeeByDomain(String domainName);

    //  TODO : Search Employee By Experience.

    ArrayList<Employee> searchEmployeeByExperience(int yearsOfExperience);

    //  TODO : Search Employee By Skills.

    ArrayList<Employee> searchEmployeeBySkills(ArrayList<String> skills);

    //  TODO : Assign RMG Project To Employee.

    boolean assignProjectToEmployee(int empID, int projectID);

    //  TODO : View All Requisition Requests.

    ArrayList<RequsitionRequest> viewAllRequisitionRequests(int rmgExecutiveID);

    //  TODO : Generate Reports For Closed

    ArrayList<RequsitionRequest> getAllClosedRequest(int rmgExecutiveID);

    //  TODO : Generate Reports For Pending Requests

    ArrayList<RequsitionRequest> getAllPendingRequest(int rmgExecutiveID);

    //  TODO : Generate Reports For Closed Requests After This Date

    ArrayList<RequsitionRequest> getAllClosedRequestAfterDate(int rmgExecutiveID, LocalDate date);

    //  TODO : Generate Reports For Pending Requests After This Date

    ArrayList<RequsitionRequest> getAllPendingRequestAfterDate(int rmgExecutiveID, LocalDate date);

}
