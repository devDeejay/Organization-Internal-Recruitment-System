package com.demo.Model;

public class User {
	int userID;
	int userGrade;
	String username;
	String password;
	String name;
	boolean isValidUser;

	private User(Builder builder) {
		this.userID = builder.userID;
		this.userGrade = builder.userGrade;
		this.username = builder.username;
		this.password = builder.password;
		this.name = builder.name;
		this.isValidUser = builder.isValidUser;
	}

	public User() {
	}

	public String getName() {
		return name;
	}

	public int getUserID() {
		return userID;
	}

	public boolean isValidUser() {
		return isValidUser;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public int getUserGrade() {
		return userGrade;
	}

	public static class Builder {
		int userID;
		int userGrade;
		String username;
		String password;
		String name;
		boolean isValidUser;

		public Builder() {

		}

		public User build() {
			return new User(this);
		}

		public Builder userID(int userId) {
			this.userID = userId;
			return this;
		}

		public Builder isValidUser(boolean isValidUser) {
			this.isValidUser = isValidUser;
			return this;
		}

		public Builder userGrade(int userGrade) {
			this.userGrade = userGrade;
			return this;
		}

		public Builder username(String username) {
			this.username = username;
			return this;
		}

		public Builder password(String password) {
			this.password = password;
			return this;
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder name(boolean isValidUser) {
			this.isValidUser = isValidUser;
			return this;
		}
	} // End Of Builder Class

}
