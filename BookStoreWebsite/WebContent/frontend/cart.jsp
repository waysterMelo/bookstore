<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta http-equiv="x-ua-compatible" content="ie=edge">
  <title>Cart</title>
 
 <link rel="stylesheet" href="css/bootstrap4.1.min.css">

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">

<link rel="stylesheet" href="css/mdb.min.css">

<link rel="stylesheet" href="css/mdb-pro.min.css">


</head>

	<c:set var="cart" value="${sessionScope['cart']}" />
	
	

<body class="skin-light">

  <!--Main Navigation-->
  <header>
		<jsp:include page="header.jsp"></jsp:include>
  </header>
  <!--Main Navigation-->

  <!--Main layout-->
  <main>
<form action="update_cart" method="post" id="cartForm">
    <div class="container">

      <!--Section: Block Content-->
      <section class="mt-5 mb-4">

        <!--Grid row-->
        <div class="row">

          <!--Grid column-->
          <div class="col-lg-8">
          
          <c:if test="${cart.totalItems == 0 }">
		<h2>there's no item in your cart</h2>
	</c:if>
	
	  <c:if test="${cart.totalItems > 0 }">
		  <!-- Card -->
            <div class="card wish-list mb-4">
              <div class="card-body">

                <h5 class="mb-4">Cart (<span>${cart.totalItems}</span> items)</h5>

				<c:forEach items="${cart.items}" var="item" varStatus="status">
					
                <div class="row mb-4">
                  <div class="col-md-5 col-lg-3 col-xl-3">
                    <div class="view zoom overlay z-depth-1 rounded mb-3 mb-md-0">
                      <img class="img-fluid w-100"
                        src="data:image/jpg;base64,${item.key.base64image}" alt="Sample">
                      <a href="#!">
                        <div class="mask waves-effect waves-light">
                          <img class="img-fluid w-50"
                            src="">
                          <div class="mask rgba-black-slight waves-effect waves-light"></div>
                        </div>
                      </a>
                    </div>
                  </div>
                  <div class="col-md-7 col-lg-9 col-xl-9">
                    <div>
                      <div class="d-flex justify-content-between">
                        <div>
                          <h5>${item.key.title}</h5>
                        
                        </div>
                        <div>
                          <div class="def-number-input number-input safari_only mb-0 w-100 col-lg-12">
                       
                          <input type="hidden" name="bookId" value="${item.key.bookId}">

                          <input type="text" class="quantity" min="1" name="quantity${status.index + 1}" value="${item.value}" size="5">
                       
                          </div>
                      	
                        </div>
                    
                      	<button class="btn btn-primary" type="submit">update</button>
                
                      </div>
                      <div class="d-flex justify-content-between align-items-center">
                        <div>
                          <a href="remove_from_cart?bookId=${item.key.bookId}" class="card-link-secondary small text-uppercase mr-3"><i
                              class="fas fa-trash-alt mr-1"></i> Remove item </a>
                          <a href="#!" type="button" class="card-link-secondary small text-uppercase"><i
                              class="fas fa-heart mr-1"></i> Move to wish list </a>
                        </div>
          
                      </div>
                    </div>
                  </div>
                </div>
              						
				</c:forEach>

                <hr class="mb-4">
               
           		<div class="row justify-content-end">
           			<div class="">
						<a href="clear_cart" class="btn btn-primary">Clear cart</a>           			
           			</div>
           		</div>

              </div>
            </div>
            <!-- Card -->
		
	</c:if>

          

            <!-- Card -->
            <!-- some text -->
            <div class="card mb-4">
              <div class="card-body">

                <h5 class="mb-4">Expected shipping delivery</h5>

                <p class="mb-0"> Thu., 12.03. - Mon., 16.03.</p>
              </div>
            </div>
            <!-- Card -->

            <!-- Card -->
            <!-- we accept -->
            <div class="card mb-4">
              <div class="card-body">

                <h5 class="mb-4">We accept</h5>

                <img class="mr-2" width="45px"
                  src="https://mdbootstrap.com/wp-content/plugins/woocommerce-gateway-stripe/assets/images/visa.svg"
                  alt="Visa">
                <img class="mr-2" width="45px"
                  src="https://mdbootstrap.com/wp-content/plugins/woocommerce-gateway-stripe/assets/images/amex.svg"
                  alt="American Express">
                <img class="mr-2" width="45px"
                  src="https://mdbootstrap.com/wp-content/plugins/woocommerce-gateway-stripe/assets/images/mastercard.svg"
                  alt="Mastercard">
                <img class="mr-2" width="45px"
                  src="https://z9t4u9f6.stackpathcdn.com/wp-content/plugins/woocommerce/includes/gateways/paypal/assets/images/paypal.png"
                  alt="PayPal acceptance mark">
              </div>
            </div>
            <!-- Card -->

          </div>
          <!--Grid column-->

          <!--Grid column-->
          <div class="col-lg-4">

            <!-- Card -->
            <div class="card mb-4">
            
              <div class="card-body">

                <h5 class="mb-3">The total amount of</h5>

                <ul class="list-group list-group-flush">
                  <li class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 pb-0">
                    Temporary amount
                    <span>R$${cart.totalQtd},00</span>
                  </li>
                  <li class="list-group-item d-flex justify-content-between align-items-center px-0">
                    Shipping
                    <span>Gratis</span>
                  </li>
                  <li class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 mb-3">
                    <div>
                      <strong>The total amount of</strong>
                      <strong>
                        <p class="mb-0">(including VAT)</p>
                      </strong>
                    </div>
                  
                    <span><strong>R$${cart.totalQtd},00</strong></span>
                  </li>
                </ul>

                <button type="button" class="btn btn-primary btn-block waves-effect waves-light">go to
                  checkout</button>

              </div>
               
            </div>
            <!-- Card -->

            <!-- Card -->
            <div class="card mb-4">
              <div class="card-body">

                <a class="dark-grey-text d-flex justify-content-between" data-toggle="collapse" href="#collapseExample"
                  aria-expanded="false" aria-controls="collapseExample">
                  Add a discount code (optional)
                  <span><i class="fas fa-chevron-down pt-1"></i></span>
                </a>

                <div class="collapse" id="collapseExample">
                  <div class="mt-3">
                    <div class="md-form md-outline mb-0">
                      <input type="text" id="discount-code" class="form-control font-weight-light"
                        placeholder="Enter discount code">
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <!-- Card -->

          </div>
          <!--Grid column-->

        </div>
        <!--Grid row-->

      </section>
      <!--Section: Block Content-->

    </div>
</form>
  </main>
  <!--Main layout-->

  <!-- Footer -->
  <footer class="page-footer font-small elegant-color">
		<jsp:include page="footer.jsp"></jsp:include>
  </footer>
  <!-- Footer -->

</body>

</html>