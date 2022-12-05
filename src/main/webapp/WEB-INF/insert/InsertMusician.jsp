<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
	integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
	crossorigin="anonymous">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
	integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ"
	crossorigin="anonymous"></script>

<title>Add A Musician</title>
</head>
<body>
	<main role="main">
	<h1>Add a New Musician</h1>
	<div class="container">
		<form action="InsertMusician" method="post">
			<div class="input-group mb-3">
				<span class="input-group-text" id="inputGroup-sizing-default">SSN</span>
				<input type="text" class="form-control"
					aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-default">
			</div>
			<div class="input-group">
				<span class="input-group-text">First and last name</span> <input
					type="text" aria-label="First name" class="form-control"> <input
					type="text" aria-label="Last name" class="form-control">
			</div>
			<div class="form-group">
				<label for="phonenum">Phone Number (format: xxx-xxxx-xxx):</label><br />
				<input id="phonenum" type="tel" pattern="^\d{3}-\d{4}-\d{3}$"
					required>

			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
	<a href="WEB-INF/index.jsp">back to home</a>
	</main>
</body>
</html>