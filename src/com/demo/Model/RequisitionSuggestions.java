package com.demo.Model;

import java.util.ArrayList;

public class RequisitionSuggestions {

    int requisitionSuggestionID;
    int empID;
    int suggestedProjectID;
    String employeeName;
    String domain;
    ArrayList<String> skills;
    int yearsOfExperience;

    public RequisitionSuggestions(){}

    public RequisitionSuggestions(int empID, int suggestedProjectID, String employeeName, String domain, ArrayList<String> skills, int yearsOfExperience) {
        this.empID = empID;
        this.suggestedProjectID = suggestedProjectID;
        this.employeeName = employeeName;
        this.domain = domain;
        this.skills = skills;
        this.yearsOfExperience = yearsOfExperience;
    }

    public int getRequisitionSuggestionID() {
        return requisitionSuggestionID;
    }

    public void setRequisitionSuggestionID(int requisitionSuggestionID) {
        this.requisitionSuggestionID = requisitionSuggestionID;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public int getSuggestedProjectID() {
        return suggestedProjectID;
    }

    public void setSuggestedProjectID(int suggestedProjectID) {
        this.suggestedProjectID = suggestedProjectID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public ArrayList<String> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<String> skills) {
        this.skills = skills;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }
}
