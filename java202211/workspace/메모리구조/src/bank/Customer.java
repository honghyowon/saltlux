package bank;

public class Customer {

	// 1. constructor(생성자)
	// 인자도 없고 하는 일도 없는 생성자 => default constructor
	public Customer() {
		
	}//default 생성자
	
	// 2. field
	//field는 같은 이름을 사용할 수 없음
	public String name;
	public long balance;
	
	// 3. method
	public void deposit(long money) { 
		int myMoney = 100; //결과값 확인을 위해 임시로 넣음
		this.balance += money;
	}
	
	public void deposit(int money) {
		int myMoney = 100;
		this.balance += money;
	}
	
	
}//
