<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta charset="ISO-8859-1">
<title>Register Here | E-Commerce</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">

</head>
<style><%@ include file ="../css/indexStyle.css" %>
</style>

<body>
	<header>
		<jsp:include page="header.jsp"></jsp:include>
	</header>

	
	<section class="container">
		<div class="col-md-12">
			<h1 class="text-center py-5">Register Here</h1>
			
			
			<c:if test="${messager != null}">
				<div class="alert ">
					<h1 class="alert alert-primary">${messager}</h1>
				</div>
			</c:if>
			
			<form id="form-1" class="row" action="register_save" method="post">
				<div class="col-md-6">
				<div class="form-group">
					<label id="name">Name:</label>
					<input id="name" name="name" placeholder="type your Name here" type="text" class="form-control"/>
				</div>
					<div class="form-group">
					<label id="email">Email:</label>
					<input id="email" name="email" placeholder="type your Email here" type="email" class="form-control"/>
				</div>
				</div>
					<div class="col-md-6">
				<div class="form-group">
					<label id="password">Password:</label>
					<input id="password" name="password" placeholder="type your Password here" type="password" class="form-control"/>
				</div>
					<div class="form-group">
					<label id="address">Address:</label>
					<input id="address" name="address" placeholder="type your address here" type="text" class="form-control"/>
				</div>
				</div>
				
				<div class="col-md-6">
				<div class="form-group">
					<label id="city">City:</label>
					<input id="city" name="city" placeholder="type your city here" type="text" class="form-control"/>
				</div>
				
				<div class="form-group">
					<label id="state">State:</label>
					<input id="state" name="state" placeholder="type your state here" type="text" class="form-control"/>
				</div>
				</div>
				<div class="col-md-6">
					<input type="submit" value="Submit" id="button-1" class="btn btn-primary btn-lg"/>
				</div>
			</form>
		</div>
	</section>


	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>

