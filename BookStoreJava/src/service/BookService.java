package service;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

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
	
	public void list_books(String msg) throws ServletException, IOException{
		List<Book> list = bookDao.listAll();
		request.setAttribute("list_books", list);
		request.setAttribute("message", msg);
		String path = "/admin/Book_list.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response); 
	}

	public void showNewForm() throws ServletException, IOException {
		List<Category> listCategory = categoryDao.listAll();
		request.setAttribute("category", listCategory);
		
		String path_category = "/admin/create_books.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path_category);
		dispatcher.forward(request, response); 
		
	}
	
	public void create() throws ServletException, IOException{
		
		Book new_book = new Book();
		readBookFields(new_book); 
		
		Book bookcreate = bookDao.create(new_book);
		
		if (bookcreate.getBookId() >  0) {
			String msg = "A new book was inserted successfully";
			
			list_books(msg);
			
		}
						
	}

	public void edit_book() throws ServletException, IOException {
		Integer id_book = Integer.parseInt(request.getParameter("id"));
		BookDao dao = new BookDao(entityManager);
		Book book = dao.get(id_book);
		
		List<Category> lista = categoryDao.listAll();
		
		request.setAttribute("book", book);
		request.setAttribute("category", lista);
		String path = "/admin/create_books.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response); 
	}

	public void update() throws IOException, ServletException {
		Integer bookId = Integer.parseInt(request.getParameter("bookid"));
		String title = request.getParameter("title");
	
		Book book = bookDao.get(bookId);
		Book bookByTitle = bookDao.findByTitle(title);
		
		
		if (!book.equals(bookByTitle)) {
			String msg = "Could not update the book because existing already another with the same title";
			list_books(msg); 
			return;
		}
		
		readBookFields(book);
		bookDao.update(book);
		String msg = "Book has been updated successfully";
		list_books(msg); 
		
	}
	
	public void readBookFields(Book b) throws IOException, ServletException {
		
		Integer id_cate = Integer.parseInt(request.getParameter("category"));
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String description = request.getParameter("desc");
		String isbn = request.getParameter("isbn");
		Float price = Float.parseFloat(request.getParameter("price"));
		String publish = request.getParameter("dateP");
		Category cat = categoryDao.get(id_cate);
		
		b.setTitle(title);
		b.setAuthor(author);
		b.setDescription(description);
		b.setIsbn(isbn);
		b.setPrice(price);
		b.setPublishDate(publish); 
		b.setCategory(cat);
		
		Part part = request.getPart("image");
		if (part != null && part.getSize() > 0) {
			long size = part.getSize();
			byte[] image_bytes = new byte[(int) size];
			
			InputStream inputStream = part.getInputStream();
			inputStream.read(image_bytes);
			inputStream.close(); 

			b.setImage(image_bytes); 
			
		}
		
	}

	public void delete() throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		bookDao.delete(Book.class, id); 
		String msg = "Book has been deleted successfully";
		list_books(msg); 
	}

	public void list_by_category() throws ServletException, IOException {
	Integer id = Integer.parseInt(request.getParameter("id"));
	List<Book> list_book = bookDao.listByCategory(id);
	List<Category> name = categoryDao.nameById(id);
			
	request.setAttribute("list_books", list_book);
	request.setAttribute("name_category", name);
	
	
	String path = "frontend/books_by_category.jsp";
	RequestDispatcher dispatcher = request.getRequestDispatcher(path);
	dispatcher.forward(request, response); 

		
	}

	public void last_new_books() throws ServletException, IOException {
		List<Book> lista = bookDao.lastBooksDao();
		request.setAttribute("last_books", lista);
	

		
		String path = "frontend/new_books.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response); 
	}

	public void view_details() throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Book book = bookDao.get(id);
		List<Category> list_category = categoryDao.listAll();
		
		request.setAttribute("listCategory", list_category);
		request.setAttribute("bookId", book);
		
		
		String path = "frontend/book_detail.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response); 
	}

	public void search() throws ServletException, IOException {
	String keyword = request.getParameter("keyword");
		List<Book> lista = null;
		
		if (keyword.equals("")) {
			lista = bookDao.listAll();
		}else {
			lista = bookDao.search(keyword);
		}
		request.setAttribute("search", lista);
		
		
		String path = "frontend/Search_result.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response); 
	}
	
	
	
}














