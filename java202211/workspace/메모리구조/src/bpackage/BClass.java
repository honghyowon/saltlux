package bpackage;	//package 구문이 무조건 최상단!

import apackage.*;	//import구문은 여러개 가능


	class BClass {

	// 1. constructor
	//	  응? 그럼 private 생성자는 사용이 될까?
	//	  이러면 같은 package 안에서 다른 class에 의해 객체생성이 안 되는데?
	//	  일반적으로는 이렇게 사용하는 것에 장점이 없음
	//	  but, singleton(싱글톤 패턴)에만 사용
	BClass() {
		
	}
	
	// 2. field
	private int bField;
	// bField라는 private field는 우리 class내에서만 조회와 변경이
	// 가능하도록 처리해햐 함
	// 특수한 목적의 method를 이용해야 함
	// 하나는 private field의 값을 조회하는 목적을 가진 method
	// 다른 하나는 private field의 값을 변경하는 목적을 가진 method
	// getter & setter
	
	// getter부터 만들어 보아요(값을 알아내는)
//	// access modifier는 public
//	public int getBField() { //직접적 접근을 막고 외부에서 가능
//		return this.bField;
//	}
//	
//	//setter
//	//parameter 로 받은 값을 변경한다
//	public void setBField() { //int bField : 바꿀값을 인자로 넘겨줘야함.
//		this.bField = bField;
//	}
//	
	
	public int getbField() {
		return bField;
	}

	public void setbField(int bField) {
		this.bField = bField;
	}
	

	
	
	// 3. method
	void bMethod() {
		System.out.println("하이");
		
	}

	
}//
