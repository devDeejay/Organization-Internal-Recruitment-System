package com.demo.DAO.Implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.demo.Util.IClientQueryMapper;
import com.demo.DAO.Interfaces.UserDAOInterface;
import com.demo.Model.User;
import com.demo.Util.DBUtil;

public class UserDAOInterfaceImplementation implements UserDAOInterface {
	@Override
	public User checkUserCredentialsInDatabase(User newUser) {

		String username = newUser.getUsername();
		String password = newUser.getPassword();

		// Preparing User Object To Be Returned
		User loggedInUser = null;
		User.Builder builder = new User.Builder();

		try {

			DBUtil dbUtilInstance = DBUtil.getInstance();
			Connection connection = dbUtilInstance.getConnection();

			PreparedStatement preparedStatement = connection
					.prepareStatement(IClientQueryMapper.VALIDATE_USER_QUERY);

			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				// Inserting Valid Details Into Object
				
				builder.userID(resultSet.getInt("user_id"))
						.name(resultSet.getString("name"))
						.userGrade(resultSet.getInt("user_grade"))
						.isValidUser(true);


			} else {

				// Inserting Invalid Details Into Object
				
				System.out.println("UserDAO : Invalid User In Database");
				builder.isValidUser(false);

			}
			
			//Building The User Object
			loggedInUser = builder.build();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		// Returning The LoggedInUser Object

		return loggedInUser;

	}
}
