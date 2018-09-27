package com.service;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;

import com.bean.FeedbackBean;
import com.bean.StuRegBean;
import com.dao.FeedbackDao;
import com.dao.SturegDao;
import com.dto.GeneralDTO;
import com.dto.LoginDTO;
import com.sun.jersey.multipart.FormDataParam;

@Path("login")
public class StuRegService {

	    @Path("/loginCheck")
		@POST
		@Produces(MediaType.APPLICATION_JSON)
		public LoginDTO loginCheck(@FormParam("uname") String uname,
				@FormParam("pass") String pass)
		{
			System.out.println(" select  loginCheck Service ");
	  		System.out.println("Enter email=" + uname);
	 		System.out.println("Enter password="+pass);
	 		SturegDao sd1=new SturegDao();
	 		LoginDTO ldt=sd1.login(uname, pass);
	 		
	 		System.out.println("select  loginCheck Service Status from Service ="+ ldt);
	 		return ldt;
			}
		
		
		
		

		  @Path("/registerNow")
	      @POST
	      @Produces(MediaType.APPLICATION_JSON)
		public GeneralDTO registerNow(@FormParam("name") String name,
				@FormParam("email") String email,
				@FormParam("password") String password,
				@FormParam("mobie_no") String mobie_no
				) {
			  
			  		System.out.println(" Insert registerNow Service ");
			  		System.out.println("Enter name="+name);
			  		System.out.println("Enter email="+email);
			 		System.out.println("Enter password="+password);
			 		System.out.println("Enter mobile no.="+mobie_no);
			 		StuRegBean sb= new StuRegBean( name, email, password, mobie_no);
					SturegDao sd=new SturegDao();
					GeneralDTO gdt=	sd.insertstu(sb);
					System.out.println("Isert Status from Service ="+ gdt);
		 		return gdt;
		}
		
		
		}

