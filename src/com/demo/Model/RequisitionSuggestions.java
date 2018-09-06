package com.demo.Model;

import java.sql.Date;
import java.util.ArrayList;

import com.demo.Model.RequisitionRequest.Builder;

public class RequisitionSuggestions extends Employee {

	private int requisitionSuggestionID;
	private int requisitionRequestID;
	private String suggestedEmployeeID;
	private int suggestedProjectID;
	private int suggestionStatus;
	private int executiveID;
	private int managerID;

	public int getRequisitionSuggestionID() {
		return requisitionSuggestionID;
	}

	public int getRequisitionRequestID() {
		return requisitionRequestID;
	}

	public int getExecutiveID() {
		return executiveID;
	}

	public int getManagerID() {
		return managerID;
	}

	public String getSuggestedEmployeeID() {
		return suggestedEmployeeID;
	}

	public int getSuggestedProjectID() {
		return suggestedProjectID;
	}

	public int getSuggestionStatus() {
		return suggestionStatus;
	}

	public static class Builder {

		private int requisitionSuggestionID;
		private String suggestedEmployeeID;
		private int suggestedProjectID;
		private int suggestionStatus;
		private int requisitionRequestID;
		private int executiveID;
		private int managerID;

		public Builder() {

		}

		public RequisitionSuggestions build() {
			return new RequisitionSuggestions(this);
		}

		public Builder requisitionRequestID(int requisitionRequestID) {
			this.requisitionRequestID = requisitionRequestID;
			return this;
		}

		public Builder managerID(int managerID) {
			this.managerID = managerID;
			return this;
		}

		public Builder executiveID(int executiveID) {
			this.executiveID = executiveID;
			return this;
		}

		public Builder suggestedEmployeeID(String suggestedEmployeeID) {
			this.suggestedEmployeeID = suggestedEmployeeID;
			return this;
		}

		public Builder suggestedProjectID(int suggestedProjectID) {
			this.suggestedProjectID = suggestedProjectID;
			return this;
		}

		public Builder requisitionSuggestionID(int requisitionSuggestionID) {
			this.requisitionSuggestionID = requisitionSuggestionID;
			return this;
		}

		public Builder suggestionStatus(int suggestionStatus) {
			this.suggestionStatus = suggestionStatus;
			return this;
		}

	} // End Of Builder Class

	private RequisitionSuggestions(Builder builder) {
		this.requisitionSuggestionID = builder.requisitionSuggestionID;
		this.requisitionRequestID = builder.requisitionRequestID;
		this.suggestedEmployeeID = builder.suggestedEmployeeID;
		this.suggestedProjectID = builder.suggestedProjectID;
		this.suggestionStatus = builder.suggestionStatus;
		this.executiveID = builder.executiveID;
		this.managerID = builder.managerID;
	}
}
