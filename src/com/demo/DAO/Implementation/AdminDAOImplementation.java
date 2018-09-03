package com.demo.DAO.Implementation;

import com.demo.Util.IClientQueryMapper;
import com.demo.DAO.Interfaces.AdminDAOInterface;
import com.demo.Model.User;
import com.demo.Util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AdminDAOImplementation implements AdminDAOInterface {
	
	//All Working, Validation of Data Still Left

	@Override
	public boolean addUserToDatabase(User userToBeAdded) {

		boolean returnStatus = false;

		String username = userToBeAdded.getUsername();
		String name = userToBeAdded.getName();
		String password = userToBeAdded.getPassword();
		int userGrade = userToBeAdded.getUserGrade();

		System.out.println("userGrade rcvd " + userGrade);

		try {

			DBUtil dbUtilInstance = DBUtil.getInstance(); 
			Connection connection = dbUtilInstance.getConnection();

			PreparedStatement preparedStatement = connection
					.prepareStatement(IClientQueryMapper.ADD_USER_TO_DATABASE_QUERY);
			preparedStatement.setInt(1, userGrade);
			System.out.println("Setting usergrade " + userGrade);
			preparedStatement.setString(2, username);
			preparedStatement.setString(3, password);
			preparedStatement.setString(4, name);

			int status = preparedStatement.executeUpdate();

			if (status == 1) {
				returnStatus = true;
			} else {
				System.out.println("Returning Status Still FALSE");
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return returnStatus;
	}

	@Override
	public ArrayList<User> viewUsersInDatabase() {

		// TODO : Add Users To Array list From Database

		ArrayList<User> listOfUsers = new ArrayList<>();
		
		try {

			DBUtil dbUtilInstance = DBUtil.getInstance(); 
			Connection connection = dbUtilInstance.getConnection();

			PreparedStatement preparedStatement = connection
					.prepareStatement(IClientQueryMapper.VIEW_USERS_IN_DATABASE);
		

			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {

		        User.Builder builder = new User.Builder();

		        builder
		        .userID(resultSet.getInt("user_id"))
		        .name(resultSet.getString("name"))
		        .username(resultSet.getString("username"))
		        .userGrade(resultSet.getInt("user_grade"))
		        .password(resultSet.getString("username"));
		        
		        User user = builder.build();

		        listOfUsers.add(user);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return listOfUsers;
	}
	
	@Override
	public boolean modifyUserFromDatabase(User userToBeModified) {

		boolean returnStatus = false;

		String username = userToBeModified.getUsername();
		String name = userToBeModified.getName();
		String password = userToBeModified.getPassword();
		int userGrade = userToBeModified.getUserGrade();
		int userID = userToBeModified.getUserID();

		System.out.println("userGrade rcvd " + userGrade);

		try {

			DBUtil dbUtilInstance = DBUtil.getInstance();
			Connection connection = dbUtilInstance.getConnection();

			PreparedStatement preparedStatement = connection
					.prepareStatement(IClientQueryMapper.UPDATE_USER_IN_DATABASE);

			preparedStatement.setInt(1, userGrade);
			preparedStatement.setString(2, username);
			preparedStatement.setString(3, password);
			preparedStatement.setString(4, name);
			preparedStatement.setInt(5, userID);

			int status = preparedStatement.executeUpdate();

			if (status == 1) {
				returnStatus = true;
			} else {
				System.out.println("Something Went Wrong Here In 91");
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return returnStatus;
	}

	@Override
	public boolean deleteUserFromDatabase(User userToBeDeleted) {

		int id = userToBeDeleted.getUserID();

		boolean returnStatus = false;

		try {

			DBUtil dbUtilInstance = DBUtil.getInstance();
			Connection connection = dbUtilInstance.getConnection();

			PreparedStatement preparedStatement = connection
					.prepareStatement(IClientQueryMapper.DELETE_USER_FROM_DATABASE);

			preparedStatement.setInt(1, id);

			int status = preparedStatement.executeUpdate();

			if (status == 1) {
				returnStatus = true;
			} else {
				System.out.println("Something Went Wrong While Deleting");
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return returnStatus;
	}

}
