package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.UserDao;
import entity.Users;

public class UserService {
	
	 EntityManagerFactory entityManagerFactory;
	 EntityManager entityManager;
	 UserDao userdao;
	
	public UserService() {
		 entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		 entityManager = entityManagerFactory.createEntityManager();
		 userdao = new UserDao(entityManager);
	}
	
	public List<Users> list(){
		List<Users> lista = userdao.listAll();
		return lista;
	}

}
