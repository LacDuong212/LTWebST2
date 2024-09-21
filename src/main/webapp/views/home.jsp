<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>Welcome to User home page</h1>
		<div class="user-info">
			<%
			String username = (String) session.getAttribute("username");
			if (username == null) {
				username = "Guest";
			}
			%>
			<span>Hi, <strong><%=username%></strong></span> 
			<a href="/LTWebST2/views/login.jsp" class="logout-button">Logout</a>
		</div>
	</div>
</body>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 20px;
}

.container {
	max-width: 800px;
	margin: 0 auto;
	background: white;
	padding: 20px;
	border-radius: 8px;
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

.user-info {
	margin-top: 10px;
}

.user-info span {
	margin-right: 20px;
}

.logout-button {
	color: white;
	background-color: #d9534f;
	padding: 5px 10px;
	text-decoration: none;
	border-radius: 5px;
}

.logout-button:hover {
	background-color: #c9302c;
}
</style>
</html>