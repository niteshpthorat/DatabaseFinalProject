<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Instrument Player</title>
</head>
<body>
	<div class="container">
		<h1>Instrument Players</h1>
		<form action="select/SelectInstrumentPlayer" method="post">
			<table class="table">
				<tr>
					<th>ID</th>
					<th>Instrument ID</th>
					<th>Player's SSN</th>
				</tr>
				<tbody>
					<c:forEach items="${instrplayer}" var="insPlayer">
						<tr>
							<td>${insPlayer.id}</td>
							<td>${insPlayer.idInstrument}</td>
							<td>${insPlayer.musSSN}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
	</div>
	<a href="Home">back to home</a>
</body>
</html>
