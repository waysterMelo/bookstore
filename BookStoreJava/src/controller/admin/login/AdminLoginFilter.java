package controller.admin.login;

import java.io.IOException;
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


@WebFilter("/admin/*")
public class AdminLoginFilter implements Filter {

   
    public AdminLoginFilter() {
        // TODO Auto-generated constructor stub
    }

	
	public void destroy() {
		// TODO Auto-generated method stub
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest requestHttp = (HttpServletRequest) request;
		
		HttpSession httpSession = requestHttp.getSession(false); 
		
		boolean loggedIn = httpSession != null && httpSession.getAttribute("User_email") != null;
		
		String loginUrl = requestHttp.getContextPath() + "/admin/login";
		
		boolean loginRequest = requestHttp.getRequestURI().equals(loginUrl);
		
		boolean loginPage = requestHttp.getRequestURI().endsWith("login.jsp");
		
		if (loginPage && loggedIn || loginRequest) {
			
			chain.doFilter(request, response);
		}else {
			String path = "login.jsp";
			RequestDispatcher  dispatcher = requestHttp.getRequestDispatcher(path);
			dispatcher.forward(request, response); 
		}
		
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
