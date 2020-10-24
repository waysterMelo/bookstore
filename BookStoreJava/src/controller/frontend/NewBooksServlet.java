package controller.frontend;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BookService;


@WebServlet("/new_books")
public class NewBooksServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
       
 
    public NewBooksServlet() {
      
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookService bookService = new BookService(request, response);
		bookService.last_new_books();
	}



}
