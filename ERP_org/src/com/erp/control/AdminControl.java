package com.erp.control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.erp.dao.AdminDao;
import com.erp.model.Employee;
import com.erp.model.Project;
import com.erp.model.Projectmanager;
import com.erp.servicelayer.Adminservice;
import com.erp.view.AdminView;

public class AdminControl {
	public static void adminControl() {
		Scanner s = new Scanner(System.in);
		AdminView.adminHome();
		int n = 0;
		try {
			n = s.nextInt();
		} catch (Exception e) {
			System.out.println("******************************************************************************");
			System.out.println("Please Enter correct format......");
			adminControl();
		}
		switch (n) {
		case 1: {
			AdminView.EmployeeMenu();
			AdminEmplopyee();
			break;
		}
		case 2: {
			AdminView.ProjectMenu();
			AdminProject();
			break;
		}
		case 3: {
			AdminView.ProjectManagerMenu();
			AdminProjectManager();
			break;
		}
		case 4: {
			LoginControl.loginControl();
			break;
		}
		case 5: {
			System.exit(0);
		}
		default: {
			System.out.println("******************************************************************************");
			System.out.println("Insert correct choice ....");
			adminControl();
		}
		}
	}

	public static void AdminEmplopyee() {
		Scanner s = new Scanner(System.in);
		int n = 0;
		try {
			n = s.nextInt();
		} catch (Exception e) {
			System.out.println("******************************************************************************");
			System.out.println("Please Enter correct format......");
			AdminView.EmployeeMenu();
			AdminEmplopyee();
		}
		switch (n) {
		case 1:
			insertEmployee();
			break;

		case 2: {
			getEmployee();
			break;
		}

		case 3: {
			getAllemployee();
			break;
		}
		case 4: {
			deleteEmployee();
			break;
		}
		case 5: {
			updateEmployee();
			break;
		}
		case 6: {
			adminControl();
			break;
		}
		case 7: {
			System.exit(0);
			break;
		}
		default: {
			System.out.println("******************************************************************************");
			System.out.println("Insert correct choice ....");
			AdminEmplopyee();
			break;
		}
		}
	}

	public static void AdminProject() {
		Scanner s = new Scanner(System.in);
		int n = 0;
		try {
			n = s.nextInt();
		} catch (Exception e) {
			System.out.println("******************************************************************************");
			System.out.println("Please Enter correct format......");
			AdminView.ProjectMenu();
			AdminProject();
		}
		switch (n) {
		case 1:
			AdminControl.insertProject();
			break;

		case 2: {
			AdminControl.getProject();
			break;
		}

		case 3: {
			getAllproject();
			break;
		}
		case 4: {
			AdminControl.deleteProject();
			break;
		}
		case 5: {
			AdminControl.updateProject();
			break;
		}
		case 6: {
			adminControl();
			break;
		}
		case 7: {
			System.exit(0);
			break;
		}
		default: {
			System.out.println("******************************************************************************");
			System.out.println("Insert correct choice ....");
			AdminControl.AdminProject();
			break;
		}

		}

	}

	public static void AdminProjectManager() {
		Scanner s = new Scanner(System.in);
		int n = 0;
		try {
			n = s.nextInt();
		} catch (Exception e) {
			System.out.println("******************************************************************************");
			System.out.println("Enter correct format");
			AdminView.ProjectManagerMenu();
			AdminProjectManager();

		}
		switch (n) {
		case 1:
			AdminControl.insertProjectmanager();
			break;

		case 2: {
			AdminControl.getProjectmanager();
			break;
		}

		case 3: {
			getAllprojectmanager();
			break;
		}
		case 4: {
			AdminControl.deleteProjectmanager();
			break;
		}
		case 5: {
			AdminControl.updateProjectmanager();
			break;
		}
		case 6: {
			adminControl();
			break;
		}
		case 7: {
			System.exit(0);
			break;
		}
		default: {
			System.out.println("******************************************************************************");
			System.out.println("Insert correct choice ....");
			AdminControl.AdminProjectManager();
			break;
		}

		}
	}

