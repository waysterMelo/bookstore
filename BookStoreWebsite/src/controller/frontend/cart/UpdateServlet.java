package controller.frontend.cart;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/update_cart")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UpdateServlet() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] ids = request.getParameterValues("bookId");
		String[] qts = new String[ids.length];
		
		for (int i = 1; i <= qts.length; i++) {
			String Aquantity = request.getParameter("quantity" + i);
			qts[i - 1] = Aquantity;
		}
		int[] bookIds  =  Arrays.stream(ids).mapToInt(Integer::parseInt).toArray();
		int[] quantities = Arrays.stream(qts).mapToInt(Integer::parseInt).toArray();
		
		ShoppingCart shoppingCart = (ShoppingCart) request.getSession().getAttribute("cart");
		shoppingCart.updateCart(bookIds, quantities); 
		
		
		String cartPage = request.getContextPath().concat("/cart");
		response.sendRedirect(cartPage); 
		
	}

}
