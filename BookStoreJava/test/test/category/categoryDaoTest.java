package test.category;



import org.junit.AfterClass;
import org.junit.BeforeClass;
import dao.CategoryDao;

public class categoryDaoTest {
	
	
	private static CategoryDao categorydao;

	@BeforeClass
	public static void init() throws Exception{
		 categorydao = new CategoryDao();
	}
	
	
	@AfterClass
	public void afterClass() {
		categorydao.close(); 
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
	

}
