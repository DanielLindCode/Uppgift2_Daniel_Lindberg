<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.userBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>userPage</title>
</head>
<body class="usperPageBody">

	<%
	if (session.getAttribute("mySession") == null) {

		RequestDispatcher rd = request.getRequestDispatcher("LoginServlet");
		rd.forward(request, response);

	} else {

		out.print("<h1>Welcome! You are in a session</h1>");

		String contentSession = (String) session.getAttribute("mySession");
		out.print(contentSession);

	}
	%>

	<form action="<%=request.getContextPath()%>/LoginServlet"
		method="get">
		Type your number:<input type="number" name="userNumber" /> <input
			type="submit" value="send" />
	</form>
	<br>
	<br>
	

	<p>press this button to log out:</p>
	<form action="<%=request.getContextPath()%>/logOutServlet"
		method="post">
		<input type="submit" value="logout" />
	</form>

</body>
</html>