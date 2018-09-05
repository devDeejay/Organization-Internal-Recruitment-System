package com.demo.UI;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import com.demo.Model.Employee;
import com.demo.Util.DBUtil;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		ArrayList<String> strings = new ArrayList<>();
		strings.add("SE");
		strings.add("EE");
		strings.add("ME");
		strings.add("SE");
		strings.add("EE");

		strings.remove("SE");

		for (String s : strings) {
			System.out.println(s);
		}
	}}
