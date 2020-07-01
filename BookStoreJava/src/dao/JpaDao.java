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
	
}
