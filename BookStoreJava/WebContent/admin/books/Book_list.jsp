<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of Books</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
</head>
<body>

<header>
	<jsp:include page="/admin/header.jsp"></jsp:include>
</header>

	<div class="container pt-3">
		<div class="jumbotron">
		<h1 class="display-4">List of Books</h1>
		<p class="lead">here you'll find all books in your database </p>
		<a class="btn btn-md btn-success" href="create_book">create a new book</a>
	</div>
	<div class="row">
	<c:if test="${message != null }">
		<div>
			<h1 align="center" class="alert alert-success">${message}</h1>
	</div>
	</c:if>
		
		<table data-role="table" id="table-1" class="ui-responsive table" cellspacing="5">
			<thead>
				<tr>
					<th>index</th>
					<th data-priority="1">id</th>
					<th data-priority="2">image</th>
					<th data-priority="2">title</th>
					<th data-priority="2">isbn</th>
					<th data-priority="2">author</th>
					
					<th>actions</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="book" varStatus="status" items="${list_books}"> 
				<tr>
					<td>${status.index + 1}</td>
					<td>${book.bookId}</td>
					<td><img alt="" src="data:image/jpg;base64,${book.base64image}" class="w-25"></td>
					<td>${book.title}</td>
					<td>${book.isbn}</td>
					<td>${book.author}</td>
				
					<td>
					<a href="edit_book?id=${book.bookId}" class="text-light btn btn-dark btn-md">Edit</a>
					<span class="border-left mx-2"></span>
					<a href="javascript:confirmDelete(${book.bookId})" class="text-light btn btn-danger btn-md">Remove</a>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	
	</div>	
	</div>
	
	


<jsp:include page="/admin/footer.jsp"></jsp:include>

<script>
	function confirmDelete(bookId){
			if (confirm("Are you sure you want to delete this user " + bookId + " ? ")) {
				window.location = 'delete_book?id=' + bookId;
			}
		}
</script>
</body>
</html>