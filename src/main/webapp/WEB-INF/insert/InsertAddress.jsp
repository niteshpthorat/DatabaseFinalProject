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

<title>Add Address and Phone Number</title>
</head>
<body>
	<main role="main">
	<h1>Add Address and Phone Number</h1>
	<div class="container">
		<form action="InsertAddress" method="post">
			<div class="form-outline mb-4">
				<input type="text" id="form7Example4" class="form-control" /> <label
					class="form-label" for="form7Example4">Address</label>
			</div>
			<div class="form-outline mb-3" style="width: 100%; max-width: 22rem">
				<input type="text" id="phone" class="form-control"
					data-mdb-input-mask="+1 999-999-999" /> <label class="form-label"
					for="phone">Phone number with country code</label>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
	</main>
	<a href="WEB-INF/index.jsp">back to home</a>
</body>
</html>