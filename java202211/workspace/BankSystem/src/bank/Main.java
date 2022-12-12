package bank;

import bank.*;

public class Main {
	
	// 1. 생성자
	// default 생성자가 들어와요!
	
	// 2. field도 존재할 수 있음. but 필요없죠
	
	// 3. method entry point인 main method만 존재
	
	public static void main(String[] args) {
//		
//		// 1. 홍길동 instance를 생성하자
//		Customer hong = new Customer();
//		
//		// 2. 생성한 객체의 이름을 홍길동으로 setting
//		hong.name = "홍길동";					//좋은 code는 아님
//		
		Customer hong = new Customer("홍길동"); //생성자 함수를 만들고, 필드에 애초에 홍길동으로 시작하기 위함
		
		// 3. 홍길동이 잔액을 확인해요
		long result = hong.getBalance();	//getBalance는 값을 돌려줌 => long result 받아야함
		System.out.println("잔액은 : " + result);
		
		// 4. 홍길동이 입금해요
		hong.deposit(2000);					//객체.메소드(result);
		result = hong.getBalance();
		System.out.println("잔액은 : " + result);
		
		// 5. 홍길동이 3000원 출금해요!
		long rest = hong.withdraw(3000);	//rest는 잔액
		System.out.println("잔액은 : " + rest);
		
		// 5. 홍길동이 3000원 출금해요!
		rest = hong.withdraw(1000);			//변수를 또 선언할 수 없기 때문에 rest 앞 long을 지움
		System.out.println("잔액은 : " + rest);
		
		
		
	}
}// 







