package test;

// java test.Student => 1. method area에 class 정보를 올림
//					 => 2. Student class 안에서 main을 찾아요 ! 만약 없음녀 => Error!
//						   만약 있으면 JVM에 의해서 main이 호출됨
//						3. stack에 main method
// 객체지향의 상속을 이용해서 class를 다시 만들어보아요!
// java에서 extends 라는 keyword를 제공함
// extends 뒤에 class가 나올 수 있는데 Java는 이때 단 하나의 class만 나올 수 있음
// Java는 다중상속을 지원하지 않음. extends keyword 다음에 class는 단 1개만 나옴 !
// Java는 단일 상속을 지원함

public class Student extends Person { //Person을 상속(확장)해서 Student를 정의하겠다는 의미

	public Student() {
		//상위 클래스의 constructor 호출
//		super("홍길동");
					//생성자의 첫부분은 무조건 super로 시작해야함.
					//만약 이 코드가 없으면 자동 삽입됨
					//상위 class의 생성자를 호출하는 코드
					//Person() 이 형태의 생성자를 호출
		
		
		//현재 객체의 field를 초기화하는 부분
		
	}
	
	//field	
//	
//	private String name;
//	private String gender;
//	private int age;
//		
	private String dept;	//학과
	
	//method
//	
//	public void eat() {
//		System.out.println("밥을 먹어요!");
//	}
//	
	
	
	// 상속받은 상위 클래스의 메소드를
	// 하위 클래스에서 재정의(다시 정의) 하는 것
	// method overriding
	public void eat() {
		super.eat();	// 상위 type의 method를 호출 할 수 있음
		System.out.println("밥을 맛있게 먹어요!");
	}
	
		
	public void study() {
		System.out.println("공부를 해요!");
	}
	
	public static void main(String[] args) {
//		Student s = new Student();	// Person s = new Student(); 도 가능. 상속으로. person이 super class
									//is-a 관계
		// data type => 지정된 변수 안에 들어올 값에 대한 제한을 검
		
//		Person s = new Student();
//		s.study();	//사용하지 못함
//		s.eat();	//사용 가능
		
		
		Person s = new Student();
		// 현재 s로는 eat() method를 호출할 수 없음
		// 형(Type)변환을 이용하면 됨 => casting 작업을 하면 됨 => ()괄호 이용
//		((Person)s).eat();
//		s.eat();		//"밥을 맛있게 먹어요!" => 이건 이해하기 쉬움
		s.eat();		// 동적바인딩이 일어나요. (dynamic binding)
		// 원래는 Person의 eat() method를 호출해야 되는데..
		// 해당 객체가 method overriding을 이용해 메소드를 다시 작성한 경우에는
		// overriding된 method를  대신 호출함
		
		// 이렇게 되면.. 결국 Person에 있는 eat()은 호출할 방법이 없음
		
	}
	
}//













