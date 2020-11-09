package service;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDao;
import entity.Customer;

public class CustomerService {

	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private CustomerDao customerDao;
	private Customer customer;
	
	public CustomerService(HttpServletRequest request, HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
		customerDao = new CustomerDao();
		customer = new Customer();
	}
	
	
	public void resgister_customer() throws ServletException, IOException {

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
	
		customer.setFullname(name); 
		customer.setEmail(email);
		customer.setPassword(password); 
		customer.setAddress(address);
		customer.setCity(city); 
		
		
		customerDao.save(customer);
		
		String msg = "Register Successfully";
		
		String path = "frontend/register_here.jsp";
		request.setAttribute("messager", msg);
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response); 
	}
	
	
	public void showForm() throws ServletException, IOException {
		String path = "frontend/register_here.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response); 
	}


	public void listAll() throws ServletException, IOException {
		List<Customer> listall = customerDao.listAll();
		
		request.setAttribute("list_customers", listall);
		
		String path = "/admin/view_customers.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response); 
	}


	public void remove_service() throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("customerId"));
		
		customerDao.remove(id);  
		
		String msg = "This Customer was deleted successfully";
		
		List<Customer> listAll = customerDao.listAll();

		request.setAttribute("list_customers", listAll);
		request.setAttribute("message", msg);
		
		
		String path = "/admin/view_customers.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response); 
	}
}
