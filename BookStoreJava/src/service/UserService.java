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
	
	public UserService(HttpServletRequest request, HttpServletResponse response, EntityManager entityManager) {
		 entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		 entityManager = entityManagerFactory.createEntityManager();
		 userdao = new UserDao(entityManager);
		 this.request = request;
		 this.response = response;
		 this.entityManager = entityManager;
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
			String msg =  "User was created successfully";
			list(msg); 
			
		}
		 
		 
	}
	
	public void list() throws ServletException, IOException{
		
		list(null); 
	}

	
//	shows form with data to updated
	public void edit_user() throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("id"));
		Users user = userdao.get(userId);
	
		String path = "user_form.jsp";
		request.setAttribute("user", user);
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response); 
		
	}

	public void updateUser() throws ServletException, IOException {
		
		int userId  = Integer.parseInt(request.getParameter("userId"));
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String senha = request.getParameter("password");
		
		
		
		Users users = new Users(userId, name, senha, email);
		userdao.update(users);
		
		String msg = "User has updated successfully";
		list(msg);  
				
	}
	
	public void deleteUser() throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("user_id"));
		userdao.remove(userId); 
		String msg = "User has been deleted successfully";
		list(msg); 
		
	}
	
	public void login() throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		boolean user = userdao.checkLogin(email, password);
		
		if (user) {
			request.getSession().setAttribute("User_email", email);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/");
			dispatcher.forward(request, response); 
			
		}else {
			String message = "Login Failed";
			request.setAttribute("message", message);
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response); 
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
} 
