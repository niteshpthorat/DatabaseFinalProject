<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Album</title>
</head>
<body>
	<div class="container">
		<h1>Albums</h1>
		<form action="select/SelectAlbum" method="get">
			<table class="table">
				<tr>
					<th>Album ID</th>
					<th>Title</th>
					<th>Date Copyright</th>
					<th>Format</th>
					<th>Producer</th>
				</tr>
				<c:forEach items="${album}" var="album">
					<tr>
						<td>${album.albumId}</td>
						<td>${album.title}</td>
						<td>${album.dateCopyRight}</td>
						<td>${album.format}</td>
						<td>${album.musSSN}</td>
						<td><a href="TotalSongsInAlbum?albumId=${album.albumId}">
								Get Song Total </a></td>
					</tr>
				</c:forEach>
			</table>
			<p>There are currently ${totalSong} songs in that album.</p>
		</form>
	</div>
</body>
</html>
