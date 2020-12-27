<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spotted birds overview</title>
<link href="/resources/css/style.css" rel="stylesheet"/>
</head>
<body>	
	<spring:url value="/birdspotting/" var="showLocationUrl"/>
	
	<h1>Overview of spotted birds in ${spotLocation.name}:</h1>
	<a href="${showLocationUrl}${spotLocation.name}/newbirdspotting">New Spotting</a> - <a href="${showLocationUrl}">Spotting locations overview</a>
	<table>
		<thead>
			<tr>
				<th>Index</th>
				<th>Specie</th>
				<th>Year of discovery</th>
				<th>Code index in the book of birds</th>
				<th>Spottings</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${spotLocation.spottedBirds}" var="bird" varStatus = "loop">
				<tr>
					<td>${loop.count}</td>
					<td>${bird.birdSpecie.name}</td>
					<td>${bird.birdSpecie.yearOfDiscovery}</td>
					<td>${bird.birdSpecie.code}</td>
					<td>${bird.count}</td>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>