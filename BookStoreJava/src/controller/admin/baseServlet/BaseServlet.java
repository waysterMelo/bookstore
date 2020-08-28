package controller.admin.baseServlet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public abstract class BaseServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	protected static EntityManagerFactory entityManagerFactory;
	protected static EntityManager entityManager;
	
	
	public void init() throws ServletException {
		entityManagerFactory  = Persistence.createEntityManagerFactory("BookStoreWebsite");
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	public void destroy() {
		entityManager.close();
		entityManagerFactory.close(); 
	}

	
	
}
