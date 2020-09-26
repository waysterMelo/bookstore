package controller.admin.books;

import controller.admin.baseServlet.BaseServlet;
import service.BookService;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewBooksCategory
 */
@WebServlet("/view_category")
public class ViewBooksCategory extends BaseServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ViewBooksCategory() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookService bookService = new BookService(entityManager, request, response);
		bookService.list_by_category(); 
		
	}



}
