package dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entity.Customer;

public class CustomerDao extends JpaDao<Customer> implements GenericDao<Customer> {
	

	public Customer save(Customer customer) {
		// TODO Auto-generated method stub
		customer.setRegisterDate(new Date());
		return super.create(customer);
	}
	

	@Override
	public List<Customer> listAll() {
		return super.findWithNamedQuery("Customer.listAll");
	}

	@Override
	public void remove(Object id) {
	 super.delete(Customer.class, id); 
		
	}

	@Override
	public Object get(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public Customer findByEmail(String email) {
		List<Customer> list_customer_email = super.findWithNamedQuery("Customer.findByEmail", "email", email);
		
		if (!list_customer_email.isEmpty()) {
			 
			return list_customer_email.get(0);
		}
		return null;
	}
	
	public Customer checkLogin(String email, String password) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("email", email);
		parameters.put("password", password);
		
		List<Customer> result = super.findWithNamedQuery("Customer.checkLogin", parameters);
		
		if (!result.isEmpty()) {
			 
			return result.get(0);
		}
		
		return null;
	}
	

}
