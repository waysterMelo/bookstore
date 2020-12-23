  <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="${pageContext.request.contextPath}"> <span class="text-success font-weight-bold">Ebook</span>-ecommerce</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav ml-auto">
      <li class="nav-item active">
        <a class="nav-link text-dark font-weight-bold" href="list_users">Users<span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
         <a class="nav-link text-dark font-weight-bold" href="category_list">Categories</a>
      </li>
    
      <li class="nav-item">
        <a class="nav-link text-dark font-weight-bold" href="list_books">Books</a>
      </li>
      
        <li class="nav-item">
        <a class="nav-link text-dark font-weight-bold" href="view_customers">Customers</a>
      </li>
      
        <li class="nav-item">
        <a class="nav-link text-dark font-weight-bold" href="list_reviews">Reviews</a>
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