package dao;

import java.util.Date;
import java.util.List;

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

}
