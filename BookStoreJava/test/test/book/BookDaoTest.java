package test.book;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.test.BaseDaoTest;

import dao.BookDao;
import entity.Book;
import entity.Category;

public class BookDaoTest extends BaseDaoTest {
	
	private static BookDao bookdao;
	
	@BeforeClass
	public static void setupInitClass() throws Exception {
		BaseDaoTest.setupInitClass(); 
		bookdao = new BookDao(entityManager);
	}
	
	
//	@Test
//	public void create() throws ParseException, IOException {
//		Book book = new Book();
//		Category category = new Category();
//		category.setCategoryId(14);
//		category.setNameCategory("APPLE");
//		
//		book.setCategory(category); 
//		
//		book.setTitle("Oracle");
//		book.setAuthor("apple");
//		book.setDescription("ok ");
//		book.setIsbn("1213");
//		book.setPrice(25.65f);
//	
//		DateFormat dateFormat =  new SimpleDateFormat("dd/MM/yyyy");
//		Date publishDate  = dateFormat.parse("25/08/2020");
//		book.setPublishDate(publishDate);
//		
//		
//		
//		String imageUrl = "/Users/wayster/Desktop/514axA2lwpL.jpg"; 
//		byte[] image = Files.readAllBytes(Paths.get(imageUrl));
//		book.setImage(image); 
//		
//		
//		Book createBook =  bookdao.create(book);
//		
//		assertTrue(createBook.getBookId() > 0 );
//	}
	
	
//	@Test
//	public void testUpdated() throws ParseException, IOException {
//		Book book = new Book();
//		Category category = new Category();
//		category.setCategoryId(14);
//		category.setNameCategory("APPLE");
//		
//		book.setBookId(32);
//		book.setCategory(category); 
//		book.setTitle("Java 8");
//		book.setAuthor("Oracle");
//		book.setDescription("nothing to show");
//		book.setIsbn("1213");
//		book.setPrice(25.65f);
//	
//		DateFormat dateFormat =  new SimpleDateFormat("dd/MM/yyyy");
//		Date publishDate  = dateFormat.parse("25/08/2020");
//		book.setPublishDate(publishDate);
//		
//		
//		
//		String imageUrl = "/Users/wayster/Desktop/514axA2lwpL.jpg"; 
//		byte[] image = Files.readAllBytes(Paths.get(imageUrl));
//		book.setImage(image); 
//		
//		
//		Book updateBook =  bookdao.update(book);
//		
//		assertEquals(updateBook.getTitle(), "Java 8");
//		
//	}
	
	
//	@Test
//	public void deleteTest() {
//		int id = 35;
//		bookdao.remove(id); 
//		assertTrue(true); 
//		
//		
//	}
	
//	@Test
// 	public void testGetId() {
//		Integer id = 36;
//		Book b = bookdao.get(id);
//		assertNotNull(b);
//		 
//	}
//	
	
//	@Test
//	public void testListAll() {
//		List<Book> lista =  bookdao.listAll();
//		assertNotNull(lista);
//	}
	
	
//	@Test
//	public void testFindByTitle() {
//		String title = "Java Engineer";
//		Book book = bookdao.findByTitle(title);
//		
//		 System.out.println(book.getTitle());
//		assertNotNull(book);
//	}

	
//	@Test
//	public void test_count() {
//		long count = bookdao.count();
//		long expected = 1;
//		assertEquals(expected, count);
//		System.out.println(count);
//	}
	
//	@Test
//	public void ListByCategory() {
//		int category = 14;
//		List<Book> list_books = bookdao.listByCategory(category);
//		
//		assertTrue(list_books.size() > 0);
//	}
	
}
