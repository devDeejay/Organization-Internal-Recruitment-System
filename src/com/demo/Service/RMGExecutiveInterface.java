package com.demo.Service;

import com.demo.Model.Employee;
import com.demo.Model.RequisitionRequest;

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

    ArrayList<RequisitionRequest> viewAllRequisitionRequests(int rmgExecutiveID);

    //  TODO : Generate Reports For Closed

    ArrayList<RequisitionRequest> getAllClosedRequest(int rmgExecutiveID);

    //  TODO : Generate Reports For Pending Requests

    ArrayList<RequisitionRequest> getAllPendingRequest(int rmgExecutiveID);

    //  TODO : Generate Reports For Closed Requests After This Date

    ArrayList<RequisitionRequest> getAllClosedRequestAfterDate(int rmgExecutiveID, LocalDate date);

    //  TODO : Generate Reports For Pending Requests After This Date

    ArrayList<RequisitionRequest> getAllPendingRequestAfterDate(int rmgExecutiveID, LocalDate date);

}
