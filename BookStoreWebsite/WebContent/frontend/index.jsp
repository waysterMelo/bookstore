<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta charset="ISO-8859-1">
<title>Book E-Commerce</title>
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

	<div class="container-fluid " id="headerback">
		<div class="col-md-12">

			<div class="text-center">
				<div class="py-5">
					<h1 class="display-2 text-primary font-weight-bold">Searching
						your desire book</h1>
					<div class="row justify-content-center">
						<div class="d-flex">
							<form action="search" method="get" class="form-inline border-0 pt-4"
								style="background: transparent;">
								<input type="text" id="input" name="keyword" class="form-control mr-sm-2"
									placeholder="Type your book" />
								<button type="submit" id="inputButton" class="btn btn-success">
									search <i class="fa fa-search-plus"></i>
								</button>
							</form>
						</div>
					</div>
					<div class="row pt-5 mt-5">
						<div class="col-md-12">
							<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
								<button class="navbar-toggler" type="button"
									data-toggle="collapse" data-target="#quickMenu"
									aria-controls="navbarSupportedContent" aria-expanded="false"
									aria-label="Toggle navigation">
									<span class="navbar-toggler-icon"></span>
								</button>

								<div class="collapse navbar-collapse" id="quickMenu">
									<ul class="navbar-nav mx-auto">
									
<c:forEach var="categories" items="${name_category}" varStatus="status">
			<li class="nav-item">
       	 <a class="nav-link text-white font-weight-bold" href="view_category?id=${categories.categoryId}">
        <font size="+1"><b><c:out value="${categories.nameCategory}"></c:out></b></font>
        </a>
       </li>
          </c:forEach>

								
									</ul>
								</div>
							</nav>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>




	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>

