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
	<h1>Overview of bird spotting locations:</h1>
	
	<p>Please select your location to add a spotting:</p>
	
	<spring:url value="/birdspotting/" var="showLocationUrl"/>
	<table>
		<thead>
			<tr>
				<th>Location</th>
				<th>Birds spotted</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${spottingLocations}" var="location">
			<tr>
				<td><a href="${showLocationUrl}${location.name}">${location.name}</a></td>
				<td>				
					[<c:forEach items="${location.spottedBirds}" var="bird">
						${bird.toString()},
					</c:forEach>]					
				</td>
			</tr>					
			</c:forEach>
	
		</tbody>
	
		</table>
		
		<br/>
		<br/>
		
		<form action='logout' method='post'>
			<input type="submit" value="Log out" /> 
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
	
</body>
</html>