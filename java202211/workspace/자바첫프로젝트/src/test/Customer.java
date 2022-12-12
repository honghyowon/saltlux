package test;

import java.lang.*;		//내가 안 써도 자동으로 import


public class Customer { //class명 첫글자는 대문자!
	// 1. 생성자들.
	//	  클래스 안에 있는 생성자를 이용해서 class로부터
	//	  instance를 생성할 수 있어요!
	//	  결국, 모든 class는 하나 이상의 생성자를 가지고 있어요!
	//	  생성자가 없는 class는 존재하지 않음!
	//	  만드는 규칙이 있어요!
	//	  일단 public(public을 쓸 수도 있고 아닐 수도 있다)
	//	  메소드 형태가 나옴 !!
	//	  생성자는 메소드가 아님 => 리턴타입이 존재하지 않음
	//	  생성자의 이름은 정해져 있음 => 클래스의 이름으로 정해져 있음
	//	  입력인자(parameter)를 가질 수 있음
	//	  중괄호 안에 instance의 초기화 코드가 들어옴
	//	  당연히 리턴구문은 존재하지 않음
	//	  이렇게 만든 걸 우리는 생성자(constructor)라고 함!!
	
	public Customer() { 
		// 생성될 인스턴스의 초기화코드가 들어옴!
	}	
	
	
	
	// 2. field들
	// 변수들이 와요! => camel case notation 
	// 이름
	String customerName;	//고객이름		// string은 reference 데이터 타입이며 변수
	public long balance;	//잔액 		// long은 primitive data type //public은 사용의 제한을 풀어줌
	String customerAccount;	//고객 계좌번호
	int customerAge;		//고객 나이
	// long, int는 primitive data type
	// String은 primitive data type이 아님 -> reference data type임을 유추 가능
	// 결국 String은 class라는 의미. 우리가 만들지 않은 class !
	// Java가 우리에게 제공한 class => 프로그램을 쉽게 하기 위해서 제공된 class
	// 이런 class가 무지막지하게 많다. (class library라고 얘기해요!)
	// 이 많은 제공된 class는 당연히 package로 묶어서 제공됨
	// 저 위에서 String이라는 듣도보도 못한 class가 사용되었는데,,
	// 당연히 이 class를 사용할 때 package를 명시해야함
	
	
	// 3. method들
	//		일반적으로 method는 특별한 용도가 아닌 이상 public을 기본으로 지정해요
	//		리턴타입 => 메소드는 우리가 알고 있는 함수형태.
	//				  함수는 입력을 받아서 로직처리한 후 그 결과물을 생성해서 결과물을
	//				  함수를 호출한 곳으로 돌려주기 위해서 사용! => 이 돌려주는 값을 리턴값.
	//				  이 리턴값이 어떤 데이터 타입인지 method 정의할 때 선언.
	
	public int getAge(int kk) { //public이고, 리턴타입은 int 정수타입이고, 식별자, parameter
		// kk는 parameter라고 하고, 함수의 method의 입력을 받아들이는 역할을 수행~!
		// business logic 처리가 진행되요!
		System.out.println("나이를 알려주는 기능이예요!");
		// if, for ...
		return 30;
	}	
	
}

