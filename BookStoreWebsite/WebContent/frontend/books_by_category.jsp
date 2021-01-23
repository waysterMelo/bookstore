<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Books by Category</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
</head>
<style><%@ include file ="../css/indexStyle.css" %>
</style>
<body style="background-color: whitesmoke">
	<header>
		<jsp:include page="header.jsp"></jsp:include>
	</header>


<div class="container">
	<div class="text-center py-5">
		<c:forEach varStatus="status" var="name" items="${name_category}">
			<h1>${name}</h1>
		</c:forEach>
	<h1></h1>
	</div>
</div>

<div class="container">
	<div class="row">
	<c:forEach var="b" items="${list_books}" varStatus="status">
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
					
					<c:forTokens items="${b.ratingStars}" delims="," var="star">
					
					<c:if test="${star eq 'on' }">
					
						<i class="fa fa-star"></i>
					
					</c:if>
					
						<c:if test="${star eq 'off' }">
					
						<i class="fa fa-star-o"></i>
					
					</c:if>
					
					<c:if test="${star eq 'half' }">
					
						<i class="fa fa-star-half-o"></i>
					
					</c:if>
					
					</c:forTokens>
				
				
					</div>
					<div class="row my-2"><span>By: </span> ${b.author} </div>
					<div class="row justify-content-center">
					<button class="btn btn-info p-2">R$ ${b.price}</button>
						<a href="view_book?id=${b.bookId}" class="btn btn-dark p-2 mx-3">Details</a>
						<a href="add_to_cart?bookId=${b.bookId}" class="btn btn-success p-2">Buy</a>						
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