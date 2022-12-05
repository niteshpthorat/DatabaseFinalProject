<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Add A Song</title>
</head>
<body>
	<main role="main">
	   <h1>Add A Song</h1>
	<div class="container">
	<form action="InsertSong" method="post">
		<div class="form-group">
			<label for="title">Song Title</label>
		    <input name = "songTitle" type="text" class="form-control" name="title"  placeholder="Enter Song Title"></input>
		</div>
		<div class="form-group">
			<label for="author">Song Author</label>
			<input name = "songTitle"  type="text" class="form-control" name="author"  placeholder="Enter Song's Author"></input>
		</div>
		<div class="form-group">
			<label for="album_id">Album ID </label>
			<input  name = "songTitle"  type="text" class="form-control" name="album_id"  placeholder="Enter Album ID"></input>
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
	</div>
	</main>
</body>
</html>