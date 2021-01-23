<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Administration</title>
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
	<div class="col-lg-12 py-5 text-center">
	
		<h1 class="text-primary ">Welcome <c:out value="${sessionScope.User_email}" /></h1> <span><a href="logout">logout</a></span>
		<p>wayster h c de melo
	</div>
	<div class="container">
		<div class="col-lg-12">
		<div class="row">
			<h5>Recent Sales: </h5>
			<hr>
		</div>
			<div class="row">
			<h5>Recent Reviews: </h5>
			<hr>
		</div>
			<div class="row">
			<h5>Statistics: </h5>
			<hr>
		</div>
	</div>
	</div>



<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" ></script>
	
</body>
</html>