package controller.frontend;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CategoryDao;
import entity.Category;


@WebFilter("/*")
public class CommonFilter implements Filter {
	
	private static final String[] loginRequiredUrl = {"/view_profile","/edit_profile","/update_profile","write_review"};

	private final CategoryDao categoryDao;
	
    public CommonFilter() {
    	categoryDao = new CategoryDao();
    }

	
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		HttpServletRequest httpRequest = (HttpServletRequest)request;

		String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
		
		if (!path.endsWith("/admin")) {
			List<Category> categoryList = categoryDao.listAll();
			httpRequest.setAttribute("name_category", categoryList);
		}
		
		chain.doFilter(request, response); 
		
    	
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
