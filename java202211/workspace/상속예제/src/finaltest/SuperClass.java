package finaltest;

public class SuperClass {

	// constructor
	public SuperClass() {
		super();	//상위 클래스의 instance생성 부분
		
		//메모리에 공간을 확보(인스턴스를 위해) => 1번이 출력
		//우리 객체의 초기화 진행
		staticCall("3번 문장입니다.");
	}
	// constructor overloading으로 또 다른 생성자를 하나 정의해요
	public SuperClass(int i) {
		this();		//현재 클래스에 다른 생성자를 호출하는 기능
		staticCall("4번 문장입니다.");	
	}
	
	
	// field
	// field는 기본적으로 private으로 설정함. 우리 문제에서는 너무 복잡해서 그냥 package로 설정
	int a = staticCall("1번 문장입니다.");
	// a라는 field는 instance가 생성되어야 공간이 실제로 만들어지고 사용할 수 있음
	// 그래서 a를 instance variable이라고 부름. 만들어지는 공간은 Heap
	static int b = staticCall("2번 문장입니다.");
	// b라는 field는 instance가 없어도 사용이 가능함. 왜냐면 b의 공간은
	// method area에 만들어지기 때문
	// 이러한 field를 우리는 class variable이라고 부름. 만들어지는 공간은 method area
	
	
	// method
	// method는 일반적으로 public으로 지정함
	// method의 결과값을 return 한다는 의미는 메소드를 호출한 곳으로 값을 대치한다는 의미
	public static int staticCall(String msg) {
		System.out.println(msg);
		return 100;
	}
	
	public void myFunc() {
		System.out.println("5번 문장입니다.");
	}
	
}//
