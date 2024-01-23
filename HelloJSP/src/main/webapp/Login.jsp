<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 
  </head>
  <body>
  <%
  String tenDN= request.getParameter("uname");
  String mk= request.getParameter("upass");
  if(tenDN.equals("ABC") && mk.equals("123"))
	  response.sendRedirect("admin/admincp.jsp");
  else 
	  response.sendRedirect("admin/login.html");
  %>
<body>
</html>