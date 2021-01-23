package controller.frontend;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CustomerService;


@WebServlet("/customer_logout")
public class CustmerLogOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public CustmerLogOutServlet(){
    super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	CustomerService customerService = new CustomerService(request, response);
		customerService.logout();
    }

}
