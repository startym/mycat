package com.cssl.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestSelect {
	
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://192.168.174.129:8066/user-dm";

	public static void main(String[] args) throws Exception {
		
		Class.forName(DRIVER);
		Connection conn = DriverManager.getConnection(URL,"root","123456");
		PreparedStatement ps = conn.prepareStatement("select * from users");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt("userId")+"\t"+rs.getString("username"));
		}
		
		rs.close();
		ps.close();
		conn.close();
	}

}
