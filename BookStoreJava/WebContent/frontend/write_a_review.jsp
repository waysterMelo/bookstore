<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Write a review</title>
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
			<h1>Write a Review</h1>
	</div>
</div>

<div class="container">
	<div class="row justify-content-center">
		<form id="form">
			<table id="table-1" class="table">
					<tr>
						<td>Your Reviews</td>
						<td>${logged_customer.fullname}</td>
					</tr>
				<tbody>
					<tr>
						<td>a</td>
						<td>b</td>
						<td>c</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<th>A</th>
						<th>B</th>
						<th>C</th>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
</div>




	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>