package controller.frontend;

import java.io.IOException;
import java.util.Iterator;
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
	
	private static final String[] LoginRequiredURLS = {
			"/view_profile", "/edit_profile", "/update_profile", "/write_review"};

  
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
		
		String requestURLS = http_request.getRequestURI().toString();
		
		if (!loggedIn && isLoginRequired(requestURLS)) {
			
			String queryString = http_request.getQueryString();
			String redirect_url = requestURLS;
			
			if (queryString != null) {
				
				redirect_url = redirect_url.concat("?").concat(queryString);
			}
			
			session.setAttribute("redirectUrl", redirect_url); 
			
			String indexPage = "frontend/login_customer.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(indexPage);
			dispatcher.forward(request, response); 
		}else { 
			chain.doFilter(request, response);
			
		}
	
	}
	
	private boolean isLoginRequired(String RequestUrls) {
		for (String loginrequiredurls : LoginRequiredURLS) {
			if (RequestUrls.contains(loginrequiredurls)) {
				return true;
			}
		}
		return false;
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
