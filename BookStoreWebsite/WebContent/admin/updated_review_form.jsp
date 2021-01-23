<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Review form</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

	<div class="container">
		<div class="text-center py-5">
		
		<c:if test="${review != null }">
				<h1 class="display-4 ">Edit a review <i class="fa fa-edit"></i> </h1>
		</c:if>
		<c:if test="${review == null }">
				<h1 class="display-4 text-capitalize">create a review <i class="fa fa-heart"></i> </h1>
		
		</c:if>
	
		</div>
		
			<c:if test="${review != null }">
				<form action="do_update" method="post">
		<input type="hidden" name="Id" value="${review.reviewId }">
				
		</c:if>
		<c:if test="${review == null }">
			<form action="" method="post">	
		</c:if>
		
		
		
			<table data-role="table" id="table-1" class=" table table-striped">
			<tr>
				<td>Book:</td>
				<td>
				<input type="text" name="book" class="form-control" value="${review.book.title }">
				</td>
			</tr>
			
			<tr>
				<td>Rating:</td>
				<td><input type="text" name="rating" class="form-control" value="${review.rating }"></td>
			</tr>
			
			<tr>
				<td>Customer:</td>
				<td><input type="text" name="customer" class="form-control" value="${review.customer.fullname}">
			</tr>
			<tr>
			
			<tr>
				<td>Headline:</td>
				<td><input type="text" name="headline" class="form-control" value="${review.headline}">
			</tr>
			<tr>
			
			<tr>
				<td>Comment:</td>
				<td><textarea type="text" name="comments" class="form-control">${review.comment}</textarea>
			</tr>
			<tr>
			
			<td align="right"><button class="btn btn-lg btn-primary">salvar</button></td>
			<td><button class="btn btn-lg btn-danger" onclick="javascript: history-go(-3)">cancel</button></td>
			</tr>
		</table>
		</form>
	
	</div>

</body>
</html>