	public static void getAllproject() {
		System.out.println("******************************************************************************");
		System.out.println(
				"--------------------------------------------------------------------------------------------");
		List<Project> listpm = AdminDao.getAllproject();
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
		AdminView.ProjectMenu();
		AdminControl.AdminProject();
	}

	public static void getAllprojectmanager() {
		System.out.println("******************************************************************************");
		System.out.println(
				"--------------------------------------------------------------------------------------------");
		List<Projectmanager> listpm = AdminDao.getAllprojectmanager();
		System.out.printf("%-5s %-15s %-15s %-15s %-15s %-15s", "Id", "Name", "Email", "Contact", "Address",
				"Username");
		System.out.println();
		System.out.println(
				"--------------------------------------------------------------------------------------------");
		for (Projectmanager pm : listpm) {
			System.out.printf("%-5d %-15s %-15s %-15s %-15s %-15s", pm.getId(), pm.getName(), pm.getEmail(),
					pm.getContact(), pm.getAddress(), pm.getUsername());
			System.out.println();
		}
		System.out
				.println("-------------------------------------------------------------------------------------------");
		AdminView.ProjectManagerMenu();
		AdminControl.AdminProjectManager();

	}

	public static void getAllemployee() {
		System.out.println("******************************************************************************");
		System.out.println(
				"--------------------------------------------------------------------------------------------");
		List<Employee> listemp = AdminDao.getAllemployee();
		System.out.printf("%-5s %-15s %-30s %-15s %-15s %-15s", "Id", "Name", "Email", "Contact", "Address",
				"Username");
		System.out.println();
		System.out.println(
				"--------------------------------------------------------------------------------------------");
		for (Employee emp : listemp) {
			System.out.printf("%-5d %-15s %-30s %-15s %-15s %-15s", emp.getId(), emp.getName(), emp.getEmail(),
					emp.getContact(), emp.getAddress(), emp.getUsername());
			System.out.println();
		}
		System.out.println(
				"--------------------------------------------------------------------------------------------");
		AdminView.EmployeeMenu();
		AdminControl.AdminEmplopyee();

	}

	public static void insertEmployee() {
		List<String> list = new ArrayList<String>();
		System.out.println("******************************************************************************");
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Employee name");
		list.add(s.next());
		System.out.println("Enter Employee Email");
		list.add(s.next());
		System.out.println("Enter Employee contact number");
		list.add(s.next());
		System.out.println("Enter Employee Address ");
		list.add(s.next());
		System.out.println("Enter Username for Employee");
		list.add(s.next());
		System.out.println("Enter password for Employee");
		list.add(s.next());
		boolean result = Adminservice.insertEmployeecheck(list);
		if (result) {
			System.out.println("******************************************************************************");
			System.out.println("Done Successfully...");
			System.out.println("******************************************************************************");
		} else {
			System.out.println("Something wrong.....");
		}
		AdminView.EmployeeMenu();
		AdminControl.AdminEmplopyee();
	}

	public static void updateEmployee() {
		List<String> list = new ArrayList<String>();
		int Id = 0;
		Scanner s = new Scanner(System.in);
		System.out.println("******************************************************************************");
		System.out.println("Enter Employee Id");
		try {
			Id = s.nextInt();
		} catch (Exception e) {
			System.out.println("******************************************************************************");
			System.out.println("Please Enter correct format......");
			updateEmployee();
		}

		System.out.println("Updated Employee name");
		list.add(s.next());
		System.out.println("Updated Employee Email");
		list.add(s.next());
		System.out.println("Updated Employee contact number");
		list.add(s.next());
		System.out.println("Updated Employee Address ");
		list.add(s.next());

		boolean result = Adminservice.updateEmployeecheck(Id, list);
		if (result) {
			System.out.println("******************************************************************************");
			System.out.println("Update Successfully...");
			System.out.println("******************************************************************************");
		} else {
			System.out.println("Something wrong .... ");
		}
		AdminView.EmployeeMenu();
		AdminControl.AdminEmplopyee();
	}

