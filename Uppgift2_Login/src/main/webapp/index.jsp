<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%

// check if there is a session 

if (session.getAttribute("mySession") != null) {

	//not the same thing
	//response.sendRedirect("SessionServlet");

	RequestDispatcher rd = request.getRequestDispatcher("userPage.jsp");
	rd.forward(request, response);// this lands on the GET in the servlet
}

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>create session page</title>
</head>
<body>

	User 1: Daniel, admin
	<br>
	User 2: Peter, fisk
	<br>
	<br>
	<form action="<%=request.getContextPath()%>/LoginServlet" method="POST"
		name="loginForm">
		Username: <input type="text" name="uname" value=""> Password:
		<input type="password" name="password" value=""> <input
			type="submit" value="Login" />
	</form>
	
	<br>
	<br>
	<br>
	<!--  
	<form action="<%=request.getContextPath()%>/LoginServlet" method="POST"
		name="newUser">
		Create new user: <input type="text" name="newUserName" value=""> Password:
		<input type="password" name="newUserPassword" value=""> <input
			type="submit" value="" />
	</form>
	-->
</body>
</html>