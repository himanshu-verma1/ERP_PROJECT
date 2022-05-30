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
import com.erp.model.Projectmanager;
import com.erp.utility.Connectionutility;

public class AdminDao {
	public static int Addemployee(List<String> list) {
		int i = 0;
		String sql = "insert into Employee(name , email , contact , address , username , password) values ( ?, ? ,? ,? ,? ,?)";
		try (Connection con = Connectionutility.getConnect(); PreparedStatement pstm = con.prepareStatement(sql);) {
			try {
				pstm.setString(1, list.get(0));
				pstm.setString(2, list.get(1));
				pstm.setString(3, list.get(2));
				pstm.setString(4, list.get(3));
				pstm.setString(5, list.get(4));
				pstm.setString(6, list.get(5));
				i = pstm.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Something wrong");
			}
		} catch (Exception e) {

		}
		return i;
	}

	public static List<Employee> getEmployee(int Id) {
		ResultSet rs = null;
		String sql = "select * from  Employee where id = ?";
		List<Employee> listemp = new ArrayList<Employee>();
		try (Connection con = Connectionutility.getConnect(); PreparedStatement pstm = con.prepareStatement(sql);) {
			try {
				pstm.setInt(1, Id);
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

	public static List<Employee> getAllemployee() {
		ResultSet rs = null;
		String sql = "select * from  Employee ";
		List<Employee> listemp = new ArrayList<Employee>();

		try (Connection con = Connectionutility.getConnect(); Statement stm = con.createStatement();) {
			try {
				rs = stm.executeQuery(sql);
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
				System.out.println("Something wrong");
			}
		} catch (Exception e) {
			System.out.println("Connecting error");
		}
		return listemp;
	}

	public static int deleteEmployee(int Id) {
		int i = 0;
		String sql = "delete from Employee where id =?";
		try (Connection con = Connectionutility.getConnect(); PreparedStatement pstm = con.prepareStatement(sql);) {
			try {
				pstm.setInt(1, Id);
				i = pstm.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Something wrong");
			}
		} catch (Exception e1) {
			System.out.println("Something wrong.....");
		}
		return i;
	}

	public static int updateEmployee(int Id, List<String> list) {
		int i = 0;

		String sql = "update Employee set name = ?, email =? , contact =?  ,address =?   where id = ?";

		try (Connection con = Connectionutility.getConnect(); PreparedStatement pstm = con.prepareStatement(sql);) {
			try {

				pstm.setString(1, list.get(0));
				pstm.setString(2, list.get(1));
				pstm.setString(3, list.get(2));
				pstm.setString(4, list.get(3));
				pstm.setInt(5, Id);

				i = pstm.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Something wrong");
			}
		} catch (SQLException e1) {
			System.out.println("Something worng....");
		}
		return i;
	}

	// Project manager

	public static int Addprojectmanager(List<String> list) {
		int i = 0;
		String sql = "insert into projectmanager(name , email , contact , address , username , password) values ( ?, ? ,? ,? ,? ,?)";

		try (Connection con = Connectionutility.getConnect(); PreparedStatement pstm = con.prepareStatement(sql);) {
			try {
				pstm.setString(1, list.get(0));
				pstm.setString(2, list.get(1));
				pstm.setString(3, list.get(2));
				pstm.setString(4, list.get(3));
				pstm.setString(5, list.get(4));
				pstm.setString(6, list.get(5));
				i = pstm.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Something wrong");
			}
		} catch (Exception e1) {

		}
		return i;
	}

	public static List<Projectmanager> getAllprojectmanager() {
		ResultSet rs = null;
		String sql = "select * from  projectmanager ";
		List<Projectmanager> listemp = new ArrayList<Projectmanager>();

		try (Connection con = Connectionutility.getConnect(); Statement stm = con.createStatement();) {
			try {
				rs = stm.executeQuery(sql);
				while (rs.next()) {
					Projectmanager pm = new Projectmanager();
					pm.setId(rs.getInt(1));
					pm.setName(rs.getString(2));
					pm.setEmail(rs.getString(3));
					pm.setContact(rs.getString(4));
					pm.setAddress(rs.getString(5));
					pm.setUsername(rs.getString(6));

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

	public static List<Projectmanager> getProjectmanager(int Id) {
		ResultSet rs = null;
		String sql = "select * from  projectmanager where id =?";
		List<Projectmanager> listemp = new ArrayList<Projectmanager>();
		try (Connection con = Connectionutility.getConnect(); PreparedStatement pstm = con.prepareStatement(sql);) {
			try {
				pstm.setInt(1, Id);
				rs = pstm.executeQuery();
				while (rs.next()) {
					Projectmanager pm = new Projectmanager();
					pm.setId(rs.getInt(1));
					pm.setName(rs.getString(2));
					pm.setEmail(rs.getString(3));
					pm.setContact(rs.getString(4));
					pm.setAddress(rs.getString(5));
					pm.setUsername(rs.getString(6));

					listemp.add(pm);

				}
			} catch (SQLException e) {
				System.out.println("Something wrong");
			}
		} catch (Exception e) {
			System.out.println("Something wrong... ");
		}
		return listemp;
	}

	public static int deleteProjectmanager(int Id) {
		int i = 0;
		String sql = "delete from projectmanager where id = ?";
		try (Connection con = Connectionutility.getConnect(); PreparedStatement pstm = con.prepareStatement(sql);) {
			try {
				pstm.setInt(1, Id);
				i = pstm.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Something wrong");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	public static int updateProjectmanager(int Id, List<String> list) {
		int i = 0;
		String sql = "update projectmanager set name  = ?, email =? , contact =?  ,address =?   where id = ?";
		try (Connection con = Connectionutility.getConnect(); PreparedStatement pstm = con.prepareStatement(sql);) {
			try {
				pstm.setString(1, list.get(0));
				pstm.setString(2, list.get(1));
				pstm.setString(3, list.get(2));
				pstm.setString(4, list.get(3));
				pstm.setInt(5, Id);
				i = pstm.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Something wrong");
			}
		} catch (Exception e) {
			System.out.println("Something wrong....");
		}
		return i;
	}
	// project

	public static int Addproject(List<String> list) {
		int i = 0;
		String sql = "insert into project(name , duration , status) values (?,?,?)";
		try (Connection con = Connectionutility.getConnect(); PreparedStatement pstm = con.prepareStatement(sql);) {
			try {
				pstm.setString(1, list.get(0));
				pstm.setString(2, list.get(1));
				pstm.setString(2, list.get(2));
				i = pstm.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Something wrong");
			}
		} catch (Exception e) {
			System.out.println("Something wrong");
		}
		return i;
	}

	public static ResultSet getproject(int Id) {
		ResultSet rs = null;
		String sql = "select * from  project where id =?";
		try (Connection con = Connectionutility.getConnect(); PreparedStatement pstm = con.prepareStatement(sql);) {
			try {
				pstm.setInt(1, Id);
				rs = pstm.executeQuery();
			} catch (SQLException e) {
				System.out.println("Something wrong");
			}
		} catch (Exception e) {
			System.out.println("Something wrong...");
		}
		return rs;
	}

	public static int deleteproject(int Id) {
		int i = 0;
		String sql = "delete from project where id = ? ";
		try (Connection con = Connectionutility.getConnect(); PreparedStatement pstm = con.prepareStatement(sql);) {
			try {
				i = pstm.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Something wrong");
			}
		} catch (Exception e) {
			System.out.println("Something wrong...");
		}
		return i;
	}

	public static int updateproject(int Id, List<String> list) {
		int i = 0;
		String sql = "update project set name = ? , duration = ? , status =?   where id = ?";
		try (Connection con = Connectionutility.getConnect(); PreparedStatement pstm = con.prepareStatement(sql);) {
			try {
				pstm.setString(1, list.get(0));
				pstm.setString(2, list.get(1));
				pstm.setString(3, list.get(2));
				pstm.setInt(4, Id);
				i = pstm.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Something wrong");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	public static List<Project> getAllproject() {
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
