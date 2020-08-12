package service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import entity.Users;

public class UserService {
	
	 EntityManagerFactory entityManagerFactory;
	 EntityManager entityManager;
	 UserDao userdao;
	 HttpServletResponse response;
	 HttpServletRequest request;
	
	public UserService(HttpServletRequest request, HttpServletResponse response) {
		 entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		 entityManager = entityManagerFactory.createEntityManager();
		 userdao = new UserDao(entityManager);
		 this.request = request;
		 this.response = response;
	}
	
	public void list(String message) throws ServletException, IOException{
		List<Users> lista = userdao.listAll();

		request.setAttribute("listUsers", lista); 

		
		if (message != null) {
			request.setAttribute("message", message);
		}
		
		String path = "user_list.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response); 
	}
	
	public void createUser() throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		
		Users users = userdao.findByEmail(email);
		
		if (users != null) {
			String msg = "Could not create a user with email (" + email + "), already exists";
			request.setAttribute("message", msg);
			RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
			dispatcher.forward(request, response); 
			
		}else {
			Users newUsers = new Users(name, password, email);
			userdao.create(newUsers);
		}
		 
		
	}

	
	public void list() throws ServletException, IOException{
		
		list(null); 
	}
}
