<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="com.dto.*,com.bean.*"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<%  FeedbackDTO  fdt= (FeedbackDTO) request.getAttribute("fdt");
  for (FeedbackBean  fb : fdt.getFeedbacks()){
	  %>
	  <tr>
	  	<td><%=fb.getName() %></td>
	  	<td><%=fb.getCourse_name() %></td>
	  	<td><%=fb.getRating() %></td>	  	
	  </tr>
	  
	  <%}%>
 
</table>
</body>
</html>