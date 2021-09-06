package com.selenium.starter;

import java.sql.*;

public class JDBC {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		String url = "";
		String uname = "";
		String password = "";
		String query = "";
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, uname, password);
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery(query);
		rs.next();
		String name = rs.getString("");
		System.out.println(name);
		
		stm.close();
		con.close();
	}

}
