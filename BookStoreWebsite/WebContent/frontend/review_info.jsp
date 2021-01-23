<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Review info</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.3.2/jquery.rateyo.min.css">
</head>
<style><%@ include file ="../css/indexStyle.css" %>
</style>
<body style="background-color: whitesmoke">
	<header>
		<jsp:include page="header.jsp"></jsp:include>
	</header>


<div class="container">
	<div class="text-center py-5">
			<h1>Review Info</h1>
	</div>
</div>

<div class="container">
	<div class="row justify-content-center">
		<form id="form" action="submit_review" method="post">
			<table id="table-1" class="table" width="600">
					<tr>
						<td class="h4">You already wrote a review for this book</td>
						<td>${logged_customer.fullname}</td>
					</tr>
					<tr>
						<td colspan="3"></td>
					</tr>
						<tr>
						<td>
						<span class="font-weight-bold">${book.title}</span> <br/>
							<img id="image-1" alt="" src="data:image/jpg;base64,${book.base64image}"/>
						</td>
						<td>
						<div id="rateYo"></div>
						<input type="hidden" id="rating" name="rating"/>
						<input name="bookId" type="hidden" value="${book.bookId}"> 
						<br/>
							<input type="text" size="60" name="headline" readonly="readonly" value="${review.headline}"/> 
							<br/>
							<textarea rows="10" cols="70" name="comment" readonly="readonly">${review.comment }</textarea>
						</td>
					</tr>
					
			</table>
		</form>
	</div>
</div>




	<jsp:include page="footer.jsp"></jsp:include>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.3.2/jquery.rateyo.min.js"></script>
	<script type="text/javascript">

		$(document).ready(function(){

			$('#rateYo').rateYo({
					starWidth: "40px",
					fullStar: true,
					rating: ${review.rating},
					readOnly: true
				 });

			 $('#cancel').click(function(){
					history.go(-1);
				 });
	});
	</script>
</body>
</html>