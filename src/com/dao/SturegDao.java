package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.*;
import com.bean.FeedbackBean;
import com.bean.StuRegBean;
import com.dto.GeneralDTO;
import com.dto.LoginDTO;

public class SturegDao {
	
	
	public GeneralDTO insertstu(StuRegBean sd) {
		GeneralDTO  gdt ;
		 String name=sd.getName();
		 String email=sd.getEmail();
		 String password=sd.getPassword();
		 String mobie_no=sd.getMobie_no();

		//ResultSet rs= null;
	try {
		Connection cn=	DBconnection.getConnection();
		
	PreparedStatement ps =cn.prepareStatement("insert into stureg(name,email,password,mobileno) values(?,?,?,?)");
	ps.setString(1, name);
	ps.setString(2, email);
	ps.setString(3, password);
	ps.setString(4, mobie_no);
	ps.executeUpdate();
		
		
	 gdt= new GeneralDTO(true, "Inserted");	
		
	} catch (Exception e) {
		e.printStackTrace();
		gdt= new GeneralDTO(false, e.getMessage());
	}
	return gdt;


	}
	
	
	
	
	
	
	public LoginDTO login(String email,String password) {
		LoginDTO ldt;

		ResultSet rs= null;
	try {
		Connection cn=DBconnection.getConnection();
		
	PreparedStatement ps;
	try {
		System.out.println("email=" + email + "  and password=" + password);
		System.out.println("select * from Stureg where email=? and password=?" );
		ps = cn.prepareStatement("select * from Stureg where email=? and password=?");
		ps.setString(1,email);
		ps.setString(2,password);
		rs=ps.executeQuery();
		if(rs.next()==true) {
			
			
		  StuRegBean  sb = new StuRegBean(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			ldt = new LoginDTO(true, "", sb);
			 
			
		}else {
			ldt = new LoginDTO(false, "Invalid user name or password", null);
		}
		
		
		
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		ldt = new LoginDTO(false, e.getMessage(), null);
		
	}
		
		
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
		ldt = new LoginDTO(false, e.getMessage(), null);
	}
	return ldt;
		
	}
	
	
}
