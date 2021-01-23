<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bookstore admnistration</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<div class="col-lg-12 py-5 text-center">
		<h1 class="text-primary ">Welcome administrator</h1>
		<p>wayster h c de melo
	</div>
	
	<div class="row">
		<h1 class="alert alert-info text-center">${message}</h1>
	</div>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>