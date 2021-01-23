package controller.admin.books;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BookService;


@WebServlet("/admin/edit_book")
public class UpdateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public UpdateBookServlet() {
        super();
    }

	
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	BookService book_service = new BookService(request, response);
	book_service.edit_book(); 
	}
}
