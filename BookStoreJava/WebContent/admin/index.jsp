<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Administration</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
</head>

<body>


<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#"> <span class="text-success font-weight-bold">Ebook</span>-ecommerce</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav ml-auto">
      <li class="nav-item active">
        <a class="nav-link text-dark font-weight-bold" href="">Users<span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link text-dark font-weight-bold" href="">Categories</a>
      </li>
    
      <li class="nav-item">
        <a class="nav-link text-dark font-weight-bold" href="" ">New Books</a>
      </li>
      
        <li class="nav-item">
        <a class="nav-link text-dark font-weight-bold" href="">Customers</a>
      </li>
      
        <li class="nav-item">
        <a class="nav-link text-dark font-weight-bold" href="">Orders</a>
      </li>
    </ul>
    </div>
</nav>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#quickMenu" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="quickMenu">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link text-light font-weight-lighter" href="">new user<span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link  text-light font-weight-lighter" href="">new categories</a>
      </li>
    
      <li class="nav-item">
        <a class="nav-link  text-light font-weight-lighter" href="">new books</a>
      </li>
      
        <li class="nav-item">
        <a class="nav-link  text-light font-weight-lighter" href="">new customers</a>
      </li>
      

    </ul>
    </div>
</nav>

<div class="container">
	<div class="text-left">
		<div class="py-5">
		<h1 class="display-4">Admin Panel</h1>
		<p>welcome <b>Wayster H melo</b> | <a class="text-danger" href="logout">logout</a></p>
		</div>
	</div>
	
</div>



<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" ></script>
	
</body>
</html>