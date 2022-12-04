<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Add A Musician</title>
</head>
<body>
	<main role="main">
	   <h1>Add a New Musician</h1>
	<div class="container">
	<form action="InsertMusician" method="post">
		<div class="form-group">
			<label for="ssn">Social Security Number</label>
		    <input type="text" class="form-control" name="ssn"  placeholder="Enter Social Security Number"></input>
		</div>
		<div class="form-group">
			<label for="name">Name</label>
			<input type="text" class="form-control" name="name"  placeholder="Enter Full Name"></input>
		</div>
		<div class="form-group">
			<label for="phoNo">Phone Number</label>
			<input type="text" class="form-control" name="phone_no"></input>
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
	</div>
	</main>
</body>
</html>