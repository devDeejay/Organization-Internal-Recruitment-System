package com.demo.Util;

import java.sql.Connection;
import java.sql.DriverManager;

//	==========================================
//	=                                        =
//	=  	  		DBUtil.java Class     		 =
//	=   Following Singleton Design Pattern   =
//	=                                        =
//	==========================================


public class DBUtil {
	
	//	Declaring Following Fields as 'Volatile'
	//	So as to make them Thread Safe 
	
	private volatile Connection connectionInstance = null;
	private static volatile DBUtil dbUtilInstance = null;

	private DBUtil() {
		// TODO Auto-generated constructor stub
	}

	// 	GetInstance Method For DBUtil
	public static DBUtil getInstance() {

		if (dbUtilInstance == null) {
			synchronized (DBUtil.class) {
				if (dbUtilInstance == null) {
					dbUtilInstance = new DBUtil();
				}
			}
		}
		return dbUtilInstance;
	}

	// GetInstance Method For Connection
	
	public Connection getConnection() {
		if (connectionInstance == null) {
			synchronized (DBUtil.class) {
				if (connectionInstance == null) {
					try {
						connectionInstance = DriverManager.getConnection(IRSValues.DB_URL,
								IRSValues.DB_USERNAME, IRSValues.DB_PASSWORD);
					} catch (Exception e) {
						
						// TODO: Throw Some Exception Here
						
						System.out.println(e.getMessage());
						System.out.println("Failed To Instantiate Connection Object");
						connectionInstance = null;
					}
				}
			}
		}
		return connectionInstance;
	}

	// 	Method For Closing The Connection
	
	public boolean closeConnection() {
		boolean status = false;
		if (connectionInstance != null) {
			try {
				connectionInstance = null;
				status = true;
			} catch (Exception e) {
				
				// TODO: Throw Some Exception Here
				
				System.out.println("Failed To Close Connection Object");
			}
		}
		return status;
	}
}
