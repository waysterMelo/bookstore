package dao;

import java.util.List;

import javax.persistence.EntityManager;

import entity.Category;

public class CategoryDao extends JpaDao<Category> implements GenericDao<Category> {
	
	public CategoryDao() {
	
	}

	@Override
	public Category create(Category cat) {
		return super.create(cat);
	}

	@Override
	public Category update(Category cat) {
		return super.update(cat);
	}

	@Override
	public List<Category> listAll() {
		return super.findWithNamedQuery("Category.findAll");
	}

	@Override
	public void remove(Object id) {
		 super.delete(Category.class, id);
		
		
	}

	@Override
	public Category get(Object id) {
		return super.find(Category.class, id);
	}

	@Override
	public long count() {
		return super.countWithName("Category.count");
	}

	
	public Category findByNameCategory(String name) {
		List<Category> list = super.findWithNamedQuery("Category.findByName", "name", name);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
	
	public List<Category> nameById(int id) {
		return super.findWithNamedQuery("Category.find_name_by_id", "cat_id", id); 
	}

}
