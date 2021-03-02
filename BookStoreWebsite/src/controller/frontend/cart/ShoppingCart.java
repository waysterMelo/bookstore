package controller.frontend.cart;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import entity.Book;

public class ShoppingCart {

	private Map<Book, Integer> cart = new HashMap<Book, Integer>();
	
	
	public void addItem(Book book) {
		if (cart.containsKey(book)) {
			Integer qtd = cart.get(book)+1;
		}else {
			cart.put(book, 1);
		}
	}
	
	public void remove_item(Book book) {
		cart.remove(book);
	}
	
	public int getTotalQtd() {
		int total = 0;
		
		Iterator<Book> iterator = cart.keySet().iterator();
		
		while (iterator.hasNext()) {
		Book b = iterator.next();
			Integer qtd = cart.get(b);
			double subTotal = b.getPrice() * qtd;
			total += subTotal;
		}
		return total;
		
	}
	
	public Map<Book, Integer> getItems(){
		return this.cart;
	}
	
	public void clear() {
		cart.clear(); 
	}

	public int getTotalItems() {
		return cart.size();
	} 

	
	public void updateCart(int[] bookIds, int[] qtds) {
		for(int i = 0; i < bookIds.length; i++) {
			Book b = new Book(bookIds[i]);
			Integer value = qtds[i];
			cart.put(b, value);
		}
	}
	
}
