package com.servlet;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.bean.FeedbackBean;
import com.bean.StuRegBean;
import com.dao.FeedbackDao;
import com.dao.SturegDao;
import com.dto.GeneralDTO;
import com.util.Com;
import com.util.DBconnection;
import com.util.Utility;

@WebServlet("/RegisterNowServlet")
public class RegisterNowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegisterNowServlet() {
          super();
       }
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		doPost(request, response);
   	}
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		String name=request.getParameter("name");
 		String email=request.getParameter("email");	
 		String password=request.getParameter("password");
 		String mobie_no=request.getParameter("contact");
		System.out.print(" ==============> \n Entered into  registerNow Servlet recived data is " );
		 	System.out.println("Enter name="+name);
	 		System.out.println("Enter email="+email);
	 		System.out.println("Enter password="+password);
	 		System.out.println("Enter mobile no.="+mobie_no);
 		GeneralDTO gdt;
 		if (Com.isService) {
 			String servicePath="http://" + Com.address+ "/Feedback/prema/login/registerNow";
 			System.out.println(servicePath);
 			List<NameValuePair> v=new LinkedList<NameValuePair>();
 			v.add(new BasicNameValuePair("name", name));
 			v.add(new BasicNameValuePair("email", email));
 			v.add(new BasicNameValuePair("password", password));
 			v.add(new BasicNameValuePair("mobie_no", mobie_no));
 			String result=Utility.callPostService(servicePath, v);
 			System.out.println("Result is " + result);
 			ObjectMapper om=new ObjectMapper();
 			gdt=om.readValue(result,new TypeReference<GeneralDTO>(){});
 			
 		}else {
 			StuRegBean sb= new StuRegBean( name, email, password, mobie_no);
 			SturegDao sd=new SturegDao();
 			 gdt=	sd.insertstu(sb);
 		}
 		
 		System.out.print(" going for registerNow Servlet recived data is " + gdt + "\n <==============> \n");
 		PrintWriter out=response.getWriter();
   		RequestDispatcher  rd = request.getRequestDispatcher("registerNew.jsp");
   		request.setAttribute("status", gdt);
   		rd.forward(request, response);
   	}

}
