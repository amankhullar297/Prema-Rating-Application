package com.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.bean.FeedbackBean;
import com.bean.StuRegBean;
import com.dao.FeedbackDao;
import com.dto.GeneralDTO;
import com.dto.LoginDTO;
import com.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.http.*;
import org.apache.http.message.BasicNameValuePair;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import java.util.*;

@WebServlet("/SendFeedback")
public class SendFeedback extends HttpServlet {

    public SendFeedback() {
        super();
       }
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		doPost(request, response);
   	}
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		PrintWriter out=response.getWriter();
   		HttpSession session=request.getSession();
 		LoginDTO ldt=(LoginDTO)session.getAttribute("login");
 		StuRegBean stu=ldt.getLogin();
   		//PrintWriter out=response.getWriter();
   		String sid=stu.getSid();
 		String fbname=stu.getName();
 		String course_name=request.getParameter("course");	
 		String rating=request.getParameter("rate");
 		System.out.println(sid+fbname+course_name+rating);
 		
		System.out.print(" ==============> \n Entered into  sendFeedback Servlet recived data is " );
		System.out.println("Enter sid="+ sid);
 		System.out.println("Enter  name="+fbname);
 		System.out.println("Enter course name="+ course_name);
 		System.out.println("Enter  rating=" + rating);
 		GeneralDTO gdt;
 		if (Com.isService) {
 			String servicePath="http://" + Com.address+ "/Feedback/prema/fb/sendFeedback";
 			System.out.println(servicePath);
 	 		List<NameValuePair> v=new LinkedList<NameValuePair>();
 			v.add(new BasicNameValuePair("sid", sid));
 			v.add(new BasicNameValuePair("name", fbname));
 			v.add(new BasicNameValuePair("course", course_name));
 			v.add(new BasicNameValuePair("rating", rating));
 			String result=Utility.callPostService(servicePath, v);
 			
 			ObjectMapper om=new ObjectMapper();
 			gdt=om.readValue(result,new TypeReference<GeneralDTO>(){});
 			
 		}else {
 			int  rate = Integer.parseInt(rating);
 			FeedbackBean fb= new FeedbackBean( Integer.parseInt(sid), fbname, course_name, rate);
 	 		FeedbackDao fd=new FeedbackDao();
 	 		gdt=fd.insertfeedback(fb);
 		}
 		System.out.print(" going for sendFeedback Servlet recived data is " + gdt + "\n <==============> \n");
 		RequestDispatcher  rd = request.getRequestDispatcher("rate.jsp");
   		request.setAttribute("status", gdt);
   		request.setAttribute("course",course_name );
   		rd.forward(request, response);
   	}

}
