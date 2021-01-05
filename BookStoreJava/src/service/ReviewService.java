package service;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;
import dao.ReviewDao;
import entity.Book;
import entity.Customer;
import entity.Review;

public class ReviewService {
	
	
	private ReviewDao reviewDao;
	private HttpServletRequest httpServletRequest;
	private HttpServletResponse httpServletResponse;
	
	
	public ReviewService(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		super();
		this.httpServletRequest = httpServletRequest;
		this.httpServletResponse = httpServletResponse;
		this.reviewDao = new ReviewDao();
	}
	
	public void list_all(String msg) throws ServletException, IOException {
		List<Review> list = reviewDao.listAll();
		
		httpServletRequest.setAttribute("listAllReviews", list);
		
		if (msg != null) {
			httpServletRequest.setAttribute("message", msg);
		}
		
		String path = "/admin/review_list.jsp";
		RequestDispatcher dispatcher = httpServletRequest.getRequestDispatcher(path);
		dispatcher.forward(httpServletRequest, httpServletResponse);
	}
	
	public void list_all() throws ServletException, IOException {
		list_all(null); 
		
	}

	public void updatedReviewForm() throws ServletException, IOException {

		Integer id  = Integer.parseInt(httpServletRequest.getParameter("id"));
		Review review = reviewDao.get(id);
		
		httpServletRequest.setAttribute("review", review);
		
		String path = "admin/updated_review_form.jsp";
		RequestDispatcher dispatcher = httpServletRequest.getRequestDispatcher(path);
		dispatcher.forward(httpServletRequest, httpServletResponse); 
		
	}

	public void DoUpdate() throws ServletException, IOException {
		Integer id = Integer.parseInt(httpServletRequest.getParameter("Id"));
		Integer rating = Integer.parseInt(httpServletRequest.getParameter("rating"));
		String headline = httpServletRequest.getParameter("headline");
		String comment = httpServletRequest.getParameter("comments");
	
		Review review = reviewDao.get(id);
		
		review.setRating(rating);
		review.setComment(comment);
		review.setHeadline(headline); 
		
		reviewDao.update(review);
		
		String msg = "Review has been updated";
		
		list_all(msg); 
		
		
	}

	public void remove_review() throws ServletException, IOException {
	
		Integer id = Integer.parseInt(httpServletRequest.getParameter("id"));
				
		reviewDao.delete(Review.class, id);
		
		String msg = "Review was deleted successfully";
		
		list_all(msg);
		
	}

	public void showrForm() throws ServletException, IOException {
		Integer book_id = Integer.parseInt(httpServletRequest.getParameter("bookId"));
		BookDao dao = new BookDao();
		Book book = dao.get(book_id);
		
		httpServletRequest.setAttribute("book", book);
		
		String path = "frontend/write_a_review.jsp";
		RequestDispatcher dispatcher = httpServletRequest.getRequestDispatcher(path);
	 	dispatcher.forward(httpServletRequest, httpServletResponse); 	
	}

	public void submit_review() throws ServletException, IOException {
		Integer id = Integer.parseInt(httpServletRequest.getParameter("bookId"));
		Integer rating = Integer.parseInt(httpServletRequest.getParameter("rating"));
		String headline = httpServletRequest.getParameter("headline");
		String comment = httpServletRequest.getParameter("comment");
		
		Review review = new Review();
		review.setHeadline(headline);
		review.setComment(comment);
		review.setRating(rating); 
		
		Book book = new Book();
		book.setBookId(id);
		review.setBook(book); 
		
		Customer customer = (Customer)httpServletRequest.getSession().getAttribute("logged_customer");
		review.setCustomer(customer); 
		
		reviewDao.create(review);
		
		
		String path = "frontend/write_review_done.jsp";
		RequestDispatcher dispatcher = httpServletRequest.getRequestDispatcher(path);
		dispatcher.forward(httpServletRequest, httpServletResponse);
	}

}
