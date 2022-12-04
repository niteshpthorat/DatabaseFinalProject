<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Add Address and Phone Number</title>
</head>
<body>
	<main role="main">
	   <h1>Add Address and Phone Number</h1>
	<div class="container">
	<form action="InsertAddress" method="post">
		<div class="form-group">
			<label for="address">Address</label>
		    <input type="text" class="form-control" name="address"  placeholder="Enter Address"></input>
		</div>
		<div class="form-group">
			<label for="phoneNumber">Phone Number</label>
			<input type="textbox" class="form-control" name="phoneNumber"></input>
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
	</div>
	</main>
</body>
</html>