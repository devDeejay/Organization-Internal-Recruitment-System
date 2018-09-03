package com.demo.Model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import oracle.net.aso.e;

public class RequisitionRequest {

	/*
	 * , skills_required VARCHAR2(4000), domain VARCHAR2(50),
	 */

	int requsitionID;
	int resourceManagerID;
	int executiveID;
	int projectID;
	int requestStatus;
	int vacancy;
	int numberOfPeopleRequired;
	String skillsAsString;
	String domainName;
	ArrayList<String> skills;
	Date dateCreated;
	Date dateClosed;

	public int getRequsitionID() {
		return requsitionID;
	}
	
	public int getExecutiveID(){
		return executiveID;
	}

	public int getResourceManagerID() {
		return resourceManagerID;
	}

	public int getProjectID() {
		return projectID;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public Date getDateClosed() {
		return dateClosed;
	}

	public String getRequestStatus() {
		
		if (requestStatus == 300) {
			return "OPEN";
		}
		
		else {
			return "CLOSED";
		}
	}

	public int getVacancy() {
		return vacancy;
	}

	public ArrayList<String> getSkills() {
		return skills;
	}

	public String getSkillsAsString() {
		return skillsAsString;
	}

	public String getDomainName() {
		return domainName;
	}

	public int getNumberOfPeopleRequired() {
		return numberOfPeopleRequired;
	}

	// Creating Builder Pattern Static Class

	public static class Builder {

		int requsitionID;
		int executiveID;
		int resourceManagerID;
		int projectID;
		int numberOfPeopleRequired;
		int requestStatus;
		int vacancy;
		ArrayList<String> skills;
		String skillsAsString;
		String domainName;
		Date dateCreated;
		Date dateClosed;

		public Builder() {

		}

		public RequisitionRequest build() {
			return new RequisitionRequest(this);
		}

		public Builder requsitionID(int requsitionID) {
			this.requsitionID = requsitionID;
			return this;
		}
		
		public Builder executiveID(int executiveID) {
			this.executiveID = executiveID;
			return this;
		}

		public Builder resourceManagerID(int resourceManagerID) {
			this.resourceManagerID = resourceManagerID;
			return this;
		}

		public Builder projectID(int projectID) {
			this.projectID = projectID;
			return this;
		}

		public Builder numberOfPeopleRequired(int numberOfPeopleRequired) {
			this.numberOfPeopleRequired = numberOfPeopleRequired;
			return this;
		}

		public Builder requestStatus(int requestStatus) {
			this.requestStatus = requestStatus;
			return this;
		}

		public Builder vacancy(int vacancy) {
			this.vacancy = vacancy;
			return this;
		}

		public Builder skillsAsString(String skillsAsString) {
			this.skillsAsString = skillsAsString;
			return this;
		}

		public Builder domainName(String domainName) {
			this.domainName = domainName;
			return this;
		}

		public Builder dateCreated(Date dateCreated) {
			this.dateCreated = dateCreated;
			return this;
		}

		public Builder dateClosed(Date dateClosed) {
			this.dateClosed = dateClosed;
			return this;
		}

	} // End Of Builder Class

	private RequisitionRequest(Builder builder) {
		this.requsitionID = builder.requsitionID;
		this.executiveID = builder.executiveID;
		this.resourceManagerID = builder.resourceManagerID;
		this.projectID = builder.projectID;
		this.numberOfPeopleRequired = builder.numberOfPeopleRequired;
		this.requestStatus = builder.requestStatus;
		this.vacancy = builder.vacancy;
		this.skills = builder.skills;
		this.skillsAsString = builder.skillsAsString;
		this.domainName = builder.domainName;
		this.dateCreated = builder.dateCreated;
		this.dateClosed = builder.dateClosed;
	}

}
