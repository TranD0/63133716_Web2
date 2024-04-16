<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>

</head>
<body>
<%
    String email = request.getParameter("email");
    String pass = request.getParameter("password");
    if (email.equals("ABC") && pass.equals("MNK"))
    	response.sendRedirect("myCV.html");
    else 
    	response.sendRedirect("Login.html");%>
</body>
</html>