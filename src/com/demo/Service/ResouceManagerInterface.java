package com.demo.Service;

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

    boolean raiseRequisitionRequest(RequsitionRequest request);

    ArrayList<RequsitionRequest> viewSuggestionsMadeByExecutive(int managerID);

    boolean acceptRejectSuggestions(int managerID);

    boolean updateProjectForEmployee(int projectID, int employeeID);

    boolean updateProjectDetails(int projectID);

    String generateReportForAllRequests();

}
