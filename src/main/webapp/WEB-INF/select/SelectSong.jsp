<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Song</title>
</head>
<body>
	<div class="container">
		<h1>Songs</h1>
		<form action="select/SelectSong" method="post">
			<table class="table">
					<tr>
						<th>Song ID</th>
						<th>Title</th>
						<th>Author</th>
						<th>Album ID</th>
						<th></th>
					</tr>
					<c:forEach items="${songs}" var="song">
						<tr>
							<td>${song.idSong}</td>
							<td>${song.title}</td>
							<td>${song.author}</td>
							<td>${song.idAlbum}</td>
						</tr>
					</c:forEach>
			</table>
		</form>
	</div>
</body>
</html>
