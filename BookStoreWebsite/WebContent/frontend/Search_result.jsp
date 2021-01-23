<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta charset="ISO-8859-1">
<title>Book results</title>
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

	
	<div class="container">
	<div class="row">
	<c:forEach var="b" items="${search}" varStatus="status">
		<div class="col-md-4">
			<div class="card border-0" style="width: 18em">
				<div class="card-body">
				<div class="row justify-content-center ">
				<img alt="${b.title}" src="data:image/jpg;base64,${b.base64image}"
				 class="img-fluid w-50" style="min-height: 200px; max-height: 200px">
				</div>
			</div>
				<div class="card-footer ">
					<h1 class="lead card-title text-center">${b.title}</h1>
					<div class="row justify-content-center py-1 text-danger">
					<i class="fa fa-star"></i>
					<i class="fa fa-star"></i>
					<i class="fa fa-star"></i>
					<i class="fa fa-star"></i>
					<i class="fa fa-star"></i>
					</div>
					<div class="row my-2"><span>By: </span> ${b.author} </div>
					<div class="row justify-content-center">
					<button class="btn btn-info p-2">R$ ${b.price}</button>
						<a href="view_book?id=${b.bookId}" class="btn btn-dark p-2 mx-3">Details</a>
						<button class="btn btn-success p-2">Buy</button>
						
					</div>
				</div>
			</div>
		</div>
		</c:forEach>
	</div>
</div>
	


	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>

