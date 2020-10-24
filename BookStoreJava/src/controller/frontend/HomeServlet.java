package controller.frontend;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDao;
import entity.Category;


@WebServlet("")
public class HomeServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	
	
    public HomeServlet() {
    
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		CategoryDao categoryDao = new CategoryDao();
		List<Category> cat =  categoryDao.listAll();
		request.setAttribute("categories", cat);
		
		String page = "frontend/index.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);	
		dispatcher.forward(request, response);	

	}

}
