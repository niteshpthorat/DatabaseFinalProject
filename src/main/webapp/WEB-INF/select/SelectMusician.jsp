<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
   	<title>Musician</title>
</head>
<body>
<div class="container">
          <h1>Musicians</h1>
	<form action="select/SelectMusician" method="post">
		<table class="table">
				<tr>
					<th scope="col">Musician ID</th>
					<th scope="col">Musician SSN</th>
					<th scope="col">Name</th>
					<th scope="col">Phone Number</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${musicians}" var="musician">
					<tr>
						<th scope="row">${musician.musicianId}</th>
						<td>${musician.ssn}</td>
						<td>${musician.name}</td>
						<td>${musician.phoneNo}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
</div>
</body>
</html>
