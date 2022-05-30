package com.erp.servicelayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.erp.utility.Connectionutility;

public class Loginservice {
	public static boolean checkEmp(String username, String password, String role) {
		String sql = "select username , password from " + role;
		ResultSet rs = null;
		try (Connection con = Connectionutility.getConnect(); Statement stm = con.createStatement();) {

			rs = stm.executeQuery(sql);

			while (rs.next()) {
				String s = rs.getString(1);
				String s1 = rs.getString(2);
				if (s.equals(username) && s1.equals(password)) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("checking");
		}
		return false;
	}

	public static boolean adminCheck(String username, String password) {
		if (username.equals("Admin") && password.equals("Admin")) {
			return true;
		}
		return false;
	}
}
