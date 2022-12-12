package bank;

public class InstanceTest2 {
	
	//field
	static int a = staticCall("1번째 출력입니다."); //1.메소드area에 데이터 올라감
	int b = staticCall("2번째 출력입니다.");		//5. static이니까 바로 호출
	
	//method
	public static int staticCall(String msg) {
		System.out.println(msg);
		return 100;
	}
	
	
	//static block
	//이 static block은 언제 실행되나요?
	//main method를 호출하기 이전에 static block이 있으면 먼저.
	static {
		System.out.println("static block입니다. a의 값은 : " + a);
		// 프로그램에서 사용되는 라이브러리를 미리 로딩하고자 할 때. JNI(Java Native Interface)
		
	}
	
	
	
	
	//생성자
	public InstanceTest2() {
		this.b = staticCall("3번째 출력입니다.");	//6. 호출
	}
	
	public static void main(String[] args) {
		System.out.println("4번째 출력입니다.");	//2. main실행
		int c = staticCall("5번째 출력입니다.");	//3. instance없이 호출
		InstanceTest2 d = new InstanceTest2();	//4. new해서 인스턴스 생성
	}
	
}//
