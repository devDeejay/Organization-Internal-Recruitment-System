package com.demo.DAO.Interfaces;

import com.demo.Model.Employee;
import com.demo.Model.RequisitionRequest;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public interface ExecutiveDAOInterface {
    //  TODO : Search Employee By ID.

    Employee searchEmployeeByIDFromDatabase(int id);

    //  TODO : Search Employee By Domain.

    ArrayList<Employee> searchEmployeeByDomainFromDatabase(String domainName);

    //  TODO : Search Employee By Experience.

    ArrayList<Employee> searchEmployeeByExperienceFromDatabase(int yearsOfExperience);

    //  TODO : Search Employee By Skills.

    ArrayList<Employee> searchEmployeeBySkillsFromDatabase(String skills);

    //  TODO : Assign RMG Project To Employee.

    boolean assignProjectToEmployeeFromDatabase(int empID, int projectID);

    //  TODO : View All Requisition Requests.

    ArrayList<RequisitionRequest> viewAllOpenRequisitionRequestsFromDatabase(int executiveID, int requestCode, java.sql.Date date);
}
