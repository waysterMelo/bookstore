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

import java.util.Iterator;
import java.util.List;

public class UserDaoTest extends BaseDaoTest {


    private static UserDao userDao;

    @BeforeClass
    public static void setupClass() throws Exception{
    	BaseDaoTest.setupInitClass(); 
         userDao = new UserDao(entityManager);
    }


//    @Test
//    public void create() {
//        Users user1 = new Users();
//        user1.setNome("Maria M");
//        user1.setEmail("maria@gmail.com");
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
    
//    @Test
//    public void testFindId() {
//    	Integer id = 19;
//    	Users user = userDao.get(id);
//    	String email = user.getEmail();
//    	System.out.println(email);
//    	assertNotNull(user); 
//    	
//    }
    
//    @Test
//    public void testDelete() {
//    	Integer id_user = 20;
//    	Users user = userDao.get(id_user);
//
//    	userDao.remove(id_user);
//    	    	
//    	assertNull(user);
//    	
//    }
    
    
//    @Test
//    public void testFindAll() {
//    	List<Users> list = userDao.listAll();
//    	for (Users users : list) {
//			System.out.println(users.getEmail());
//		}
//    	assertTrue(list.size() > 0);
//    }
    
    
//    @Test
//    public void teste() {
//    	long totalUsers = userDao.count();
//    	assertEquals(1, totalUsers);
//    }
    
    
//    @Test
//    public void testFindbyEmail() {
//    	String email= "waystermelo@gmail.com";
//    	Users users = userDao.findByEmail(email);
//    	
//    	assertNotNull(users); 
//    	
//    }
//    


    @AfterClass
    public static void afterClass() throws Exception{
      BaseDaoTest.setupAfterClass(); 
    }
}