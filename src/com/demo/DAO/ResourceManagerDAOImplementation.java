package com.demo.DAO;

import com.demo.Model.RequisitionSuggestions;
import com.demo.Model.RequisitionRequest;

import java.util.ArrayList;

public class ResourceManagerDAOImplementation implements ResourceManagerDAOInterface {
    @Override
    public int raiseRequisitionRequestInDatabase(RequisitionRequest request) {
        return 0;
    }

    @Override
    public ArrayList<RequisitionSuggestions> viewSuggestionsMadeByExecutiveFromDatabase(int managerID) {
        return null;
    }

    @Override
    public boolean acceptRejectSuggestionsInDatabase(int managerID, int requisitionIDToAcceptReject, int acceptRejectCode) {
        return false;
    }

    @Override
    public boolean updateProjectForEmployeeInDatabase(int managerID, int employeeID, int projectID) {
        return false;
    }

    @Override
    public boolean updateProjectDetailsInDatabase(int managerID, int projectID) {
        return false;
    }

    @Override
    public String generateReportForAllRequestsFromDatabase(int managerID) {
        return null;
    }
}
