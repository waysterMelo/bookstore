package controller.admin.books;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.admin.baseServlet.BaseServlet;
import dao.BookDao;
import entity.Book;
import service.BookService;


@WebServlet("/admin/books/create_book")
public class CreateBookServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
   
    public CreateBookServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		BookService bookService = new BookService(entityManager, request, response);
		bookService.showNewForm();
	}

	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String title = request.getParameter("title");
//		String author = request.getParameter("author");
//		Integer isbn = Integer.parseInt(request.getParameter("isbn"));
//		Float price = Float.parseFloat( request.getParameter("price") );
//		String desc = request.getParameter("desc");
//		String dateP = request.getParameter("dateP");
//		String image = request.getParameter("image");
//		
////		Book new_book = new Book(category, title, author, desc, isbn, image, price, dateP, lastUpdateTime);
//	}

}
