package com.service;
import javax.ws.rs.*;

import javax.ws.rs.core.*;

import com.dto.*;
import com.bean.*;
import com.dao.*;
@Path("fb")
public class FeedbackService {
	
	@Path("/viewFeedback")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public FeedbackDTO viewFeedback() {
		System.out.println("Entered in service");
		FeedbackDTO fdt;
		FeedbackDao fdao=new FeedbackDao();
		fdt=fdao.getFeedback();
		System.out.println("Exit from service");
		return fdt;
	}

	@Path("/viewFeedbackByCourse")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public FeedbackDTO viewFeedbackByCourse(@FormParam("course") String course) {
		System.out.println("Entered in service");
		FeedbackDTO fdt;
		FeedbackDao fdao=new FeedbackDao();
		fdt=fdao.getFeedback(course);
		System.out.println("Exit from service");
		return fdt;
	}

	
		
	  @Path("/sendFeedback")
      @POST
      @Produces(MediaType.APPLICATION_JSON)
	public GeneralDTO sendFeedback(@FormParam("sid") String sid,
			@FormParam("name") String fbname,
			@FormParam("course") String course_name,
			@FormParam("rating") String rating
			) {
		  
		  	System.out.println(" send Feedback Service ");
		  	System.out.println("Enter sid="+ sid);
	 		System.out.println("Enter  name="+fbname);
	 		System.out.println("Enter course name="+ course_name);
	 		System.out.println("Enter  rating=" + rating);
	 		
		  	//int rate =Integer.parseInt(rating);
		  	FeedbackBean fb= new FeedbackBean( new Integer(sid), fbname, course_name, new Integer(rating));
	 		FeedbackDao fd=new FeedbackDao();
	 		GeneralDTO gdt=fd.insertfeedback(fb);
	 		System.out.println("Isert Status from send Feedback Service ="+ gdt);
	 		return gdt;
	}
	
}
