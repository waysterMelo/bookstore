package test.category;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.test.BaseDaoTest;

import dao.CategoryDao;
import entity.Category;

public class categoryDaoTest extends BaseDaoTest {
	
	
	private static CategoryDao categorydao;

	@BeforeClass
	public static void init() throws Exception{
		BaseDaoTest.setupInitClass(); 
		 categorydao = new CategoryDao(entityManager);
	}
	

	
//	@Test
//	public void create() {
//		Category cat = new Category();
//		cat.setNameCategory("Test");
//		
//		
//		cat = categorydao.create(cat);
//		
//		assertTrue(cat != null && cat.getCategoryId() > 0);
//	}
//	
	
	
	
//	@Test
//	public void updateTest() throws Exception{
//		Category cat = new  Category();
//		cat.setCategoryId(11);
//		cat.setNameCategory("Test");
//		
//		Category category = categorydao.update(cat);
//		
//		assertEquals(cat.getNameCategory(), category.getNameCategory());
// 	}
	
	
	
//	@Test
//	public void findid() {
//		int id = 11;
//		Category cat =  categorydao.get(id);
//			
//		assertNotNull(cat); 	
//		 
//	}
	
	
	
//	@Test
//	public void deleteTest() {
//		Integer id =  13;
//		categorydao.remove(id); 
//		Category cat = categorydao.get(id);
//		assertNull(cat); 
//	}
	
	
	
//	@Test
//	public void listAll() {
//		List<Category> list = categorydao.listAll();
//		
//		for (Category category : list) {
//			System.out.println(category.getNameCategory());
//		}
//		
//		assertTrue(list.size() > 0);
//	}
	
//    
//    @Test
//    public void count() {
//    	
//     long categories = categorydao.count();
//     
//     assertEquals(3, categories);
//    	 
//    }
//    
//	
	
	
	
	
	@AfterClass
	public static void setupAfterClass() throws Exception {
		BaseDaoTest.setupAfterClass(); 
	}



}
