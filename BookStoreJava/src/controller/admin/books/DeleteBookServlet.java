package controller.admin.books;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.admin.baseServlet.BaseServlet;
import service.BookService;

/**
 * Servlet implementation class DeleteBookServlet
 */
@WebServlet("/admin/books/delete_book")
public class DeleteBookServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
 
    public DeleteBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BookService b = new BookService(entityManager, request, response);
		b.delete();
	}

	

}
