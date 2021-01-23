<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of Users</title>
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
		<h1 class="display-4">List of Users</h1>
		<p class="lead">here you'll find all users in your database </p>
		<a class="btn btn-md btn-success" href="create_user">create a new user</a>
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
					<th data-priority="2">email</th>
					<th>actions</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="user" varStatus="status" items="${listUsers}"> 
				<tr>
					<td>${status.index + 1}</td>
					<td>${user.userId}</td>
					<td>${user.nome}</td>
					<td>${user.email}</td>
					<td>
					<a href="edit_user?id=${user.userId}" class="text-light btn btn-dark btn-md">Edit</a>
					<span class="border-left mx-2"></span>
					<a href="javascript:confirmDelete(${user.userId})" class="text-light btn btn-danger btn-md">Remove</a>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	
	</div>	
	</div>
	
	


<jsp:include page="footer.jsp"></jsp:include>

<script>
	function confirmDelete(userId){
			if (confirm("Are you sure you want to delete this user " + userId + " ? ")) {
				window.location = 'delete_user?user_id=' + userId;
			}
		}
</script>
</body>
</html>