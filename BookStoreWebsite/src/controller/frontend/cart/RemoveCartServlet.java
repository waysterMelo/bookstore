package controller.frontend.cart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Book;

@WebServlet("/remove_from_cart")
public class RemoveCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RemoveCartServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Integer id = Integer.parseInt(request.getParameter("bookId"));	
		
		Object cartObj = request.getSession().getAttribute("cart");
		
		ShoppingCart shoppingCart = (ShoppingCart) cartObj;
		
		shoppingCart.remove_item(new Book(id)); 	
		
		String page = request.getContextPath().concat("/cart");
		response.sendRedirect(page); 
	}
	


}
