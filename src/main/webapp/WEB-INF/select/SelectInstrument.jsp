<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<title>Instruments</title>
</head>
<body>
<div class="container">
          <h1>Instruments</h1>
	<form action="select/SelectInstrument" method="post">
		<table class="table">
				<tr>
					<th>ID</th>	
					<th>Name</th>
					<th>Music Keys</th>
				</tr>
			<tbody>
				<c:forEach items="${instr}" var="it">
					<tr><td>${it.idInstrument}</td>
					<td>${it.name}</td>
					<td>${it.keys}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
</div>
	<a href="WEB-INF/index.jsp">back to home</a>
</body>
</html>
