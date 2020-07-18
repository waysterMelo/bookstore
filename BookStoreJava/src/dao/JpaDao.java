package dao;

import javax.persistence.EntityManager;

public class JpaDao<E> {

	protected EntityManager entityManager;
	
	public JpaDao(EntityManager entityManager) {
		// TODO Auto-generated constructor stub
		super();	
		this.entityManager = entityManager;
	}
	
	public E create(E entity) {
		entityManager.getTransaction().begin();
		entityManager.persist(entity);
		entityManager.flush(); 
		entityManager.refresh(entity); 
		entityManager.getTransaction().commit(); 
		return entity;
	}
	
	public E update(E entity) {
		entityManager.getTransaction().begin();
		entity = entityManager.merge(entity);
		entityManager.getTransaction().commit(); 
		return entity;
	}
	
	public E find(Class<E> type, Object id) {
		E entity = entityManager.find(type, id);
		entityManager.refresh(entity);
		return entity;
	}
	
	public void delete(Class<E> type, Object id) {
		entityManager.getTransaction().begin();
		Object reference = entityManager.getReference(type, id);
		entityManager.remove(reference);
		entityManager.getTransaction().commit(); 
	}
	
}
