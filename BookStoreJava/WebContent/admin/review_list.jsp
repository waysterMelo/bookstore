<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Review List</title>
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
		<h1 class="display-4">List of Reviews</h1>
		<p class="lead">here you'll find all reviews in your database </p>
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
				
					<th data-priority="1">Id</th>
					<th data-priority="2">Book</th>
					<th data-priority="2">Rating</th>
					<th data-priority="2">Headline</th>
					<th data-priority="2">Customer</th>
					<th data-priority="2">Comment</th>
					<th data-priority="2">Review On</th>
					<th data-priority="2">Actions</th>
					<th>actions</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="r" varStatus="status" items="${listAllReviews}"> 
				<tr>
					<td>${r.reviewId}</td>
					<td>${r.book.title}</td>
					<td>${r.rating}</td>
					<td>${r.headline}</td>
					<td>${r.customer.fullname}</td>
					<td><textarea>${r.comment}</textarea></td>
					<td>${r.reviewTime}</td>
					
					<td>
					<a href="edit_review?id=${r.reviewId}" class="text-light btn btn-dark btn-md">Edit</a>
					<span class="border-left mx-2"></span>
					<a href="javascript:confirmDelete(${r.reviewId})" class="text-light btn btn-danger btn-md">Remove</a>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	
	</div>	
	</div>
	
	


<jsp:include page="/admin/footer.jsp"></jsp:include>

<script>
	function confirmDelete(reviewId){
			if (confirm("Are you sure you want to delete this review " + reviewId + " ? ")) {
				window.location = 'delete_review?id=' + reviewId;
			}
		}
</script>
</body>
</html>