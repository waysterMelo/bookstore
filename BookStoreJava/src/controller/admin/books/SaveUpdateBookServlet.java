package controller.admin.books;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BookService;


@WebServlet("/admin/update")
@MultipartConfig(
		fileSizeThreshold = 1024 * 10,
		maxFileSize = 1024 * 300,
		maxRequestSize = 1024 * 1024
		)
public class SaveUpdateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SaveUpdateBookServlet() {
        super();
        
    }

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookService bookService = new BookService(request, response);
		bookService.update(); 
	}

}
