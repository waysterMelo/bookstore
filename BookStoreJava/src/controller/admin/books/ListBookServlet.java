package controller.admin.books;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.admin.baseServlet.BaseServlet;
import service.BookService;


@WebServlet("/admin/list_books")
public class ListBookServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ListBookServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	BookService bookService = new BookService(entityManager, request, response);
	bookService.list_books(null); 	
	
	}


}
