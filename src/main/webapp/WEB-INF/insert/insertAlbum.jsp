<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Add An Album</title>
</head>
<body>
	<main role="main">
	   <h1>Add an Album</h1>
	<div class="container">
	<form action="InsertAlbum" method="post">
		<div class="form-group">
			<label for="title">Title</label>
			<input type="text" class="form-control" name="title"  placeholder="Enter Album Title"></input>
		</div>
		<div class="form-group">
			<label for="copyright_dt">Copyright Date (YYYY-MM-DD)</label>
			<input type="text" class="form-control" name="dateCopyright"  placeholder="Enter Copyright Date"></input>
		</div>
		<div class="form-group">
			<label for="format">Album's Format </label>
			<input type="text" class="form-control" name="format"  placeholder="Enter Album's Format"></input>
		</div>
		<div class="form-group">
			<label for="m_ssn">Musician's Social Security Number</label>
			<input type="text" class="form-control" name="musSSN"  placeholder="Enter Musician's Social Security Number"></input>
		</div>
				<div class="form-group">
			<label for="album_id">Identifier</label>
		    <input type="text" class="form-control" name="identifier"  placeholder="Enter Album Identifier"></input>
		</div>
		
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
	</div>
	<a href="Home">back to home</a>
	</main>
</body>
</html>