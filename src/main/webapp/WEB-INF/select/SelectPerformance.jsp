<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">  
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
	
<title>Performance</title>
</head>
<body>
<div class="container">
          <h1>Performances</h1>
	<form action="select/SelectPerformance" method="post">
		<table class="table" class="table-success">
				<tr class="table-success">
					<th scope="col">ID Performance</th>
					<th scope="col">Song ID</th>
					<th scope="col">Musician SSN</th>
				</tr>
			<tbody>
				<c:forEach items="${performances}" var="performance">
					<tr class="table-success">
						<th scope="row" class="table-success">${performance.idPerformance}</th>
						<td class="table-success">${performance.idSong}</td>
						<td class="table-success">${performance.musSSN}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
</div>
<a href="Home">back to home</a>
</body>
</html>
