<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Review done</title>
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
	<div class="row justify-content-center">
			<div class="py-5 texte-center alert alert-success">
				<h1>Review Done</h1>
				 <br/>
				<div class="row mx-auto">
					<a href="${pageContext.request.contextPath}" class="btn btn-danger">Exit</a>
				</div>
			</div>
		</div>
</div>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>