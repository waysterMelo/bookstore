package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import entity.Users;

public class UserDao extends JpaDao<Users> implements GenericDao<Users> {
	
		public UserDao( ) {
			
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
			return super.findWithNamedQuery("Users.findAll");
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
			return super.countWithName("Users.countAll");
		}
		
		public Users findByEmail(String email) {
			 List<Users> listUsers = super.findWithNamedQuery("Users.findByEmail", "email", email);
			 if (listUsers != null && listUsers.size() > 0) {
				return listUsers.get(0);
			}
			 return null;
		}
		
		public boolean checkLogin(String email, String senha) {
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("email", email);
			parameters.put("password", senha);
			
			List<Users> result = super.findWithNamedQuery("Users.checkLogin", parameters);
			
			if (result.size() == 1) {
				return true;
			}
			return false;
		}

}
