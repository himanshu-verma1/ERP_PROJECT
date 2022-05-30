package com.erp.servicelayer;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.erp.dao.EmployeeDao;
import com.erp.model.Employee;
import com.erp.model.Project;

public class Employeeservice {

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

	public static boolean checkId(String id) {
		String regId = "^[0-9]+$";
		Pattern patternId = Pattern.compile(regId);
		Matcher matchId = patternId.matcher(id);
		if (matchId.matches()) {
			return true;
		}
		return false;
	}

	public static List<Employee> checkProfile(String userName) {
		List<Employee> listemp = EmployeeDao.viewProfile(userName);
		return listemp;
	}

	public static boolean checkEdit(String userName, List<String> list) {
		
		if (checkName(list.get(0)) && checkEmail(list.get(1)) && checkContact(list.get(2)))
		{
			int n = EmployeeDao.editProfile(userName, list);
			if (n == 1) {
				return true;
			}
		}
		return false;
	}

	public static int checkeditProject(int Id, String status) {
		String testId = ""+Id;
		if (checkName(status)&&checkId(testId)) {
			int i = EmployeeDao.editProject(Id, status);
			return i;
		}
		return 0;
	}

	public static List<Project> checkviewProject() {
		List<Project> listpro = EmployeeDao.viewProject();
		return listpro;
	}

}
