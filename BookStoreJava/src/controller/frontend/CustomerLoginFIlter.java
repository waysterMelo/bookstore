package controller.frontend;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.CategoryDao;
import entity.Category;


@WebFilter("/*")
public class CustomerLoginFIlter implements Filter {

  
	private final CategoryDao categoryDao;
	
    public CustomerLoginFIlter() {
      categoryDao = new CategoryDao();
    }

	
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest http_request = (HttpServletRequest) request;
		HttpSession session = http_request.getSession(false);
		
		String path = http_request.getRequestURI().substring(http_request.getContextPath().length());
		
		if (path.endsWith("/admin/")) {
			chain.doFilter(request, response); 
			return;
		}
		
		boolean loggedIn = session != null && session.getAttribute("logged_customer") != null;
		
		if (!loggedIn && path.endsWith("/view_profile")) {
			String indexPage = "frontend/login_customer.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(indexPage);
			dispatcher.forward(request, response); 
		}else { 
			chain.doFilter(request, response);
			
		}
	
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
