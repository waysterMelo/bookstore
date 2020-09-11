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

import org.hibernate.Session;


@WebFilter("/admin/*")
public class AdminFilter implements Filter {

   
    public AdminFilter() {
    }


	public void destroy() {
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
			HttpServletRequest requestHttp = (HttpServletRequest) request;
			HttpSession httpSession = requestHttp.getSession(false);
			boolean loggedIn =  httpSession != null && httpSession.getAttribute("User_email") != null;
			
			String loginUrl = requestHttp.getContextPath() + "/admin/login";
			boolean login_request = requestHttp.getRequestURI().equals(loginUrl);
			boolean login_page = requestHttp.getRequestURI().endsWith("login.jsp");
			
			if (loggedIn && (login_request || login_page)) {
				String path = "/admin/";
				RequestDispatcher dispatcher = requestHttp.getRequestDispatcher(path);
				dispatcher.forward(request, response); 
			
				
			}else if (loggedIn || login_request) {
				chain.doFilter(request, response); 
				
			}else {
				String path = "login.jsp";
				RequestDispatcher dispatcher = requestHttp.getRequestDispatcher(path);
				dispatcher.forward(request, response); 
				System.out.println(login_page);
			}
			
	
	}


	public void init(FilterConfig fConfig) throws ServletException {
	}

}
