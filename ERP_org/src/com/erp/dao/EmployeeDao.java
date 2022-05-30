package com.erp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.erp.model.Employee;
import com.erp.model.Project;
import com.erp.utility.Connectionutility;

public class EmployeeDao {

	public static List<Employee> viewProfile(String userName) {
		ResultSet rs = null;
		String sql = "select * from  Employee where username = ?";
		List<Employee> listemp = new ArrayList<Employee>();
		try (Connection con = Connectionutility.getConnect(); PreparedStatement pstm = con.prepareStatement(sql);) {
			try {
				pstm.setString(1, userName);
				rs = pstm.executeQuery();
				while (rs.next()) {
					Employee emp = new Employee();
					emp.setId(rs.getInt(1));
					emp.setName(rs.getString(2));
					emp.setEmail(rs.getString(3));
					emp.setContact(rs.getString(4));
					emp.setAddress(rs.getString(5));
					emp.setUsername(rs.getString(6));

					listemp.add(emp);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Something wrong");
			}
		} catch (Exception e) {

		}
		return listemp;
	}

	public static int editProfile(String userName, List<String> list) {
		int i = 0;

		String sql = "update Employee set name = ?, email =? , contact =?  ,address =?   where username = ?";

		try (Connection con = Connectionutility.getConnect(); PreparedStatement pstm = con.prepareStatement(sql);) {
			try {

				pstm.setString(1, list.get(0));
				pstm.setString(2, list.get(1));
				pstm.setString(3, list.get(2));
				pstm.setString(4, list.get(3));
				pstm.setString(5, userName);

				i = pstm.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Something wrong");
			}
		} catch (SQLException e1) {
			System.out.println("Something worng....");
		}
		return i;

	}

	public static int editProject(int id, String status) {

		int i = 0;
		String sql = "update project set status =?   where id = ?";
		try (Connection con = Connectionutility.getConnect(); PreparedStatement pstm = con.prepareStatement(sql);) {
			try {
				pstm.setString(1, status);
				pstm.setInt(2, id);
				i = pstm.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Something wrong");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;

	}

	public static List<Project> viewProject() {
		ResultSet rs = null;
		String sql = "select * from  project ";
		List<Project> listemp = new ArrayList<Project>();

		try (Connection con = Connectionutility.getConnect(); Statement stm = con.createStatement();) {
			try {
				rs = stm.executeQuery(sql);
				while (rs.next()) {
					Project pm = new Project();
					pm.setId(rs.getInt(1));
					pm.setName(rs.getString(2));
					pm.setDuration(rs.getString(3));
					pm.setStatus(rs.getString(4));
					listemp.add(pm);

				}
			} catch (SQLException e) {
				System.out.println("Something wrong");
			}
		} catch (Exception e) {
			System.out.println("Connecting error");
		}
		return listemp;
	}

}
