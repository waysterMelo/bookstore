package dao;

import java.util.List;

import javax.persistence.EntityManager;

import entity.Users;

public class UserDao extends JpaDao<Users> implements GenericDao<Users> {
	
		public UserDao(EntityManager entityManager) {
			// TODO Auto-generated constructor stub
			super(entityManager);
		}
		
		public Users create(Users user) {
			return super.create(user);
		}

		@Override
		public Users update(Users entity) {
			return super.update(entity);
		}

		@Override
		public List<Users> listAll() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void remove(Object id) {
			super.delete(Users.class, id);
		}

		@Override
		public Users get(Object user_id) {
			return super.find(Users.class, user_id);
			
		}

		@Override
		public long count() {
			// TODO Auto-generated method stub
			return 0;
		}

}
