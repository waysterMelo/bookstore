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

import dao.CategoryDao;
import entity.Category;


@WebFilter("/*")
public class CommonFilter implements Filter {

	private final CategoryDao categoryDao;
	
    public CommonFilter() {
    	categoryDao = new CategoryDao();
    }

	
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		HttpServletRequest Http_request = (HttpServletRequest) request;
    	String path = Http_request.getRequestURI().substring(Http_request.getContextPath().length());
    	
    	if (!path.startsWith("/admin/")) {
    		List<Category> list_category = categoryDao.listAll();
        	request.setAttribute("categories", list_category);
		}
    	
    	
    	
		chain.doFilter(request, response); 
    	
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