	public static void deleteEmployee() {
		Scanner s = new Scanner(System.in);
		System.out.println("******************************************************************************");
		System.out.println("Enter Employee Id");
		int Id = 0;
		try {
			Id = s.nextInt();
		} catch (Exception e) {
			System.out.println("******************************************************************************");
			System.out.println("Please Enter correct format......");
			deleteEmployee();
		}

		boolean result = Adminservice.deleteEmployeecheck(Id);
		if (result) {
			System.out.println("******************************************************************************");
			System.out.println("Deleted Successfully...");
			System.out.println("******************************************************************************");
		} else {
			System.out.println("Something wrong .... ");
		}
		AdminView.EmployeeMenu();
		AdminControl.AdminEmplopyee();

	}

	public static void getEmployee() {
		Scanner s = new Scanner(System.in);
		System.out.println("******************************************************************************");
		System.out.println("Enter Employee Id");
		int Id = s.nextInt();
		try {
			Id = s.nextInt();
		} catch (Exception e) {
			System.out.println("******************************************************************************");
			System.out.println("Please Enter correct format......");
			getEmployee();
		}

		List<Employee> listemp = Adminservice.getEmployeecheck(Id);
		if (listemp != null) {
			System.out.println("******************************************************************************");
			System.out.println(
					"--------------------------------------------------------------------------------------------");
			System.out.printf("%-5s %-15s %-30s %-15s %-15s %-15s", "Id", "Name", "Email", "Contact", "Address",
					"Username");
			System.out.println();
			System.out.println(
					"--------------------------------------------------------------------------------------------");
			for (Employee emp : listemp) {
				System.out.printf("%-5d %-15s %-30s %-15s %-15s %-15s", emp.getId(), emp.getName(), emp.getEmail(),
						emp.getContact(), emp.getAddress(), emp.getUsername());
				System.out.println();
			}
			System.out.println(
					"--------------------------------------------------------------------------------------------");
		} else {
			System.out.println("Employee not found");
		}
		AdminView.EmployeeMenu();
		AdminControl.AdminEmplopyee();
	}

	public static void insertProjectmanager() {
		List<String> list = new ArrayList<String>();
		System.out.println("******************************************************************************");
		Scanner s = new Scanner(System.in);
		System.out.println("Enter ProjectManager name");
		list.add(s.next());
		System.out.println("Enter ProjectManager Email");
		list.add(s.next());
		System.out.println("Enter ProjectManager contact number");
		list.add(s.next());
		System.out.println("Enter ProjectManager Address ");
		list.add(s.next());
		System.out.println("Enter Username for ProjectManager");
		list.add(s.next());
		System.out.println("Enter password for ProjectManager");
		list.add(s.next());

		boolean result = Adminservice.insertProjectmanagercheck(list);

		if (result) {
			System.out.println("******************************************************************************");
			System.out.println("Done Successfully...");
			System.out.println("******************************************************************************");
		} else {
			System.out.println("Something wrong");
		}
		AdminView.ProjectManagerMenu();
		AdminControl.AdminProjectManager();
	}

	public static void getProjectmanager() {
		Scanner s = new Scanner(System.in);
		System.out.println("******************************************************************************");
		System.out.println("Enter ProjectManager Id");
		int Id = 0;
		try {
			Id = s.nextInt();
		} catch (Exception e) {
			System.out.println("******************************************************************************");
			System.out.println("Please Enter correct format......");
			getProjectmanager();
		}

		List<Projectmanager> listemp = Adminservice.getProjectmanagercheck(Id);
		if (listemp != null) {
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
		} else {
			System.out.println("Project Manager not found");
		}
		AdminView.ProjectManagerMenu();
		AdminControl.AdminProjectManager();
	}

	public static void updateProjectmanager() {
		List<String> list = new ArrayList<String>();
		Scanner s = new Scanner(System.in);
		System.out.println("******************************************************************************");
		System.out.println("Enter ProjectManager Id");
		int Id = s.nextInt();
		try {
			Id = s.nextInt();
		} catch (Exception e) {
			System.out.println("******************************************************************************");
			System.out.println("Please Enter correct format......");
			updateProjectmanager();
		}

		System.out.println("Updated ProjectManager name");
		list.add(s.next());
		System.out.println("Updated ProjectManager Email");
		list.add(s.next());
		System.out.println("Updated ProjectManager contact number");
		list.add(s.next());
		System.out.println("Updated ProjectManager Address ");
		list.add(s.next());

		boolean result = Adminservice.updateProjectmanagercheck(Id, list);

		if (result) {
			System.out.println("******************************************************************************");
			System.out.println("Update Successfully...");
			System.out.println("******************************************************************************");
		} else {
			System.out.println("Something wrong....");
		}

		AdminView.ProjectManagerMenu();
		AdminControl.AdminProjectManager();
	}

