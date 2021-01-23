package service;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	
	public void showFormRegister() throws ServletException, IOException {
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

	public void show_form_login_client() throws ServletException, IOException {
		
		String path = "frontend/login_customer.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response); 
	}

	public void doLogin() throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Customer customer = customerDao.checkLogin(email, password);
		
		if (customer == null) {
			String message = "Login Failed ";
			request.setAttribute("message", message);
			show_form_login_client(); 
			
		} else {
			
			HttpSession session = request.getSession();

			request.getSession().setAttribute("logged_customer", customer);
		
			
			Object obj_redirect_url = session.getAttribute("redirectUrl");
			
			if (obj_redirect_url != null) {
				String redirect_url = (String)obj_redirect_url;
				session.removeAttribute("redirectUrl"); 
				response.sendRedirect(redirect_url); 
			}else {
			
			
			showPageMyProfile();
			
			}
		}
		
	}


	public void logout() throws ServletException, IOException {
		
	HttpSession session = request.getSession(false); 
	session.removeAttribute("logged_customer");
	String path = "frontend/index.jsp";
	RequestDispatcher dispatcher = request.getRequestDispatcher(path);
	dispatcher.forward(request, response); 	
	
	}


	public void showPageMyProfile() throws ServletException, IOException {
		String path = "frontend/customer_profile.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response); 		
	}


	public void show_form_edit_profiel() throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		session.getAttribute("logged_customer");
		String path = "frontend/edit_my_profile.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		 dispatcher.forward(request, response); 
	}


	public void doUpdate() throws ServletException, IOException {
		Customer customer = (Customer) request.getSession().getAttribute("logged_customer");
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String password = request.getParameter("password");
		
		customer.setFullname(name);
		customer.setEmail(email);
		customer.setAddress(address);
		customer.setCity(city);
		customer.setPassword(password); 
		
		customerDao.update(customer);
		
		String msg = "Successfully Edited :)";
		request.setAttribute("msg", msg);
		
		show_form_edit_profiel(); 
	}


	
}
