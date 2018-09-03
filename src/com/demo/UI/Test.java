package com.demo.UI;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.demo.Model.Employee;
import com.demo.Util.DBUtil;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		String inputStringDate = input.next();
		
		SimpleDateFormat format = new SimpleDateFormat("DD-MMM-YYYY");
		java.util.Date parsedDate = null;
		try {
			parsedDate = format.parse(inputStringDate);
			Date sqlDate = new Date(parsedDate.getTime());
		} catch (ParseException e) {
			System.out.println("Error Occured");
			e.printStackTrace();
		}
		
	System.out.println("All done" );
	}

}
