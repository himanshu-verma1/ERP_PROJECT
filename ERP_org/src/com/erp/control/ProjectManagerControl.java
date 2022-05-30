package com.erp.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.erp.model.Project;
import com.erp.model.Projectmanager;
import com.erp.servicelayer.Projectmanagerservice;
import com.erp.view.ProjectManagerView;

public class ProjectManagerControl {
	public static void projectManagerControl(String userName) {
		ProjectManagerView.ProjectManagerViewHome();
		Scanner s = new Scanner(System.in);
		int n = 0;
		try {
			n = s.nextInt();
		} catch (Exception e) {
			System.out.println("Enter correct format ...");
			projectManagerControl(userName);
		}

		switch (n) {
		case 1: {
			break;
		}
		case 2: {
			break;
		}
		case 3: {
			break;
		}
		case 4: {
			System.exit(0);
		}
		default: {
			System.out.println("Enter correct choice...");
			projectManagerControl(userName);
		}
		}
	}

	public static void Workarea(String userName) {
		ProjectManagerView.workarea();
		Scanner s = new Scanner(System.in);
		int n = 0;
		try {
			n = s.nextInt();
		} catch (Exception e) {
			System.out.println("Please enter right format...");
		}
		switch (n) {
		case 1: {
			viewProject(userName);
			break;
		}
		case 2: {
			editProject(userName);
			break;
		}
		case 3: {
			projectManagerControl(userName);
			break;
		}
		case 4: {
			System.exit(0);
			break;
		}
		default:
			System.out.println("Please enter right choice......");
			Workarea(userName);
		}

	}

	public static void profile(String userName) {
		ProjectManagerView.profile();
		Scanner s = new Scanner(System.in);
		int n = 0;
		try {
			n = s.nextInt();
		} catch (Exception e) {
			System.out.println(" Please Enter Correct format.....");
			EmployeeControl.profile(userName);
		}
		switch (n) {
		case 1: {
			viewProfile(userName);
			break;
		}
		case 2: {
			editProfile(userName);
			break;
		}
		case 3: {
			projectManagerControl(userName);
			break;
		}
		case 4: {
			System.exit(0);
			break;
		}
		default: {
			System.out.println("Please enter correct number ... ");
			profile(userName);
		}
		}
	}

	public static void editProfile(String userName) {
		List<String> list = new ArrayList<String>();
		Scanner s = new Scanner(System.in);
		System.out.println("Updated Employee name");
		list.add(s.next());
		System.out.println("Updated Employee Email");
		list.add(s.next());
		System.out.println("Updated Employee contact number");
		list.add(s.next());
		System.out.println("Updated Employee Address ");
		list.add(s.next());

		boolean result = Projectmanagerservice.checkEdit(userName, list);
		if (result) {
			System.out.println("******************************************************************************");
			System.out.println("Update Successfully...");
			System.out.println("******************************************************************************");
		} else {
			System.out.println("Something wrong .... ");
		}
		profile(userName);
	}

	public static void viewProfile(String userName) {
		List<Projectmanager> listemp = Projectmanagerservice.checkProfile(userName);
		System.out.println("******************************************************************************");
		System.out.println(
				"--------------------------------------------------------------------------------------------");
		System.out.printf("%-5s %-15s %-30s %-15s %-15s %-15s", "Id", "Name", "Email", "Contact", "Address",
				"Username");
		System.out.println();
		System.out.println(
				"--------------------------------------------------------------------------------------------");
		for (Projectmanager emp : listemp) {
			System.out.printf("%-5d %-15s %-30s %-15s %-15s %-15s", emp.getId(), emp.getName(), emp.getEmail(),
					emp.getContact(), emp.getAddress(), emp.getUsername());
			System.out.println();
		}
		System.out.println(
				"--------------------------------------------------------------------------------------------");

		profile(userName);
	}

	public static void viewProject(String userName) {
		System.out.println("******************************************************************************");
		System.out.println(
				"--------------------------------------------------------------------------------------------");
		List<Project> listpm = Projectmanagerservice.checkviewProject();
		System.out.printf("%-5s %-15s %-15s %-15s ", "Id", "Name", "Duration", "Status");
		System.out.println();
		System.out.println(
				"--------------------------------------------------------------------------------------------");
		for (Project pm : listpm) {
			System.out.printf("%-5d %-15s %-15s %-15s", pm.getId(), pm.getName(), pm.getDuration(), pm.getStatus());
			System.out.println();
		}
		System.out.println(
				"--------------------------------------------------------------------------------------------");
		Workarea(userName);
	}

	public static void editProject(String userName) {
		System.out.println("******************************************************************************");
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Project Id");
		int n = 0;
		try {
			n = s.nextInt();
		} catch (Exception e) {
			System.out.println("******************************************************************************");
			System.out.println("Please Enter correct format......");
			editProject(userName);
		}

		System.out.println("Enter Project Status");
		String status = s.next();

		int i = Projectmanagerservice.checkeditProject(n, status);

		if (i == 1) {
			System.out.println("******************************************************************************");
			System.out.println("Project Update Successfully...");
			System.out.println("******************************************************************************");
		} else {
			System.out.println("Something wrong");
		}

		Workarea(userName);
	}

}
