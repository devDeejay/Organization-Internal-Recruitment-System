package com.demo.Service.Implementation;

import com.demo.DAO.Implementation.ResourceManagerDAOImplementation;
import com.demo.Model.RequisitionSuggestions;
import com.demo.Model.RequisitionRequest;
import com.demo.Service.Interface.ResouceManagerInterface;

import java.util.ArrayList;

public class ResouceManagerImplementation implements ResouceManagerInterface {
	
	ResourceManagerDAOImplementation resourceManagerDAO = new ResourceManagerDAOImplementation(); 
	
    @Override
    public int raiseRequisitionRequest(RequisitionRequest request) {
        return resourceManagerDAO.raiseRequisitionRequestInDatabase(request);
    }

    @Override
    public boolean acceptRejectSuggestions(int managerID, int requisitionSuggestionID, int choice) {
        return resourceManagerDAO.acceptRejectSuggestionsInDatabase(managerID, requisitionSuggestionID, choice);
    }

    @Override
    public boolean updateProjectForEmployee( int managerID, int employeeID, int projectID) {
        return resourceManagerDAO.updateProjectForEmployeeInDatabase(managerID, employeeID, projectID);
    }

    @Override
    public boolean updateProjectDetails(int managerID, int projectID) {
        return true;
    }

    @Override
    public String generateReportForAllRequests(int maangerID) {
    	return null;
    }

	@Override
	public ArrayList<RequisitionRequest> viewAllRequests(int managerID, int choice) {
		// TODO Auto-generated method stub
		return resourceManagerDAO.viewAllRequestsMade(managerID, choice);

	}

	@Override
	public ArrayList<RequisitionSuggestions> viewSuggestionsMadeByExecutive(int managerID, int suggestionCode) {
		return resourceManagerDAO.viewSuggestionsMadeByExecutiveFromDatabase(managerID, suggestionCode);
	}
}
