package controller.frontend;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CustomerService;


@WebServlet("/register_save")
public class CustomerSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CustomerSaveServlet() {
        super();
       
    }


    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerService service = new CustomerService(request, response);
		service.resgister_customer(); 
	}

}
