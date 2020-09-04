package com.bookstore.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;

public class BaseDaoTest {
	
	protected static EntityManagerFactory entityManagerFactory;
	protected static EntityManager entityManager;
	
	
	
	@BeforeClass
	public static void setupInitClass() throws Exception{
		entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		entityManager = entityManagerFactory.createEntityManager();
		
	}
	
	
	@AfterClass
	public static void setupAfterClass() throws Exception {
		entityManager.close(); 
		entityManagerFactory.close();
		
	}

}
