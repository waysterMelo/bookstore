package dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import entity.Book;

public class BookDao extends JpaDao<Book> implements GenericDao<Book> {

	public BookDao(EntityManager entityManager) {
		super(entityManager);
		
	}
	
	@Override
	public Book create(Book book) {
		book.setLastUpdateTime(new Date());
		return super.create(book);
	}
	
	@Override
	public Book update(Book entity) {
		entity.setLastUpdateTime(new Date());
		return super.update(entity);
	}

	@Override
	public List<Book> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Object id) {
		 super.delete(Book.class, id);
		
	}

	@Override
	public Object get(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

}
