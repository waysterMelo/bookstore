package dao;

import java.util.Date;
import java.util.List;

import entity.Review;

public class ReviewDao extends JpaDao<Review> implements GenericDao<Review>{

	
	@Override
	public Review create(Review entity) {
		entity.setReviewTime(new Date());
		return super.create(entity);
	}
	
	@Override
	public List<Review> listAll() {
		return super.findWithNamedQuery("Review.listAll");
	}

	@Override
	public void remove(Object id) {
	 super.delete(Review.class, id);
		
	}

	@Override
	public Review get(Object id) {
		return super.find(Review.class, id);
	}

	@Override
	public long count() {
		return super.countWithName("Review.count");
	}
	
	
	

}
