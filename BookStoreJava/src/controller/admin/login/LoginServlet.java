package controller.admin.login;

import java.io.IOException;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.admin.baseServlet.BaseServlet;
import dao.UserDao;
import service.UserService;


@WebServlet("/admin/login")
public class LoginServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

       
  

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String email = req.getParameter("email");
		String senha = req.getParameter("password");
		
		UserService service = new UserService(req, resp, entityManager); 
		service.login();  
	}

@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	String path = "login.jsp";
	RequestDispatcher dispatcher = request.getRequestDispatcher(path);
	dispatcher.forward(request, response);
	
}
	

}
