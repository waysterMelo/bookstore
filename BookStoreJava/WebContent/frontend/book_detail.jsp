<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta charset="ISO-8859-1">
<title>Book Detail</title>
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
	
	
	<section>
	
		<div class="container">
			<div class="row mx-auto">
				<div class="col-md-4"> 
				<div class="mt-5">
					<div class="row justify-content-center">
					<img id="image-1" 
					alt="${bookId.title}" src="data:image/jpg;base64,${bookId.base64image}" class="w-75 "/>
					</div>
					<div class="row justify-content-center pt-4">
					 <button class="btn btn-danger btn-lg">R$ ${bookId.price} </button>					
					</div>
				</div>
					
				</div>
				<div class="col-md-8 text-left">
					<div class="jumbotron bg-light">
					  <h1 class="display-4"> ${bookId.title} </h1>
					  <p class="lead"> ${bookId.description}</p>
					  <hr class="my-4">
					  <p> by: ${bookId.author}</p>
					  <p class="lead" align="right">
					    <a class="btn btn-success btn-lg" href="#" role="button">Buy</a>
					  </p>
					</div>
				</div>
			</div>
		</div>
	</section>
	
	<section class="container mt-5">
		<div class="row">
		<h1 class="lead">Reviews</h1>
		<span class="mx-5"><i class="fa fa-star"></i>
			<i class="fa fa-star"></i>
			<i class="fa fa-star"></i>
			<i class="fa fa-star"></i>
			<i class="fa fa-star"></i>
		</span>
		 <button class="btn btn-light ml-auto">write a review</button>
		</div>
	</section>
	
	

	
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>

