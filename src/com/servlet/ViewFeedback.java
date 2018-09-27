package com.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.dao.FeedbackDao;
import com.dto.FeedbackDTO;
import com.dto.GeneralDTO;
import com.util.Com;
import com.util.DBconnection;
import com.util.Utility;

@WebServlet("/ViewFeedback")
public class ViewFeedback extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ViewFeedback() {
        super();
       }
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		doPost(request, response);
   	}
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		PrintWriter out=response.getWriter();
   		RequestDispatcher  rd = request.getRequestDispatcher("viewRating.jsp");
   		FeedbackDao fd1=new FeedbackDao();
		FeedbackDTO fdt ;
		System.out.print(" ==============> \n Entered into  ViewFeedback Servlet  " );
		
		if (Com.isService) {
 			String servicePath="http://" + Com.address+ "/Feedback/prema/fb/viewFeedback";
 			System.out.println(servicePath);
 	 		String result=Utility.callGetService(servicePath);
 			
 			ObjectMapper om=new ObjectMapper();
 			System.out.println(result);
 			fdt=om.readValue(result,new TypeReference<FeedbackDTO>(){});
 			System.out.println("Exit from DAO");
		}else{
 				fdt=fd1.getFeedback();
 		}
		
   		request.setAttribute("fdt", fdt);
   		rd.forward(request, response);
   	}
}
