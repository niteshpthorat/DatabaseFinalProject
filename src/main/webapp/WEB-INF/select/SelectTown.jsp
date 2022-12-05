<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>Place</title>
</head>
<body>
<div class="container">
          <h1>Addresses</h1>
	<form action="select/SelectPlace" method="post">
		<table class="table">
			<thead>
				<tr>
					<th>Place ID</th>
					<th>Address</th>
					<th>Phone Number</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${addresses}" var="town">
				<tr><td>${town.id}</td>
				<td>${town.address}</td>
				<td>${town.phoneNumber}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</form>
</div>
	<a href="Home">back to home</a>
</body>
</html>
