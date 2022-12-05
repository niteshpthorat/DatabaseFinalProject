<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
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
					<c:forEach items="${instr}" var="ins">
						<tr>
							<td>${ins.idInstrument}</td>
							<td>${ins.name}</td>
							<td>${ins.keys}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
	</div>
	<a href="Home">back to home</a>
</body>
</html>
