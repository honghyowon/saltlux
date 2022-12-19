package assignment.bookstore;

public class Book {

	public Book() {
		// TODO Auto-generated constructor stub
	}
	
	public Book(String category, String bookName, double bookpPrice, double bookDiscountRate) {
		super();
		this.category = category;
		this.bookName = bookName;
		this.bookpPrice = bookpPrice;
		this.bookDiscountRate = bookDiscountRate;
	}

	
	private String category;
	private String bookName;
	private double bookpPrice;
	private double bookDiscountRate;
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public double getBookpPrice() {
		return bookpPrice;
	}

	public void setBookpPrice(double bookpPrice) {
		this.bookpPrice = bookpPrice;
	}

	public double getBookDiscountRate() {
		return bookDiscountRate;
	}

	public void setBookDiscountRate(double bookDiscountRate) {
		this.bookDiscountRate = bookDiscountRate;
	}

	@Override
	public String toString() {
		return "Book [category=" + category + ", bookName=" + bookName + ", bookpPrice=" + bookpPrice
				+ ", bookDiscountRate=" + bookDiscountRate + "]";
	}
	
	
	
	
	
}
