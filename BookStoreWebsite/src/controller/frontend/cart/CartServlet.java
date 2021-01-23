package controller.frontend.cart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;
import entity.Book;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/add_to_cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public CartServlet() {
        super();
    
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt( request.getParameter("bookId") );
		
		Object cartObject = request.getSession().getAttribute("cart");
		
		ShoppingCart shoppingCart = null;
		
		if (cartObject != null && cartObject instanceof ShoppingCart) {
			shoppingCart = (ShoppingCart) cartObject;
			
		}else {
			shoppingCart = new ShoppingCart();
			request.getSession().setAttribute("cart", shoppingCart);
		}
		
		BookDao bookDao = new BookDao();
		Book b = bookDao.get(id);
		
		shoppingCart.addItem(b);
		
		String redirectUrl = request.getContextPath().concat("/cart");
		response.sendRedirect(redirectUrl); 
	}

}
