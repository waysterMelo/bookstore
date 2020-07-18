package com.bookstore.test;

import entity.Users;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Hibernate;

public class userTest {

	public static void main(String[] args) {
        Users user1 = new Users();
        user1.setNome("wayster h");
        user1.setEmail("waystermelo@gmail.com");
        user1.setSenha("deus");

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(user1);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

        System.out.println("A user object was persisted ");

     }

}
