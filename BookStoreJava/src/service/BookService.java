package service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;
import dao.CategoryDao;
import entity.Book;
import entity.Category;

public class BookService {
	
	private EntityManager entityManager;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private BookDao bookDao;
	private CategoryDao categoryDao;

	
	public BookService(EntityManager entityManager,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated constructor stub
		super();
		this.entityManager = entityManager;
		this.request = request;
		this.response = response;
		bookDao = new BookDao(entityManager);
		categoryDao = new CategoryDao(entityManager);
		
	}
	
	public void list_books() throws ServletException, IOException{
		List<Book> list = bookDao.listAll();
		request.setAttribute("list_books", list);
		
		String path = "/admin/books/Book_list.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response); 
	}

	public void showNewForm() throws ServletException, IOException {
		List<Category> listCategory = categoryDao.listAll();
		request.setAttribute("category", listCategory);
		
		String path_category = "/admin/books/create_books.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path_category);
		dispatcher.forward(request, response); 
		
		
	}
	
	
}
