package dao;

import java.util.Date;
import java.util.List;

import entity.BookOrder;

public class OrderDao extends JpaDao<BookOrder> implements GenericDao<BookOrder>{

	@Override
	public BookOrder create(BookOrder orderBook) {
		orderBook.setOrderDate(new Date());
		orderBook.setPaymentMethod("Cash on delivery");
		orderBook.setStatus("Processing");
		return super.create(orderBook);
	}
	
	@Override
	public List<BookOrder> listAll() {
		return super.findWithNamedQuery("bookOrders.findAll");
	}

	@Override
	public void remove(Object id) {
		super.delete(BookOrder.class, id);
	}

	@Override
	public BookOrder get(Object order_id) {
		return super.find(BookOrder.class, order_id);
	}
 
	@Override
	public long count() {
		return super.countWithName("bookOrders.Count");
	}
	
	@Override
	public BookOrder update(BookOrder book_order) {
		return super.update(book_order);
	}

}
