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
					    <a id="add_to_cart" class="btn btn-success btn-lg" href="#" role="button">Buy</a>
					  </p>
					</div>
				</div>
			</div>
			<div class="row justify-content-end">
					<button id="button_write_review" class="btn btn-primary">write a review</button>
				</div>
		</div>
	</section>
	
	<section class="container mt-5">
		<div class="row">
		<h1 class="lead">Reviews</h1>
			<div class="mx-4">
			<c:forEach items="${bookId.reviews}" var="review">
					<c:forTokens items="${review.stars}" delims="," var="star">
					
					<c:if test="${star eq 'on'}">
					
						<i class="fa fa-star text-danger"></i>
					
					</c:if>
					
						<c:if test="${star eq 'off'}">
					
						<i class="fa fa-star-o text-danger"></i>
					
					</c:if>
					
					<c:if test="${star eq 'half'}">
					
						<i class="fa fa-star-half-o text-danger"></i>
					
					</c:if>
					
					</c:forTokens>
						<span class="mx-4">${review.headline}</span>
						<div class="row">
							<div class="col-md-8">
								<p>${review.comment}
								</p>
							</div>
						</div>
				</c:forEach>
			</div>	
			</div>
	</section>
	
	<jsp:include page="footer.jsp"></jsp:include>

<script type="text/javascript">
	$(document).ready(function(){
			$("#button_write_review").click(function(){
				window.location = 'write_review?bookId=' + ${bookId.bookId};
				});
			
			$("#add_to_cart").click(function () {
				window.location  ='add_to_cart?bookId='+ ${bookId.bookId}; 
			});
			
			
			});
	</script>
</body>
</html>

