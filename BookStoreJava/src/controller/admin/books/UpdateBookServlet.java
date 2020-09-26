package controller.admin.books;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.admin.baseServlet.BaseServlet;
import service.BookService;


@WebServlet("/admin/books/edit_book")
public class UpdateBookServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
   
    public UpdateBookServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	BookService book_service = new BookService(entityManager, request, response);
	book_service.edit_book(); 
		
	
	}
}
