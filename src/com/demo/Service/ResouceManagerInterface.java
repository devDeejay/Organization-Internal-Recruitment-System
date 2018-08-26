package com.demo.Service;

import com.demo.Model.RequisitionSuggestions;
import com.demo.Model.RequsitionRequest;

import java.util.ArrayList;

public interface ResouceManagerInterface {
    /*
     * TODO : Raise Requisition Requests For Concerned People.
     * TODO : View All The Suggestions Made By RMGExecutiveDAOInterface.
     * TODO : Accept / Reject The Suggested Resources Against Requisitions.
     * TODO : If Accepted, Update The Project Status For Project ID, UserID.
     * TODO : Manually Update The Project Name, Code.
     * TODO : Generate Reports For Pending As Well As Closed Requests of his projects.
     */

    int raiseRequisitionRequest(RequsitionRequest request);

    ArrayList<RequisitionSuggestions> viewSuggestionsMadeByExecutive(int managerID);

    boolean acceptRejectSuggestions(int managerID, int requisitionIDToAcceptReject, int acceptRejectCode);

    boolean updateProjectForEmployee(int managerID, int employeeID, int projectID);

    boolean updateProjectDetails(int managerID, int projectID);

    String generateReportForAllRequests(int managerID);

}
