package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.dao.FeedbackDao;
import com.dto.FeedbackDTO;
import com.util.Com;
import com.util.Utility;

/**
 * Servlet implementation class ViewFeedbackByCourse
 */
@WebServlet("/ViewFeedbackByCourse")
public class ViewFeedbackByCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
       public ViewFeedbackByCourse() {
        super();
        // TODO Auto-generated constructor stub
    }

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			PrintWriter out=response.getWriter();
	   		RequestDispatcher  rd = request.getRequestDispatcher("viewRatingByCourse.jsp");
	   		FeedbackDao fd1=new FeedbackDao();
			FeedbackDTO fdt ;
			System.out.print(" ==============> \n Entered into  ViewFeedback Servlet  " );
			String course=null;
			if (Com.isService) {
				course=request.getParameter("course");
				System.out.println(course);
	 			List<NameValuePair> v=new LinkedList<NameValuePair>();
 				String servicePath="http://" + Com.address+ "/Feedback/prema/fb/viewFeedbackByCourse";
 				System.out.println(servicePath);
 		 		v.add(new BasicNameValuePair("course", course));
 	 			String result=Utility.callPostService(servicePath, v);
	 			
	 			ObjectMapper om=new ObjectMapper();
	 			System.out.println(result);
	 			fdt=om.readValue(result,new TypeReference<FeedbackDTO>(){});
	 			System.out.println("Exit from DAO");
			}else{
	 				fdt=fd1.getFeedback();
	 		}
			
	   		request.setAttribute("fdt", fdt);
	   		request.setAttribute("course",course);
	   		rd.forward(request, response);
	   	}
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

}
