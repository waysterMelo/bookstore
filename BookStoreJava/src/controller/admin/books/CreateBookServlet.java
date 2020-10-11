package controller.admin.books;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.admin.baseServlet.BaseServlet;
import dao.BookDao;
import entity.Book;
import service.BookService;


@WebServlet("/admin/create_book")
@MultipartConfig(
		fileSizeThreshold = 1024 * 10,
		maxFileSize = 1024 * 300,
		maxRequestSize = 1024 * 1024
		)
public class CreateBookServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
   
    public CreateBookServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		BookService bookService = new BookService(entityManager, request, response);
		bookService.showNewForm();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookService book_services = new BookService(entityManager, request, response);
		book_services.create();

}
}
