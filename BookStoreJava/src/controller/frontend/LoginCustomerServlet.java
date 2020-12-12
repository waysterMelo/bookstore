package controller.frontend;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CustomerService;


@WebServlet("/login_customer")
public class LoginCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginCustomerServlet() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerService customerService = new CustomerService(request, response);
		customerService.show_form_login_client(); 
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CustomerService customerService = new CustomerService(req, resp);
		customerService.doLogin(); 
	}
}
