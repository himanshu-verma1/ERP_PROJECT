package com.erp.view;

public class EmployeeView {
	public static int EmployeeHome() {
		System.out.println("******************************************************************************");
		System.out.println("**************************** Welcome Employee  *******************************");
		System.out.println("******************************************************************************");

		System.out.println("1.Profile");
		System.out.println("2.WorkArea");
		System.out.println("3.Back");
		System.out.println("4.Exit");
		System.out.println("Enter Your Choice :- ");
		return 0;
	}

	public static int profile() {
		System.out.println("1.View Profile");
		System.out.println("2.Edit Profile");
		System.out.println("3.Back");
		System.out.println("4.Exit");
		System.out.println("Enter Your Choice :- ");
		return 0;
	}
	
	public static int workarea() {
		System.out.println("1.View List of Project");
		System.out.println("2.Send update for current working project");
		System.out.println("3.Back");
		System.out.println("4.Exit");
		System.out.println("Enter Your Choice :- ");
		return 0;
	}
}
