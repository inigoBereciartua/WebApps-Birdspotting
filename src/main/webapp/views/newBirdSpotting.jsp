<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<spring:url value="/birdspotting/" var="showLocationUrl"/>
	<h1>Create new bird specie:</h1>
	<form:form method="Post" action="${showLocationUrl}${spotLocation}/newbirdspotting" modelAttribute="birdSpecie">
		<h3>Specie: </h3>
		<form:input path="name" size="15"/>
		<form:errors path="name" cssClass="text-danger"/>
		
		<h3>Year of discovery:</h3>
		<form:input path="yearOfDiscovery" size="15"/>
		<form:errors path="yearOfDiscovery" cssClass="text-danger"/>
		
		<h3>Book of birds code: </h3>
		<form:input path="code" size="15"/>
		<form:errors path="code" cssClass="text-danger"/>
		
		<input type="submit" value="Spot new bird"/>
		
	</form:form>
	
</body>
</html>