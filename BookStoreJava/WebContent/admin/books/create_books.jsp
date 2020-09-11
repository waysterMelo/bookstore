<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Book</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
</head>
<body>

<jsp:include page="/admin/header.jsp"></jsp:include>

	<div class="container">
		<div class="text-center py-5">
		
		<c:if test="${book != null }">
				<h1 class="display-4 ">Edit Book <i class="fa fa-edit"></i> </h1>
		</c:if>
		<c:if test="${book == null }">
				<h1 class="display-4 text-capitalize">create book <i class="fa fa-heart"></i> </h1>
		
		</c:if>
	
		</div>
		
			<c:if test="${book != null }">
				<form action="update_book" method="post">
		<input type="hidden" name="bookid" value="${book.bookid }">
				 
		</c:if>
		<c:if test="${book == null }">
			<form action="create_book" method="post">	
		</c:if>
		
		
		
		<table data-role="table" id="table-1" class=" table table-striped">
			
				<tr>
					<td>Category:</td>
			<td>
			<select name="category">
			<c:forEach items="${category}" var="cat">
				<option value="${cat.categoryId }">
					${cat.nameCategory }
				</option>
			</c:forEach>
			</select>
			</td>
				</tr>
				
			<tr>
				<td>Title:</td>
				<td><input type="text" name="title" class="form-control" value="${book.title }"></td>
				<td>Author:</td>
				<td><input type="text" name="author" class="form-control" value="${book.author }"></td>	
			</tr>
			
			<tr>
				<td>Isbn:</td>
				<td><input type="text" name="isbn" class="form-control" value="${book.isbn}"></td>
			</tr>
			
			<tr>
				<td>Description:</td>
				<td><textarea name="desc" rows="" cols="50">${book.description }</textarea></td>
			</tr>
			
			<tr>
				<td>Price:</td>
				<td><input type="text" name="price" class="form-control" value="${book.price}"></td>
				<td>Date Publish:</td>
				<td><input type="date" name="dateP" class="form-control" value="${book.publishDate}"></td>
			
			</tr>
			
			<tr>
				<td>Image:</td>
				<td><input type="file" name="image" class="form-control" value="" size="20"></td>			
			</tr>
			
			
			
			<tfooter>
			<td align="right"><button class="btn btn-lg btn-primary">save</button>
		<button class="btn btn-lg btn-danger" onclick="javascript: history-go(-3)">cancel</button>
			</tfooter>
			
		</table>
		</form>
	
	</div>

</body>
</html>