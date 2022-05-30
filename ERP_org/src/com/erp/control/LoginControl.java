package com.erp.control;
import java.util.Scanner;

import com.erp.servicelayer.Loginservice;
import com.erp.view.LoginPage;

public class LoginControl {
	public static void loginControl() {
		Scanner s = new Scanner(System.in);
		LoginPage.loginDisplay();
		int n=0;
		try {
			n = s.nextInt();
		} catch (Exception e) {
			System.out.println("Please enter correct format .... ");
			loginControl();
		}
		System.out.println("******************************************************************************");
		System.out.println("Enter your username");
		String username = s.next();
		System.out.println("Enter your password");
		String password = s.next();
		switch (n) {
		case 1: {
			boolean result = Loginservice.adminCheck(username, password);
			if (result) {
				AdminControl.adminControl();
			} else {
				System.out.println("Username or Password is incorrect......");
				loginControl();
			}
			break;
		}

		case 2: {
			boolean result = Loginservice.checkEmp(username, password, "Employee");
			if (result) {
				EmployeeControl.employeeControl(username);
			} else {
				System.out.println("Username or Password is incorrect......");
				loginControl();
			}
			break;
		}

		case 3: {
			boolean result = Loginservice.checkEmp(username, password, "projectmanager");
			if (result) {
				ProjectManagerControl.projectManagerControl(username);
			} else {
				System.out.println("Username or Password is incorrect......");
				loginControl();
			}
			break;
		}

		default:
			System.out.println("Insert correct choice .... ");
			loginControl();
			break;
		}
	}

}
