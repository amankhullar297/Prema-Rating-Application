<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="com.dto.*,com.bean.*"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%LoginDTO ldt= (LoginDTO) session.getAttribute("login"); %>
<form action="SendFeedback">
    <input type="hidden" name="sid" value="<%=ldt.getLogin().getSid() %>">
	<input type="hidden" name="fbname" value="<%=ldt.getLogin().getName()%>"> 
	Enter course_name<input type="text" name="course_name">
	Enter rating	<input type="text" name="rating"> 
	<input type="submit">
</form>
</body>
</html>
