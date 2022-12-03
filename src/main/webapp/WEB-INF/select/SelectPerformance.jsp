<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Performance</title>
</head>
<body>
<div class="container">
          <h1>Performances</h1>
	<form action="select/SelectPerformance" method="post">
		<table class="table">
				<tr>
					<th scope="col">ID Performance</th>
					<th scope="col">Song ID</th>
					<th scope="col">Musician SSN</th>
				</tr>
			<tbody>
				<c:forEach items="${performances}" var="performance">
					<tr>
						<th scope="row">${performance.idPerformance}</th>
						<td>${performance.idSong}</td>
						<td>${performance.musSSN}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
</div>
</body>
</html>
