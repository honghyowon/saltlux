package bank;

public class Customer {
	
	// 1. 생성자
	// 생성자가 같은 package안에 있는 다른 class에 의해서 사용된다면..
	// public keyword가 필요 없다
	// 만약 생성자가 다른 package안에 있는 class에 의해서 사용된다면..
	// public keyword가 필요함
	// 지금 우리는 같은 프로젝트 안에 다른 package에서 customer class의
	// instance를 생성할 예정이예요. 따라서 생성자에 public을 붙여야 함
	public Customer() {
		// default 생성자 : parameter도 받지 않고 하는 일도 없는 생성자.
		// 이렇게 인자도 없고 하는 일도 없이 만들 거면 안 써도 됨. 자동으로 생기니까.
		// 생성자는 리턴 타입이 없고, 클래스 이름과 동일
	}
	
	// 그런데 생성자는 1개 이상 있을 수 있다고 했어요! 
	// 생성자는 클래스 이름과 무조건 같기때문에
	// 하나의 클래스 안의 모든 생성자명이 모두 동일하기 때문에 인자의 갯수 or 인자의 타입으로
	// 생성자를 구분해야함
	// 생성자가 하는 일 : 만들어진 인스턴스의 초기화를 담당
	// 인스턴스의 필드초기값을 설정하는 일을 함
	public Customer(String name) { //이 name은 parameter로 받은 임시 변수
		this.name = name;		   //파란 name은 field
	}
	
	
	// 2. field 선언
	public String name;				//고객 이름 => instance variable	//public이 있다는 건, 다른 package에서
	public String accountNumber;	//계좌번호 => instance variable	// 객체가 만들어져야 공간이 생김
	public long balance;			//잔액 => instance variable
	
	
	// 3. method 정의
	// 잔액을 확인한다 라는 기능 만들기 => 잔액을 알아내서 리턴한다.
	// - 기능자체가 잔액을 조사해서 출력까지 진행할 건지?
	// - or 기능은 잔액을 조사해서 잔액의 값만 리턴시키고 출력은 따로 수행할 건지?
	
	public long getBalance() {	//잔액의 값을 알아오세요
		return this.balance;
		// this는 변수. 그 안에 어떤 값이 들어있냐 => 메모리 주소값이 들어있음
		// instance에 대한 reference주소가 들어있음
		// 현재 사용하는 객체에 대한 주소가 들어있게 됨
	}
	
	
	// 입금하는 기능(리턴값이 없는 형태의 method로 만들기)
	public void deposit(long money) {	//void는 리턴값이 없음. 처리만 하고 결과는 없음
						//얼마 입금하는지 알려줘야함 => 인자 입력
		this.balance += money;			//this.balance = this.balance + money; 의 축약형
	}
	
	
	// 출금하는 기능(출금 후 잔액을 리턴값으로 사용)
	public long withdraw(long money) {
		// 만약 잔액이 출금요청액보다 적으면 출금이 되면 안됨
		if(this.balance < money) {
			System.out.println("돈이 없습니다. 확인 부탁 !");
		}else {
			this.balance -= money;
		}
		return this.balance;
	}
	//이런 걸 비즈니스 메소드 라고 함
	
	
	
	
	
	
}









