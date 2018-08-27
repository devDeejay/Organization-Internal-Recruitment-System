package com.demo.DAO;

import com.demo.Model.RequisitionSuggestions;
import com.demo.Model.RequsitionRequest;

import java.util.ArrayList;

public interface ResourceManagerDAOInterface {

    /*
     * TODO : Raise Requisition Requests For Concerned People.
     * TODO : View All The Suggestions Made By RMGExecutiveDAOInterface.
     * TODO : Accept / Reject The Suggested Resources Against Requisitions.
     * TODO : If Accepted, Update The Project Status For Project ID, UserID.
     * TODO : Manually Update The Project Name, Code.
     * TODO : Generate Reports For Pending As Well As Closed Requests of his projects.
     */

    int raiseRequisitionRequestInDatabase(RequsitionRequest request);

    ArrayList<RequisitionSuggestions> viewSuggestionsMadeByExecutiveFromDatabase(int managerID);

    boolean acceptRejectSuggestionsInDatabase(int managerID, int requisitionIDToAcceptReject, int acceptRejectCode);

    boolean updateProjectForEmployeeInDatabase(int managerID, int employeeID, int projectID);

    boolean updateProjectDetailsInDatabase(int managerID, int projectID);

    String generateReportForAllRequestsFromDatabase(int managerID);
}
