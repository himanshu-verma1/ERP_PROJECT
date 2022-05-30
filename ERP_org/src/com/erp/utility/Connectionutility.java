package com.erp.utility;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Connectionutility {
	public static Connection getConnect() {
		Connection con = null;
			try(FileInputStream file = new FileInputStream("src/com/erp/utility/config.properties");) {
				Properties prop = new Properties();
				prop.load(file);
				Class.forName(prop.getProperty("class1"));
				con = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"),
						prop.getProperty("password"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		return con;
	}
}
