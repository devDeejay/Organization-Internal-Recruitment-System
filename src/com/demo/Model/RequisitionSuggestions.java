package com.demo.Model;

import java.sql.Date;
import java.util.ArrayList;

import com.demo.Model.RequisitionRequest.Builder;

public class RequisitionSuggestions extends Employee {

	private int requisitionSuggestionID;
	private int requisitionRequestID;
	private int suggestedEmployeeID;
	private int suggestedProjectID;
	private int suggestionStatus;

	public int getRequisitionSuggestionID() {
		return requisitionSuggestionID;
	}

	public int getRequisitionRequestID() {
		return requisitionRequestID;
	}

	public int getSuggestedEmployeeID() {
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
		private int suggestedEmployeeID;
		private int suggestedProjectID;
		private int suggestionStatus;
		private int requisitionRequestID;
		
		public Builder() {

		}

		public RequisitionSuggestions build() {
			return new RequisitionSuggestions(this);
		}

		public Builder requisitionRequestID(int requisitionRequestID) {
			this.requisitionRequestID = requisitionRequestID;
			return this;
		}

		public Builder suggestedEmployeeID(int suggestedEmployeeID) {
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
		this.suggestedEmployeeID = builder.suggestedEmployeeID;
		this.suggestedProjectID = builder.suggestedProjectID;
		this.suggestionStatus = builder.suggestionStatus;
		this.requisitionRequestID = builder.requisitionRequestID;
	}
}
