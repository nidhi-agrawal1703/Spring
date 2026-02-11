<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<%@include file="Header.jsp" %>
	<sf:form method="post" modelAttribute="form">
		<div align="center">
			<h3>Login</h3>
			<label><b>Login</b></label><sf:input path="login" placeholder="Enter Login Id"/><br><br>
			<label><b>Password</b></label><sf:input path="password" placeholder="Enter Password"/><br><br>
			<input type="submit" name="operation" value="signin">
		</div>
	</sf:form>
	<%@include file="Footer.jsp" %>
</body>
</html>