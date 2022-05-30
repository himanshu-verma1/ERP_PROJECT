package com.erp.servicelayer;

import java.util.regex.*;

import com.erp.dao.AdminDao;
import com.erp.model.Employee;
import com.erp.model.Projectmanager;

import java.util.List;

public class Adminservice {

	public static boolean checkEmail(String email) {
		String regEmail = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
		Pattern patternEmail = Pattern.compile(regEmail);
		Matcher matchEmail = patternEmail.matcher(email);
		if (matchEmail.matches()) {
			return true;
		}
		return false;
	}

	public static boolean checkName(String name) {
		String regName = "^[A-Za-z]+$";
		Pattern patternName = Pattern.compile(regName);
		Matcher matchName = patternName.matcher(name);
		if (matchName.matches()) {
			return true;
		}
		return false;
	}

	public static boolean checkContact(String contact) {
		String regContact = "^[0-9]{10}$";
		Pattern patternContact = Pattern.compile(regContact);
		Matcher matchContact = patternContact.matcher(contact);
		if (matchContact.matches()) {
			return true;
		}
		return false;
	}

	public static boolean checkUsername(String username) {
		String regUsername = "^(?=.{8,20}$)[A-Za-z0-9]+$";
		Pattern patternUsername = Pattern.compile(regUsername);
		Matcher matchUsername = patternUsername.matcher(username);
		if (matchUsername.matches()) {
			return true;
		}
		return false;
	}

	public static boolean checkId(String id) {
		String regId = "^[0-9]+$";
		Pattern patternId = Pattern.compile(regId);
		Matcher matchId = patternId.matcher(id);
		if (matchId.matches()) {
			return true;
		}
		return false;
	}

	public static boolean insertEmployeecheck(List<String> list) {
		if (checkName(list.get(0)) && checkEmail(list.get(1)) && checkContact(list.get(2))
				&& checkUsername(list.get(4))) {
			int i = AdminDao.Addemployee(list);
			if (i == 1) {
				return true;
			}
		}
		return false;
	}

	public static boolean updateEmployeecheck(int Id, List<String> list) {
		String testId = "" + Id;
		if (checkName(list.get(0)) && checkEmail(list.get(1)) && checkContact(list.get(2)) && checkId(testId)) {
			int i = AdminDao.updateEmployee(Id, list);
			if (i == 1) {
				return true;
			}
		}
		return false;
	}

	public static boolean deleteEmployeecheck(int Id) {
		String testId = "" + Id;
		if (checkId(testId)) {
			int i = AdminDao.deleteEmployee(Id);
			if (i == 1) {
				return true;
			}
		}
		return false;
	}

	public static List<Employee> getEmployeecheck(int Id) {
		String testId = "" + Id;
		if (checkId(testId)) {
			List<Employee> listemp = AdminDao.getEmployee(Id);
			return listemp;
		}
		return null;
	}

	// Project Manager

	public static boolean insertProjectmanagercheck(List<String> list) {
		if (checkName(list.get(0)) && checkEmail(list.get(1)) && checkContact(list.get(2))
				&& checkUsername(list.get(4))) {
			int i = AdminDao.Addprojectmanager(list);
			if (i == 1) {
				return true;
			}
		}
		return false;
	}

	public static boolean updateProjectmanagercheck(int Id, List<String> list) {
		String testId = "" + Id;
		if (checkName(list.get(0)) && checkEmail(list.get(1)) && checkContact(list.get(2)) && checkId(testId)) {
			int i = AdminDao.updateProjectmanager(Id, list);
			if (i == 1) {
				return true;
			}
		}
		return false;
	}

	public static boolean deleteProjectmanagercheck(int Id) {
		String testId = "" + Id;
		if (checkId(testId)) {
			int i = AdminDao.deleteProjectmanager(Id);
			if (i == 1) {
				return true;
			}
		}
		return false;
	}

	public static List<Projectmanager> getProjectmanagercheck(int Id) {
		String testId = "" + Id;
		if (checkId(testId)) {
			List<Projectmanager> listemp = AdminDao.getProjectmanager(Id);
			return listemp;
		}
		return null;
	}

}
