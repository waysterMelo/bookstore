package controller.admin.users;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;

@WebServlet("/admin/list_users")
public class ListUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ListUserServlet() {
    }

	
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService u = new UserService(request, response); 
		u.list(); 	
		
	}

}
