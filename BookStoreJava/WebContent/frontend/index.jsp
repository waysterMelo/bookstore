<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<body>

<style>
        <%@include file="../css/indexStyle.css" %>
</style>


	<header>
		<jsp:include page="header.jsp"></jsp:include>
	</header>

	<div class="container-fluid" id="headerback">
		<div class="col-md-12">

			<div class="text-center">
				<div class="py-5">
					<h1 class="display-3 text-primary font-weight-lighter">Searching
						your desire book</h1>
					<div class="row justify-content-center">
						<div class="d-flex">
							<form class="form-inline border-0 pt-4"
								style="background: transparent;">
								<input type="search" id="input" class="form-control mr-sm-2"
									placeholder="Type your book" />
									 <button type="submit"
									id="inputButton" class="btn btn-success">search <i class="fa fa-search-plus"></i></button>
							</form>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>
	
	
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>

