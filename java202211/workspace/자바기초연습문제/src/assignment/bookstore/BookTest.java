package assignment.bookstore;

import java.util.HashSet;

public class BookTest {

	public static void main(String[] args) {
		
		Book bookArray[] = new Book[5];
		
		bookArray[0] = new Book("IT", "SQL Plus", 50000, 5);
		bookArray[1] = new Book("IT", "Java 2.0", 40000, 3);
		bookArray[2] = new Book("IT", "JSP Servlet", 60000, 6);
		bookArray[3] = new Book("Novel", "davincicode", 30000, 10);
		bookArray[4] = new Book("Novel", "cloven hoof", 50000, 15);
		
		// 객체 정보 출력
		for(Book book: bookArray) {
			System.out.println(book);
		}//for() end
		
		System.out.println();
		
		// 다른 종류의 category 책이 추가될 경우를 대비
		HashSet<String> set = new HashSet<>();		//HashSet<데이터타입> 변수명 = new HashSet<데이터타입>(); 
		for(Book book: bookArray) {
			set.add(book.getCategory());
		}
		
		for(String category: set) {
			double sumOfBookPrice = 0;
			double sumOfBookPriceDis = 0;
			for(Book book : bookArray) {
				if(book.getCategory().equals(category)) {
					sumOfBookPrice += book.getBookpPrice();
					sumOfBookPriceDis += book.getBookpPrice() - (book.getBookpPrice()*book.getBookDiscountRate());
					
				}//if() end
			}
			System.out.println(category + "Category의 책 가격 합 : " + sumOfBookPrice);
			System.out.println(category + "Category의 할인된 책 가격 합 : " + sumOfBookPriceDis);
			
		}//for() end
	}
	
}
