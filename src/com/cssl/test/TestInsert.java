package com.cssl.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestInsert {
	
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://192.168.174.129:8066/user-dm?useUnicode=true&characterEncoding=utf8";

	public static void main(String[] args) throws Exception {
		
		Class.forName(DRIVER);
		Connection conn = DriverManager.getConnection(URL,"root","123456");
		conn.setAutoCommit(false);
		//不支持自增，必须写列名
		PreparedStatement ps = conn.prepareStatement("insert into users(userId,username) values(?,?)");
		ps.setInt(1, 1505);
		ps.setString(2, "飞哥");
		int c = ps.executeUpdate();
		System.out.println("c:"+c);
		conn.commit();
		ps.close();
		conn.close();
	}

}
