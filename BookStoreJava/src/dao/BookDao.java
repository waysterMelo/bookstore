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
			
		return super.findWithNamedQuery("Book.list_all");
	}

	@Override
	public void remove(Object id) {
		 super.delete(Book.class, id);
		
	}

	@Override
	public Book get(Object id) {
		return super.find(Book.class, id);
		
	}
	
	
	public Book findByTitle(String title) {
		
	List<Book> list = super.findWithNamedQuery("Book.find_title", "title", title);
	
	if (!list.isEmpty()) {
		return list.get(0);
	}
		return null; 
	}

	@Override
	public long count() {
	return super.countWithName("Book.find_count");
	} 

}
