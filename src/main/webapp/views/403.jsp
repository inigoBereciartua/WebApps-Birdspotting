<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Bird Spotting Locations</title>
	<link href="/resources/css/style.css" rel="stylesheet"/>
</head>
<body>
	<h1>HTTP Status 403 - Access is denied</h1>
	
	<form action='login' method='post'>
		<input type="submit" value="Log out" /> 
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
</body>
</html>