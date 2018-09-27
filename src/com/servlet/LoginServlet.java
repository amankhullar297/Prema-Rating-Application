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

import com.bean.StuRegBean;
import com.dao.FeedbackDao;
import com.dao.SturegDao;
import com.dto.FeedbackDTO;
import com.dto.GeneralDTO;
import com.dto.LoginDTO;
import com.util.Com;
import com.util.DBconnection;
import com.util.Utility;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    public LoginServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String dest;
		String uname=request.getParameter("email");	
 		String pass=request.getParameter("password");
 		System.out.println("Enter email=" + uname);
 		System.out.println("Enter password="+pass);
 		
 		if (uname.equalsIgnoreCase("admin@premasoftware")) {
 			dest="admin.jsp";
	 		FeedbackDTO fdt= new FeedbackDao().getFeedback();
 			request.setAttribute("fdt", fdt); 
 			
 		}else {
 			LoginDTO ldt;
 			if (Com.isService) {
 				List<NameValuePair> v=new LinkedList<NameValuePair>();
 				String servicePath="http://" + Com.address+ "/Feedback/prema/login/loginCheck";
 				System.out.println(servicePath);
 		 		v.add(new BasicNameValuePair("uname", uname));
 	 			v.add(new BasicNameValuePair("pass", pass));
 	 			String result=Utility.callPostService(servicePath, v);
 	 			ObjectMapper om=new ObjectMapper();
 	 			ldt=om.readValue(result,new TypeReference<LoginDTO>(){});
 	 		}else {
 	 			SturegDao sd1=new SturegDao();
 	 				      ldt =	sd1.login(uname, pass);
	 		
 			}
 			if(ldt.getStatus()==false) {
	 			dest="registerOrSignin.jsp";
	 			request.setAttribute("status", ldt); 
	 		}else {
	 			HttpSession  session = request.getSession();
	 			session.setAttribute("login", ldt);
	 			dest="rate.jsp";	 			
	 		}
 		}
		RequestDispatcher  rd = request.getRequestDispatcher(dest);
		rd.forward(request, response);
	}
	
	
}
