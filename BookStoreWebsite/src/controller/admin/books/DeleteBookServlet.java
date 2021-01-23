package controller.admin.books;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BookService;

/**
 * Servlet implementation class DeleteBookServlet
 */
@WebServlet("/admin/delete_book")
public class DeleteBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public DeleteBookServlet() {

    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookService b = new BookService(request, response);
		b.delete();
	}

	

}
