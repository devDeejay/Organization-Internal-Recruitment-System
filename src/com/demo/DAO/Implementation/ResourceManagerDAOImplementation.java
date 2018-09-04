package com.demo.DAO.Implementation;

import com.demo.DAO.Interfaces.ResourceManagerDAOInterface;
import com.demo.Model.RequisitionRequest;
import com.demo.Model.RequisitionSuggestions;
import com.demo.Util.DBUtil;
import com.demo.Util.IClientQueryMapper;
import com.demo.Util.IRSValues;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ResourceManagerDAOImplementation implements
        ResourceManagerDAOInterface {

    // Raise New Requisition Request In The Database

    @Override
    public int raiseRequisitionRequestInDatabase(RequisitionRequest request) {

        int resourceManagerID = request.getResourceManagerID();
        int projectID = request.getProjectID();
        int vacancy = request.getVacancy();
        int numberOfPeopleRequired = request.getProjectID();
        String skillsAsString = request.getSkillsAsString();
        String domainName = request.getDomainName();
        int requestStatus = IRSValues.REQUISISTION_REQUEST_OPEN;
        int executiveID = 0;

        PreparedStatement preparedStatement = null;

        // Get Project Executive ID From Database

        try {

            DBUtil dbUtilInstance = DBUtil.getInstance();
            Connection connection = dbUtilInstance.getConnection();

            preparedStatement = connection
                    .prepareStatement(IClientQueryMapper.GET_PROJECT_EXECUTIVE_ID);
            preparedStatement.setInt(1, projectID);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                executiveID = resultSet.getInt(1);
            }

        } catch (Exception e) {
            System.out
                    .println("Error While Getting Executive ID While raising request");
            System.out.println(e.getMessage());
            return 0;
        }

        int id = 0;

        // Got Project Executive ID From Database Now Raise Request

        try {

            DBUtil dbUtilInstance = DBUtil.getInstance();
            Connection connection = dbUtilInstance.getConnection();

            preparedStatement = connection
                    .prepareStatement(IClientQueryMapper.ADD_REQUISITION_REQUEST);

            preparedStatement.setInt(1, resourceManagerID);
            preparedStatement.setInt(2, projectID);
            preparedStatement.setInt(3, requestStatus);
            preparedStatement.setInt(4, vacancy);
            preparedStatement.setInt(5, numberOfPeopleRequired);
            preparedStatement.setString(6, skillsAsString);
            preparedStatement.setString(7, domainName);
            preparedStatement.setInt(8, executiveID); // Inserting The Executive
            // ID Here

            int status = preparedStatement.executeUpdate();

            if (status == 1) {

                // Request Gets Inserted In Database
                // Now we get its ID To Return

                /*
                 * Statement statement = connection.createStatement(); ResultSet
                 * resultSet = statement.executeQuery(IClientQueryMapper.
                 * GET_REQUISITION_REQUEST_ID);
                 *
                 * if (resultSet.next()) { id = resultSet.getInt(1); }
                 */

            } else {
                System.out.println("Returning Status Still FALSE");
            }

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }

        return 1;
    }

    @Override
    public ArrayList<RequisitionSuggestions> viewSuggestionsMadeByExecutiveFromDatabase(int managerID, int suggestionCode) {
        ArrayList<RequisitionSuggestions> listOfRequests = new ArrayList<>();

        // First, Get Executive ID For That Manager
        int executiveID = 0;

        try {
            //  Connecting To Database
            DBUtil dbUtilInstance = DBUtil.getInstance();
            Connection connection = dbUtilInstance.getConnection();

            //  Preparing Statements
            PreparedStatement preparedStatement = connection
                    .prepareStatement(IClientQueryMapper.GET_PROJECT_EXECUTIVE_ID);

            //  Setting The Project Manager ID In Query
            preparedStatement.setInt(1, managerID);

            //  Getting Data in Result Set
            ResultSet resultSet = preparedStatement.executeQuery();

            //  If Result Set Has Data Only Then Proceed
            if (resultSet.next()) {
                // Get The Executive ID For The Project Manager
                executiveID = resultSet.getInt(1);
            } else {
                // Else, Send null Back To Avoid Crash Ahead
                return null;
            }

            // If everything is working fine, till now then will proceed

            // Getting All Suggestion From The Database From Executive For This Manager

            //  Preparing Statement
            preparedStatement = connection
                    .prepareStatement(IClientQueryMapper.VIEW_ALL_SUGGESTIONS);

            //  Inserting The Executive ID
            preparedStatement.setInt(1, executiveID);
            preparedStatement.setInt(2, managerID);
            preparedStatement.setInt(3, suggestionCode);

            //  Execute Query, Get Data in Result Set
            resultSet = preparedStatement.executeQuery();

            //  Iterate Over Result Set
            while (resultSet.next()) {
                // Building RequisitionSuggestion Object Following Builder Pattern
                RequisitionSuggestions.Builder builder = new RequisitionSuggestions.Builder();

                // Setting Properties To The Object
                builder.requisitionRequestID(
                        resultSet.getInt("requisition_request_id"))
                        .requisitionSuggestionID(
                                resultSet.getInt("requisition_suggestion_id"))
                        .suggestedEmployeeID(
                                resultSet.getInt("suggested_employees"))
                        .suggestedProjectID(
                                resultSet.getInt("suggested_project_id"))
                        .suggestionStatus(
                                resultSet.getInt("status_of_suggestion"));

                // Creating The Object
                RequisitionSuggestions request = builder.build();

                // Adding The Object To Array List of Suggestions
                listOfRequests.add(request);
            }

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
            return null;
        }

        // If all went right, Return The Array List of Suggestions
        return listOfRequests;
    }

    @Override
    public ArrayList<RequisitionRequest> viewAllRequestsMade(int managerID, int requestCode) {
        ArrayList<RequisitionRequest> listOfRequests = new ArrayList<>();

        try {

            DBUtil dbUtilInstance = DBUtil.getInstance();
            Connection connection = dbUtilInstance.getConnection();

            PreparedStatement preparedStatement = connection
                    .prepareStatement(IClientQueryMapper.VIEW_ALL_REQUESTS_FOR_MANAGER);

            // Getting Requests Made By Logged In Manager
            preparedStatement.setInt(1, managerID);
            preparedStatement.setInt(2, requestCode);

            // Executing Query
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

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

                listOfRequests.add(request);
            }

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }

        return listOfRequests;
    }

    @Override
    public boolean acceptRejectSuggestionsInDatabase(int managerID, int suggestionID, int acceptRejectCode) {
        //  Accept Reject Suggestions

        DBUtil dbUtilInstance = DBUtil.getInstance();
        try {
            Connection connection = dbUtilInstance.getConnection();
            PreparedStatement statement = connection.prepareStatement(IClientQueryMapper.ACCEPT_REJECT_SUGGESTIONS);

            statement.setInt(1, acceptRejectCode);
            statement.setInt(2, suggestionID);

            int status = statement.executeUpdate();

            // If Update Was Successful
            if (status == 1) {
                int requisition_ID = 0;

                // Get RequisitionID For This Query
                statement = connection.prepareStatement(IClientQueryMapper.GET_REQUISITION_REQUEST_ID_FROM_SUGGESTION_ID);
                statement.setInt(1, suggestionID);

                // Getting Requisition ID
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    requisition_ID = resultSet.getInt(1);
                } else
                    return false;

                // Using The Requisition ID To Proceed With Update
                if (requisition_ID != 0) {
                    // Updating That Requisition ID
                    statement = connection.prepareStatement(IClientQueryMapper.UPDATE_REQUISITION_REQUEST_STATUS);
                    statement.setInt(1, acceptRejectCode);
                    statement.setInt(2, requisition_ID);

                    int rowsAffected = statement.executeUpdate();
                    if (rowsAffected == 1) {
                        //Everything Done Successfully
                        return true;
                    } else {
                        return false;
                    }
                } else return false;
            } else {
                return false;
            }

        } catch (SQLException e) {
            System.out.println("Exception Occured While Accepting / Rejecting");
            System.out.println(e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateProjectForEmployeeInDatabase(int managerID, int employeeID, int projectID) {

        DBUtil dbUtilInstance = DBUtil.getInstance();
        try (
                // Try With Resources
                Connection connection = dbUtilInstance.getConnection();
                PreparedStatement statement = connection.prepareStatement(IClientQueryMapper.UPDATE_EMPLOYEE_ALLOCATION);
        ) {

            statement.setInt(1, projectID);
            statement.setInt(2, IRSValues.ALLOCATED_IN_PROJECT);
            statement.setInt(3, employeeID);

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
    public boolean updateProjectDetailsInDatabase(int managerID, int projectID) {
        return true;
    }

}
