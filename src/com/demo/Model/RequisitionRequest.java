package com.demo.Model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public class RequisitionRequest {

    int requsitionID;
    int resourceManagerID;
    int projectID;
    Date dateCreated;
    Date dateClosed;
    int requestStatus;
    int vacancy;
    ArrayList<String> skills;
    String domainName;
    int numberOfPeopleRequired;

    public RequisitionRequest(){}

    public RequisitionRequest(int resourceManagerID, int projectID, Date dateCreated, Date dateClosed, int requestStatus, int vacancy, ArrayList<String> skills, String domainName, int numberOfPeopleRequired) {
        this.resourceManagerID = resourceManagerID;
        this.projectID = projectID;
        this.dateCreated = dateCreated;
        this.dateClosed = dateClosed;
        this.requestStatus = requestStatus;
        this.vacancy = vacancy;
        this.skills = skills;
        this.domainName = domainName;
        this.numberOfPeopleRequired = numberOfPeopleRequired;
    }

    public RequisitionRequest(int requsitionID, int resourceManagerID, int projectID, Date dateCreated, Date dateClosed, int requestStatus, int vacancy, ArrayList<String> skills, String domainName, int numberOfPeopleRequired) {
        this.requsitionID = requsitionID;
        this.resourceManagerID = resourceManagerID;
        this.projectID = projectID;
        this.dateCreated = dateCreated;
        this.dateClosed = dateClosed;
        this.requestStatus = requestStatus;
        this.vacancy = vacancy;
        this.skills = skills;
        this.domainName = domainName;
        this.numberOfPeopleRequired = numberOfPeopleRequired;
    }

    public RequisitionRequest(int managerID, int projectID, int requestStatus, int vacancy, ArrayList<String> skills, String domainName, int numberOfPeopleRequired) {
        this.requsitionID = requsitionID;
        this.resourceManagerID = managerID;
        this.projectID = projectID;
        this.dateCreated = dateCreated;
        this.dateClosed = dateClosed;
        this.requestStatus = requestStatus;
        this.vacancy = vacancy;
        this.skills = skills;
        this.domainName = domainName;
        this.numberOfPeopleRequired = numberOfPeopleRequired;
    }

    public int getRequsitionID() {
        return requsitionID;
    }

    public void setRequsitionID(int requsitionID) {
        this.requsitionID = requsitionID;
    }

    public int getResourceManagerID() {
        return resourceManagerID;
    }

    public void setResourceManagerID(int resourceManagerID) {
        this.resourceManagerID = resourceManagerID;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateClosed() {
        return dateClosed;
    }

    public void setDateClosed(Date dateClosed) {
        this.dateClosed = dateClosed;
    }

    public int getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(int requestStatus) {
        this.requestStatus = requestStatus;
    }

    public int getVacancy() {
        return vacancy;
    }

    public void setVacancy(int vacancy) {
        this.vacancy = vacancy;
    }

    public ArrayList<String> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<String> skills) {
        this.skills = skills;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public int getNumberOfPeopleRequired() {
        return numberOfPeopleRequired;
    }

    public void setNumberOfPeopleRequired(int numberOfPeopleRequired) {
        this.numberOfPeopleRequired = numberOfPeopleRequired;
    }
}
