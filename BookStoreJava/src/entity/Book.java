package entity;
// Generated 01/07/2020 11:16:41 by Hibernate Tools 5.2.12.Final

import java.util.Base64;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;



@NamedQueries({
	@NamedQuery(name = "Book.list_all", query = "select b from Book b"),
	@NamedQuery(name = "Book.find_title", query = "select b from Book b where b.title = :title"),
	@NamedQuery(name = "Book.find_count", query = "select count(b) from Book b"),
	@NamedQuery(name = "Book.find_countCategpry", query = "select count(b) from Book b "
			+ "where b.category.categoryId = :catId"),
	@NamedQuery(name = "Book.findByIdCategory", query = "select b from Book b, "
			+ "Category c where b.category.categoryId = c.categoryId and c.categoryId = :catId"),
	@NamedQuery(name = "Book.lastBooks", query = "select b from Book b order by b.bookId DESC"),
	@NamedQuery(name = "Book.search", query = "select b from Book b where b.title LIKE '%' || :keyword || '%' "
			+ "or b.author LIKE '%' || :keyword || '%' "
			+ "or b.description LIKE '%' || :keyword || '%'")
}) 
@Entity
@Table(name = "book", catalog = "bookstoredb", uniqueConstraints = @UniqueConstraint(columnNames = "title"))
public class Book implements java.io.Serializable {

	private Integer bookId; 
	private Category category;
	private String title;
	private String author;
	private String description;
	private String isbn;
	private byte[] image;
	private String base64image;
	private float price;
	private String publishDate;
	private Date lastUpdateTime;
	private Set<Review> reviews = new HashSet<Review>(0);
	private Set<OrderDetail> orderDetails = new HashSet<OrderDetail>(0);

	public Book() {
	
	}

	public Book(Category category, String title, String author, String description, String isbn, byte[] image,
			float price, String publishDate, Date lastUpdateTime) {
		this.category = category;
		this.title = title;
		this.author = author;
		this.description = description;
		this.isbn = isbn;
		this.image = image;
		this.price = price;
		this.publishDate = publishDate;
		this.lastUpdateTime = lastUpdateTime;
	}

	public Book(Category category, String title, String author, String description, String isbn, byte[] image,
			float price, String publishDate, Date lastUpdateTime, Set<Review> reviews, Set<OrderDetail> orderDetails) {
		this.category = category;
		this.title = title;
		this.author = author;
		this.description = description;
		this.isbn = isbn;
		this.image = image;
		this.price = price;
		this.publishDate = publishDate;
		this.lastUpdateTime = lastUpdateTime;
		this.reviews = reviews;
		this.orderDetails = orderDetails;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "book_id", unique = true, nullable = false)
	public Integer getBookId() {
		return this.bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", nullable = false)
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Column(name = "title", unique = true, nullable = false, length = 128)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "author", nullable = false, length = 64)
	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Column(name = "description", nullable = false, length = 16777215)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "isbn", nullable = false, length = 15)
	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Column(name = "image", nullable = false)
	public byte[] getImage() {
		return this.image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Column(name = "price", nullable = false, precision = 12, scale = 0)
	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Column(name = "publish_date", nullable = false, length = 10)
	public String getPublishDate() {
		return this.publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_update_time", nullable = false, length = 19)
	public Date getLastUpdateTime() {
		return this.lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "book")
	public Set<Review> getReviews() {
		return this.reviews;
	}

	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "book")
	public Set<OrderDetail> getOrderDetails() {
		return this.orderDetails;
	}

	public void setOrderDetails(Set<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}


	@Transient
	public String getBase64image() {
		this.base64image =  Base64.getEncoder().encodeToString(this.image);
		return this.base64image;
	}

	@Transient
	public void setBase64image(String base64image) {
		this.base64image = base64image;
	}
	
	@Transient
	public float average() {
		float average_rating = 0.0f;
		float sum = 0.0f;
		
		if (reviews.isEmpty()) {
			return 0.0f;
		}
		
		for (Review review : reviews) {
			sum += review.getRating();
		}
		
		average_rating = sum / reviews.size();
		
		
		return average_rating;
	}
	
	@Transient
	public String getRatingsString(float averageRating) {
		String result = "";
		int numberOfStars = (int) averageRating;
		
		for (int i = 0; i < numberOfStars; i++) {
			result += "on,";
		}
		int next = numberOfStars + 1;
		
		if (averageRating > numberOfStars) {
			result += "half,";
			next++;
		}
		
		for (int j = next; j <= 5; j++) {
			result += "off,";
		}
		
		return result.substring(0, result.length() - 1);
	}
	
	@Transient
	public String getRatingStars() {
		float averageRating = average();
		
		return getRatingsString(averageRating);
	}
	

}
