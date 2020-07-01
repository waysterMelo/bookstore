/**
 * 
 */
package dao;

import java.util.List;

/**
 * @author Wayster
 *
 */
public interface GenericDao<E> {
	
	public E create(E entity);
	
	public E update(E entity);
	
	public List<E> listAll();
	
	public void remove(Object id);
	
	public Object get(Object id);
	
	public long count();
	
	
	
}
