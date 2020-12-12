<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta charset="ISO-8859-1">
<title>Edit Profile</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">

</head>
<style><%@ include file ="../css/indexStyle.css"%>
</style>

<body>
	<header>
		<jsp:include page="header.jsp"></jsp:include>
		<div class="row justify-content-center pt-5" >
			<h1 class="">Welcome ${logged_customer.fullname}</h1>
		</div>
		<div class="row justify-content-center">
		<h2 class="text-danger">Edit your profile</h2>
		</div>
	</header>





<section>
	<div class="container">
		<div class="row">
			<div class="col-md-4 mx-auto">
				<img alt="" src="images/0.jpg" class="img-fluid img-thumbnail"> <br>
				<div class="row pt-1">
				<a href="edit_profile" class="btn btn-success ml-5 mt-3">Edit my profile</a>
				</div>
			</div>
			
			<div class="col-md-8">
			<c:if test="${msg != null }">
				<div class="row">
				<div class="alert alert-primary">
				<h1>
					${msg}
				</h1>
				</div>
			</div>
			</c:if>
			<form class="mt-3" action="edit_my_profile" method="post" enctype="application/x-www-form-urlencoded">
  <div class="form-group">
    <label for="name">Full Name</label>
    <input type="text" class="form-control" id="name" name="name"  value="${logged_customer.fullname}">
  </div>
  <div class="form-group">
    <label for="email">Email</label>
    <input type="email" class="form-control" id="email" name="email" value="${logged_customer.email}"> 
  </div>
	
	 <div class="form-group">
    <label for="address">Address</label>
    <input type="text" class="form-control" id="address" name="address" value="${logged_customer.address}"> 
  </div>
  
   <div class="form-group">
    <label for="city">City</label>
    <input type="text" class="form-control" id="city" name="city" value="${logged_customer.city}"> 
  </div>
  
   <div class="form-group">
    <label for="password">Password</label>
    <input type="password" class="form-control" id="password" name="password" value="${logged_customer.password}"> 
		<input class="btn btn-success mt-4" type="submit" value="Save" id="button-1"/>
  </div>

</form>
			</div>
		</div>
	</div>
</section>



			
	<footer>
	<jsp:include page="footer.jsp"></jsp:include>
	</footer>
</body>
</html>