<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
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
<title>Album</title>
</head>
<body>
	<div class="container">
		<h1>Albums</h1>
		<form action="select/SelectAlbum" method="get">
			<table class="table" class="table-success">
				<tr class="table-success">
					<th>Album ID</th>
					<th>Title</th>
					<th>Date Copyright</th>
					<th>Format</th>
					<th>Producer</th>
					<th>Check number of Songs</th>
					<th>Delete Album</th>
				</tr>
				<c:forEach items="${album}" var="album">
					<tr class="table-success">
						<td class="table-success">${album.albumId}</td>
						<td class="table-success">${album.title}</td>
						<td class="table-success">${album.dateCopyRight}</td>
						<td class="table-success">${album.format}</td>
						<td class="table-success">${album.musSSN}</td>
						<td class="table-success"><a
							href="TotalSongsInAlbum?albumId=${album.albumId}"> Get Song
								Total </a></td>
						<td class="table-success"><a href="DeleteAlbum?id=${album.albumId}"
							class="btn btn-danger btn-xs"> delete
						</a></td>
					</tr>
				</c:forEach>
			</table>
			<p>There are currently ${totalSong} songs in that album.</p>
		</form>
	</div>
	<a href="WEB-INF/index.jsp">back to home</a>
</body>
</html>
