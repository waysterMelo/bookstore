<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Internal Server Error</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="py-5 text-center">
			<h1 class="alert alert-danger">Ops... Internal Server Error</h1>
			<h2 class="lead py-5">please contact your administrator</h2>
			<a  class="btn btn-primary" href="${pageContext.request.contextPath}/">go back</a>
		</div>
	</div>
	
	
	<jsp:include page="/frontend/footer.jsp"></jsp:include>
</body>
</html>