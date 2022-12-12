package finaltest;

public class SubClass extends SuperClass {
	
	//constructor
	public SubClass() {
		super(100);		//상위 클래스의 instance생성부분
		
		//메모
		
		//이 아래가 객체 초기화 작업
		staticCall("8번 문장입니다.");
		super.myFunc();
	}
	
	//field
	int c = staticCall("6번 문장입니다.");
	static int d = staticCall("7번 문장입니다.");

	
	//method
	//method overriding을 할 거예요
	@Override					//annotation이라고 함
	public void myFunc() {
		System.out.println("9번 문장입니다.");
	}
	
	public static void main(String[] args) {
		System.out.println("10번 문장입니다.");
		SuperClass obj = new SubClass();
		obj.myFunc();
	}
	
}//