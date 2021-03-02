package service;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDao;
import entity.BookOrder;

public class OrdersServices {

	OrderDao orderDao;
	HttpServletRequest request;
	HttpServletResponse response;
	
	public OrdersServices(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		orderDao = new OrderDao();
	}
	
	public void ListOrders() throws ServletException, IOException {
		List<BookOrder> list_orders = orderDao.listAll();
		request.setAttribute("list_orders", list_orders);
		
		String path = "/admin/list_orders.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response); 
	}
	
}
