<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="/resources/css/style.css" rel="stylesheet"/>
<title>Insert title here</title>
</head>
<body>

<spring:url value="/birdspotting/" var="showLocationUrl"/>
	<h1>Create new bird specie:</h1>
	<form:form method="Post" action="${showLocationUrl}${spotLocation}/newbirdspotting" modelAttribute="birdSpecie">
		<h3>Specie:</h3>
		<form:input path="name" size="15" value="Specie"/>
		<form:errors path="name" cssClass="error"/>
		
		<h3>Year of discovery:</h3>
		<form:input path="yearOfDiscovery" pattern="[0-9]{1,}" size="15" value="2020"/>
		<form:errors path="yearOfDiscovery" cssClass="error"/>
		
		<h3>Book of birds code: </h3>
		<form:input path="code" size="15" value="AA000"/>
		<form:errors path="code" cssClass="error"/>
		<br>
		<br>
		<input type="submit" value="Spot new bird"/>
		
	</form:form>
	
</body>
</html>