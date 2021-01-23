<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User form</title>
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
		
		<c:if test="${user != null }">
				<h1 class="display-4 ">Edit an user <i class="fa fa-edit"></i> </h1>
		</c:if>
		<c:if test="${user == null }">
				<h1 class="display-4 text-capitalize">create an user <i class="fa fa-heart"></i> </h1>
		
		</c:if>
	
		</div>
		
			<c:if test="${user != null }">
				<form action="update_user" method="post">
		<input type="hidden" name="userId" value="${user.userId }">
				
		</c:if>
		<c:if test="${user == null }">
			<form action="create_user" method="post">	
		</c:if>
		
		
		
			<table data-role="table" id="table-1" class=" table table-striped">
			<tr>
				<td>Email:</td>
				<td>
				<input type="email" name="email" class="form-control" value="${user.email }">
				</td>
			</tr>
			
			<tr>
				<td>Full Name:</td>
				<td><input type="text" name="name" class="form-control" value="${user.nome }"></td>
			</tr>
			
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password" class="form-control" value="${user.senha}">
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