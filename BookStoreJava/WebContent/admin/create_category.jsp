<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Category</title>
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
		
		<c:if test="${category != null }">
				<h1 class="display-4 ">Edit category <i class="fa fa-edit"></i> </h1>
		</c:if>
		<c:if test="${category == null }">
				<h1 class="display-4 text-capitalize">create category <i class="fa fa-heart"></i> </h1>
		
		</c:if>
	
		</div>
		
			<c:if test="${category != null }">
				<form action="update_category" method="post">
		<input type="hidden" name="category_id" value="${category.categoryId }">
				 
		</c:if>
		<c:if test="${category == null }">
			<form action="create_category" method="post">	
		</c:if>
		
		
		
		<table data-role="table" id="table-1" class=" table table-striped">
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" class="form-control" value="${category.nameCategory }"></td>
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