package com.demo.Service;

import com.demo.Model.RequisitionSuggestions;
import com.demo.Model.RequsitionRequest;

import java.util.ArrayList;

public class ResouceManagerImplementation implements ResouceManagerInterface {
    @Override
    public int raiseRequisitionRequest(RequsitionRequest request) {
        return 0;
    }

    @Override
    public ArrayList<RequisitionSuggestions> viewSuggestionsMadeByExecutive(int managerID) {
        return null;
    }

    @Override
    public boolean acceptRejectSuggestions(int managerID, int requsitionIDToAcceptReject, int acceptRejectCode) {
        return false;
    }

    @Override
    public boolean updateProjectForEmployee( int managerID, int employeeID, int projectID) {
        return false;
    }

    @Override
    public boolean updateProjectDetails(int managerID, int projectID) {
        return false;
    }

    @Override
    public String generateReportForAllRequests(int maangerID) {
        return null;
    }
}
