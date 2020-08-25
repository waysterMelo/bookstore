<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of Categories</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
</head>
<body>

<header>
	<jsp:include page="header.jsp"></jsp:include>
</header>

	<div class="container pt-3">
		<div class="jumbotron">
		<h1 class="display-4">List of Categories</h1>
		<p class="lead">here you'll find all categories in your database </p>
		<a class="btn btn-md btn-success" href="create_category">create new category</a>
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
					<th data-priority="2">name</th>
					<th>actions</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="cat" varStatus="status" items="${list_category}"> 
				<tr>
					<td>${status.index + 1}</td>
					<td>${cat.categoryId}</td>
					<td>${cat.nameCategory}</td>
				
					<td>
					<a href="edit_cat?id=${cat.categoryId}" class="text-light btn btn-dark btn-md">Edit</a>
					<span class="border-left mx-2"></span>
					<a href="javascript:confirmDelete(${cat.categoryId})" class="text-light btn btn-danger btn-md">Remove</a>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	
	</div>	
	</div>
	
	


<jsp:include page="footer.jsp"></jsp:include>

<script>
	function confirmDelete(categoryId){
			if (confirm("Are you sure you want to delete this user " + categoryId + " ? ")) {
				window.location = 'delete_cat?category_id=' + categoryId;
			}
		}
</script>
</body>
</html>