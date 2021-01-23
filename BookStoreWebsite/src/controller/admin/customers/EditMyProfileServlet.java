package controller.admin.customers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CustomerService;


@WebServlet("/edit_profile")
public class EditMyProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public EditMyProfileServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerService service = new CustomerService(request, response);
		service.show_form_edit_profiel();
	}

}
