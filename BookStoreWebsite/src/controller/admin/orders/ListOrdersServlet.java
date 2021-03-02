package controller.admin.orders;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.OrdersServices;


@WebServlet("/admin/list_orders")
public class ListOrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ListOrdersServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrdersServices ordersServices = new OrdersServices(request, response);
		ordersServices.ListOrders();
		
	}

	

}
