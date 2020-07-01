package com.bookstore.test;

import dao.UserDao;
import entity.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import static org.junit.Assert.*;

public class UserDaoTest {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    private static UserDao userDao;

    @BeforeClass
    public static void setupClass(){
    entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
    entityManager = entityManagerFactory.createEntityManager();
         userDao = new UserDao(entityManager);
    }


//    @Test
//    public void create() {
//        Users user1 = new Users();  user1.setNome("junit test 2");
//        user1.setEmail("junit@gmail.com");
//        user1.setSenha("deus");
//
//        user1 = userDao.create(user1);
//        assertTrue(user1.getUserId() > 0); 
//    }
//
//    @Test(expected = PersistenceException.class)
//    public void testeFields(){
//        Users user1 = new Users();
//        user1 = userDao.create(user1);
//    }

//    @Test
//    public void update(){
//        Users user = new Users();
//        user.setUserId(1);
//        user.setNome("Wayster H Melo");
//        user.setEmail("null");
//        user.setSenha("1234");
//        user = userDao.update(user);
//        String expected = "1234";
//        String actual = user.getSenha();
//
//        assertEquals(expected, actual);
//    }

    @AfterClass
    public static void afterClass(){
        entityManager.close();
        entityManagerFactory.close();
    }
}