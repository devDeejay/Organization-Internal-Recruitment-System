package com.demo.Service.Interface;

import com.demo.Model.Employee;
import com.demo.Model.RequisitionRequest;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public interface ExecutiveInterface {

    //  TODO : Search Employee By ID.

    Employee searchEmployeeByID(int id);

    //  TODO : Search Employee By Domain.

    ArrayList<Employee> searchEmployeeByDomain(String domainName);

    //  TODO : Search Employee By Experience.

    ArrayList<Employee> searchEmployeeByExperience(int yearsOfExperience);

    //  TODO : Search Employee By Skills.

    ArrayList<Employee> searchEmployeeBySkills(ArrayList<String> skills);

    //  TODO : Assign RMG Project To Employee.

    boolean assignProjectToEmployee(int empID, int projectID);

    //  TODO : View All Requisition Requests.

    ArrayList<RequisitionRequest> viewAllRequisitionRequests(int rmgExecutiveID, int requestCode, Date date);

}
