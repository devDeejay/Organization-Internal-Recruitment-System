package com.demo.Model;

import java.util.ArrayList;

public class RequisitionSuggestions extends Employee{

    private int requisitionSuggestionID;
    private int suggestedEmployeeID;
    private int suggestedProjectID;
    private int suggestionStatus;

    public RequisitionSuggestions(){}

    public RequisitionSuggestions(int suggestedEmployeeID, int suggestedProjectID, String suggestedEmployeeName, String suggestedEmployeeDomain, ArrayList<String> skills, int suggestedEmployeeYearsOfExperience) {
        this.suggestedEmployeeID = suggestedEmployeeID;
        this.suggestedProjectID = suggestedProjectID;
    }

    public int getRequisitionSuggestionID() {
        return requisitionSuggestionID;
    }

    public void setRequisitionSuggestionID(int requisitionSuggestionID) {
        this.requisitionSuggestionID = requisitionSuggestionID;
    }

    public int getSuggestedEmployeeID() {
        return suggestedEmployeeID;
    }

    public void setSuggestedEmployeeID(int suggestedEmployeeID) {
        this.suggestedEmployeeID = suggestedEmployeeID;
    }

    public int getSuggestedProjectID() {
        return suggestedProjectID;
    }

    public void setSuggestedProjectID(int suggestedProjectID) {
        this.suggestedProjectID = suggestedProjectID;
    }
}
