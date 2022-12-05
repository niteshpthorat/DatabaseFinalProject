<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">  
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
	
<title>Song</title>
</head>
<body>
	<div class="container">
		<h1>Songs</h1>
		<form action="select/SelectSong" method="post">
			<table class="table" class="table-success">
					<tr class="table-success">
						<th>Song ID</th>
						<th>Title</th>
						<th>Author</th>
						<th>Album ID</th>
						<th></th>
					</tr>
					<c:forEach items="${songs}" var="song">
						<tr  class="table-success">
							<td class="table-success">${song.idSong}</td>
							<td class="table-success">${song.title}</td>
							<td class="table-success">${song.author}</td>
							<td class="table-success">${song.idAlbum}</td>
							<td class="table-success"><a href="DeleteSong?id=${song.idSong}"
							class="btn btn-danger btn-xs"> delete
						</a></td>
						</tr>
					</c:forEach>
			</table>
		</form>
	</div>
	<a href="Home">back to home</a>
</body>
</html>
