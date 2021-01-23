package controller.frontend.cart;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Book;

@WebServlet("/cart")
public class CartHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public CartHomeServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Object cartSession = request.getSession().getAttribute("cart");
		
		if (cartSession == null) {
			 ShoppingCart cart = new ShoppingCart();
			 request.getSession().setAttribute("cart", cart);
		}

		String path = "frontend/cart.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response); 
	}

}
