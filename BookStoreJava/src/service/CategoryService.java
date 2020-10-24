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

import dao.CategoryDao;
import entity.Category;

public class CategoryService {
	
	 HttpServletRequest request;
	 HttpServletResponse response;
	 CategoryDao categoryDao;
	 
	 
	public CategoryService(HttpServletRequest request, HttpServletResponse response) {
		categoryDao = new CategoryDao();
		this.request = request;
		this.response = response;
	}
	
	
	public void listAll(String message) throws ServletException, IOException{
		
		List<Category> cat_list = categoryDao.listAll();
		request.setAttribute("list_category", cat_list);
		
		if (message != null) {
			request.setAttribute("message", message);
		}
		
		String path = "list_category.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);	
		
	}
	  	
	public void create() throws ServletException, IOException {
		
		String name = request.getParameter("name");
		
		Category results = categoryDao.findByNameCategory(name);
		
		if (results != null) {
			String msg = "Could not save this category , already exists";
			request.setAttribute("message", msg);
			String path = "message.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response); 
		}else {
			Category category = new Category(name, null);
			categoryDao.create(category);
			String msg =  "Category was created successfully";
			listAll(msg); 
		}
		
		
	}
 	
	public void editcategory() throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Category category = categoryDao.get(id);
		
		
		String path = "create_category.jsp";
		request.setAttribute("category", category);		
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response); 
	}

	public void update() throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("category_id"));
		String name = request.getParameter("name");
		
		Category category = new Category(id, name, null);
		categoryDao.update(category); 
		String msg = "Category was updated";
		listAll(msg);
	}

	public void delete() throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("category_id"));
		categoryDao.delete(Category.class, id);
		String msg = "Category deleted successfully";
		listAll(msg);
	}
}
