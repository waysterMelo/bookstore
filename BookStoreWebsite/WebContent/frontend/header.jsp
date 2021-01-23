<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="${pageContext.request.contextPath}"> <span class="text-success font-weight-bold">Ebook</span>-ecommerce</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav ml-auto"> 
      <li class="nav-item active">
        <a class="nav-link" href="${pageContext.request.contextPath}">Home Page <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="">Books more sales</a>
      </li>
     <li class="nav-item">
        <a class="nav-link" href="admin/">admin</a>
      </li>
      <li class="nav-item">
        <a class="nav-link text-success font-weight-bold" href="new_books">New Books</a>
      </li>
    </ul>
 
  </div>
</nav>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark" style = "height: 30px">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#menu2" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="menu2">
    <ul class="navbar-nav ml-auto">    
   
     <c:if test="${logged_customer == null}">
    
    <li class="nav-item">
        <a class="nav-link p-5 text-white" href="register_here">register</a>
      </li>
      <li class="nav-item">
        <a class="nav-link p-5 text-white" href="login_customer">sign in</a>
      </li>
    
    </c:if>
  
  
  <c:if test="${logged_customer != null}">
  
      <li class="nav-item">
        <a class="nav-link p-5 text-white" href="my_profile"> <span class="text-success">Welcome </span>${logged_customer.fullname}</a>
      </li>
      <li class="nav-item">
        <a class="nav-link p-5 text-white" href="my_orders">my orders</a>
      </li>
        <li class="nav-item">
        <a class="nav-link p-5 text-white" href="customer_logout">logout</a>
      </li>
  
  </c:if>
   
   
     <li class="nav-item">
        <a class="nav-link p-5 text-white" href="cart">cart</a>
      </li>
    
    </ul>
 
  </div>
</nav>