	public static void deleteProjectmanager() {
		Scanner s = new Scanner(System.in);
		System.out.println("******************************************************************************");
		System.out.println("Enter ProjectManager Id");
		int Id = 0;
		try {
			Id = s.nextInt();
		} catch (Exception e) {
			System.out.println("******************************************************************************");
			System.out.println("Please Enter correct format......");
			deleteProjectmanager();
		}

		boolean result = Adminservice.deleteProjectmanagercheck(Id);
		if (result) {
			System.out.println("******************************************************************************");
			System.out.println("Deleted Successfully...");
			System.out.println("******************************************************************************");
		} else {
			System.out.println("Something wrong .... ");
		}
		AdminView.ProjectManagerMenu();
		AdminControl.AdminProjectManager();
	}

	public static void insertProject() {
		List<String> list = new ArrayList<String>();
		System.out.println("******************************************************************************");
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Project name");
		list.add(s.next());
		System.out.println("Enter Project Duration");
		list.add(s.next());
		System.out.println("Enter Project Status");
		list.add(s.next());

		int i = AdminDao.Addproject(list);

		if (i == 1) {
			System.out.println("******************************************************************************");
			System.out.println("Project Add Successfully...");
			System.out.println("******************************************************************************");
		} else {
			System.out.println("Something wrong");
		}
		AdminView.ProjectMenu();
		AdminControl.AdminProject();
	}

	public static void getProject() {
		Scanner s = new Scanner(System.in);
		System.out.println("******************************************************************************");
		System.out.println("Enter Project Id");
		int Id = 0;
		try {
			Id = s.nextInt();
		} catch (Exception e) {
			System.out.println("******************************************************************************");
			System.out.println("Please Enter correct format......");
			getProject();

		}

		ResultSet rs = AdminDao.getproject(Id);
		try {
			while (rs.next()) {
				System.out.println("Project name:- " + rs.getString(2));
				System.out.println("Project Duration:- " + rs.getString(3));
				System.out.println("Project Status:- " + rs.getString(4));
			}
		} catch (SQLException e) {
			System.out.println("Something wrong");
		}
		AdminView.ProjectMenu();
		AdminControl.AdminProject();
	}

	public static void updateProject() {
		List<String> list = new ArrayList<String>();
		System.out.println("******************************************************************************");
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Project Id");
		int n = 0;
		try {
			n = s.nextInt();
		} catch (Exception e) {
			System.out.println("******************************************************************************");
			System.out.println("Please Enter correct format......");
			updateProject();
		}

		System.out.println("Enter Project name");
		list.add(s.next());
		System.out.println("Enter Project Duration");
		list.add(s.next());
		System.out.println("Enter Project Status");
		list.add(s.next());

		AdminDao.updateproject(n, list);

		System.out.println("******************************************************************************");
		System.out.println("Project Update Successfully...");
		System.out.println("******************************************************************************");
		AdminView.ProjectMenu();
		AdminControl.AdminProject();
	}

	public static void deleteProject() {
		Scanner s = new Scanner(System.in);
		System.out.println("******************************************************************************");
		System.out.println("Enter Project Id");
		int Id = 0;
		try {
			Id = s.nextInt();
		} catch (Exception e) {
			System.out.println("******************************************************************************");
			System.out.println("Please Enter correct format......");
			deleteProject();
		}

		int i = AdminDao.deleteProjectmanager(Id);
		if (i == 1) {
			System.out.println("******************************************************************************");
			System.out.println("Deleted Successfully...");
			System.out.println("******************************************************************************");
		} else {
			System.out.println("Something wrong .... ");
		}
		AdminView.ProjectMenu();
		AdminControl.AdminProject();
	}

}
