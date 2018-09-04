package com.demo.DAO.Implementation;

import com.demo.DAO.Interfaces.ExecutiveDAOInterface;
import com.demo.Model.Employee;
import com.demo.Model.RequisitionRequest;
import com.demo.Util.DBUtil;
import com.demo.Util.IClientQueryMapper;
import com.demo.Util.IRSValues;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class ExecutiveDAOImplementation implements ExecutiveDAOInterface {

    @Override
    public Employee searchEmployeeByIDFromDatabase(int ID) {

        // We will be returning a single Employee Object
        Employee employee = null;

        try {

            DBUtil dbUtilInstance = DBUtil.getInstance();
            Connection connection = dbUtilInstance.getConnection();

            PreparedStatement preparedStatement = connection
                    .prepareStatement(IClientQueryMapper.SEARCH_EMPLOYEE_BY_ID);

            // Getting Requests Made By Logged In Manager
            preparedStatement.setInt(1, ID);

            // Executing Query
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                // Building The Employee Object
                employee = getEmployeeObjectFromResultSet(resultSet);

            }

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }

        // Employee Will Either be returned as Object or Null if it the query fails

        return employee;
    }

    private Employee getEmployeeObjectFromResultSet(ResultSet resultSet) throws SQLException {
        Employee.Builder builder = new Employee.Builder();

        builder.employeeDomain(resultSet.getString("emp_domain"))
                .employeeID(resultSet.getInt("emp_id"))
                .employeeName(resultSet.getString("emp_name"))
                .employeeProjectID(resultSet.getInt("emp_project_id"))
                .employeeSkillsAsString(resultSet.getString("emp_skills"))
                .yearsOfExperience(resultSet.getInt("emp_experience_years"))
                .employeeStatus(resultSet.getInt("emp_allocation_status"));


        // Creating The Employee Object
        Employee employee = builder.build();
        return employee;
    }

    @Override
    public ArrayList<Employee> searchEmployeeByDomainFromDatabase(String domainName) {
        ArrayList<Employee> employees = new ArrayList<>();

        try {

            DBUtil dbUtilInstance = DBUtil.getInstance();
            Connection connection = dbUtilInstance.getConnection();

            PreparedStatement preparedStatement = connection
                    .prepareStatement(IClientQueryMapper.SEARCH_EMPLOYEE_BY_DOMAIN);

            // Getting Requests Made By Logged In Manager
            preparedStatement.setString(1, domainName);

            // Executing Query
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Employee employee = getEmployeeObjectFromResultSet(resultSet);
                employees.add(employee);
            }

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }

        // Employees Will Either be returned as Array list or Null if it the query fails

        return employees;
    }

    @Override
    public ArrayList<Employee> searchEmployeeByExperienceFromDatabase(int yearsOfExperience) {
        ArrayList<Employee> employees = new ArrayList<>();

        try {

            DBUtil dbUtilInstance = DBUtil.getInstance();
            Connection connection = dbUtilInstance.getConnection();

            PreparedStatement preparedStatement = connection
                    .prepareStatement(IClientQueryMapper.SEARCH_EMPLOYEE_BY_EXPERIENCE);

            // Getting Requests Made By Logged In Manager
            preparedStatement.setInt(1, yearsOfExperience);

            // Executing Query
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Employee employee = getEmployeeObjectFromResultSet(resultSet);
                employees.add(employee);
            }

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }

        // Employees Will Either be returned as Array list or Null if it the query fails

        return employees;
    }

    @Override
    public ArrayList<Employee> searchEmployeeBySkillsFromDatabase(String skills) {
        ArrayList<Employee> employees = new ArrayList<>();
        try {

            DBUtil dbUtilInstance = DBUtil.getInstance();
            Connection connection = dbUtilInstance.getConnection();

            PreparedStatement preparedStatement = connection
                    .prepareStatement(IClientQueryMapper.SEARCH_EMPLOYEE_BY_SKILLS);

            // Getting Requests Made By Logged In Manager
            preparedStatement.setString(1, skills);

            // Executing Query
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Employee employee = getEmployeeObjectFromResultSet(resultSet);
                employees.add(employee);
            }

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }

        // Employees Will Either be returned as Array list or Null if it the query fails

        return employees;
    }

    @Override
    public boolean assignProjectToEmployeeFromDatabase(int empID, int projectID) {
        DBUtil dbUtilInstance = DBUtil.getInstance();
        try (
                // Try With Resources
                Connection connection = dbUtilInstance.getConnection();
                PreparedStatement statement = connection.prepareStatement(IClientQueryMapper.UPDATE_EMPLOYEE_ALLOCATION);
        ) {

            statement.setInt(1, projectID);
            statement.setInt(2, IRSValues.ALLOCATED_IN_PROJECT);
            statement.setInt(3, empID);

            int status = statement.executeUpdate();

            if (status == 1) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            System.out.println("Exception Occured While Allocating Project To Employee");
            System.out.println(e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ArrayList<RequisitionRequest> viewAllRequisitionRequestsFromDatabase(int executiveID, int requestCode, Date date) {

        ArrayList<RequisitionRequest> listOfRequests = new ArrayList<>();

        try {

            DBUtil dbUtilInstance = DBUtil.getInstance();
            Connection connection = dbUtilInstance.getConnection();

            PreparedStatement preparedStatement = connection
                    .prepareStatement(IClientQueryMapper.VIEW_ALL_REQUESTS_FOR_MANAGER);

            // Getting Requests Made For This Executive
            preparedStatement.setInt(1, executiveID);
            preparedStatement.setInt(2, requestCode);

            // Executing Query
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                //  Getting Request Object From Result Set
                RequisitionRequest request = getRequestObjectFromResultSet(resultSet);
                listOfRequests.add(request);

            }

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }

        return listOfRequests;
    }

    private RequisitionRequest getRequestObjectFromResultSet(ResultSet resultSet) throws SQLException {
        RequisitionRequest.Builder builder = new RequisitionRequest.Builder();

        builder.resourceManagerID(resultSet.getInt("requesting_manager_id"))
                .requsitionID(resultSet.getInt("requisition_request_id"))
                .projectID(resultSet.getInt("requesting_project_id"))
                .requestStatus(resultSet.getInt("request_status"))
                .vacancy(resultSet.getInt("vacancy"))
                .numberOfPeopleRequired(resultSet.getInt("required"))
                .skillsAsString(resultSet.getString("skills_required"))
                .domainName(resultSet.getString("domain"))
                .dateCreated(resultSet.getDate("request_open_date"))
                .dateClosed(resultSet.getDate("request_close_date"));

        RequisitionRequest request = builder.build();

        return request;

    }
}
