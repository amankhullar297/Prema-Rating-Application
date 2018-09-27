package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
		
		  public static Connection getConnection() throws ClassNotFoundException {
			String driverName= "com.mysql.jdbc.Driver";
			 String uid="root";
			 String pwd="root";
			String uri="jdbc:mysql://localhost:3306/cloud";	
			 Connection cn=null;
			try {
			 Class.forName(driverName);
			 cn = DriverManager.getConnection(uri, uid, pwd);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		    return cn;
		  }
public static void main(String args[])throws Exception {
	getConnection();
	System.out.println("Connected");
}
}
