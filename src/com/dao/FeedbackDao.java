package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.FeedbackBean;
import com.dto.FeedbackDTO;
import com.dto.GeneralDTO;
import com.util.DBconnection;

public class FeedbackDao {
	
	

public GeneralDTO insertfeedback(FeedbackBean fb) {
System.out.print("FeedBack");
	GeneralDTO  gdt ;
	 String name=fb.getName();
	 System.out.println(name);
	 String course_name=fb.getCourse_name();
	 int rating=fb.getRating();
	 int sid=fb.getSid();
	try {
		Connection cn=	DBconnection.getConnection();
		PreparedStatement ps =cn.prepareStatement(		
				"insert into feedback(sid,name,course_name,rating) values(?,?,?,?)");
		ps.setInt(1, sid);
		ps.setString(2, name);
		ps.setString(3, course_name);
		ps.setInt(4, rating);
		ps.executeUpdate();
		gdt= new GeneralDTO(true, "Feedback Recived");	
	}catch (Exception e) {
		e.printStackTrace();
		gdt= new GeneralDTO(false, e.getMessage());
	}
return gdt;
}


public FeedbackDTO getFeedback(String course_name)
{			List<FeedbackBean> allItem=null;
   FeedbackDTO   fbdt;

	try {
		Connection cn = DBconnection.getConnection();
		
			PreparedStatement ps = cn.prepareStatement("select * from feedback where course_name=?");
			ps.setString(1, course_name);
		ResultSet rs = ps.executeQuery();
		 allItem = new ArrayList<FeedbackBean>();
		
		while(rs.next()) {
			FeedbackBean ib = new FeedbackBean(rs.getInt(1),rs.getInt(2), rs.getString(3),rs.getString(4),rs.getInt(5));

		allItem.add(ib);
		
	
		}
		
		fbdt = new FeedbackDTO(true, "", allItem);
		
	} catch (Exception e) {
			
			e.printStackTrace();
			fbdt = new FeedbackDTO(true, e.getMessage(),null);
		}
	
	return fbdt;
}

public FeedbackDTO getFeedback()
{			List<FeedbackBean> allItem=null;
   FeedbackDTO   fbdt;
   
	try {
		Connection cn = DBconnection.getConnection();
		
			PreparedStatement ps = cn.prepareStatement("select * from feedback");
			
		ResultSet rs = ps.executeQuery();
		 allItem = new ArrayList<FeedbackBean>();
		System.out.println(" In   getFeedback  ");
		while(rs.next()) {
			 int fbid=rs.getInt("fbid");
			 String name=rs.getString("name");
			 String course_name=rs.getString("course_name");
			 int rating=rs.getInt("rating");
			 int sid=rs.getInt("sid");
			 System.out.println(" In   getFeedback   Loop  ");
				
			 FeedbackBean fb = new FeedbackBean( fbid,sid, name,   course_name, rating);
			 allItem.add(fb);	
		}
		
		fbdt = new FeedbackDTO(true, "", allItem);
		System.out.println(" In   getFeedback return   " + allItem.size());
		
	} catch (Exception e) {
			
			e.printStackTrace();
			fbdt = new FeedbackDTO(true, e.getMessage(),null);
			System.out.println(" In   getFeedback return  Error "  );
		}

	

	return fbdt;
}
}