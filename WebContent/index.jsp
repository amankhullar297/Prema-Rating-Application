<%@page import="com.dto.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="LoginServlet">
	Enter Name	<input type="text" name="uname"> 
	Enter password<input type="text" name="pass">
	<input type="submit">
</form>
<a href="RegisterNow.jsp">RegisterNow</a>
<% Object obj = request.getAttribute("status");
if( obj!=null){
	
	GeneralDTO  gdt =(GeneralDTO) obj;
   if (gdt.getStatus()==true){
	   %>
	    <h1><%=gdt.getMessage() %></h1>
	<%}else{%>
   	error	<h1><%=gdt.getMessage() %></h1>
   	<%} %>
<%} %>
</body>
</html>