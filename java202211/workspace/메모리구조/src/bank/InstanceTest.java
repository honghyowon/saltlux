package bank;

// javac InstanceTest.java => compile한 후
// java bank.InstanceTest.class => .class는 생략/ JVM을 이용해서 실행

public class InstanceTest {

	// 1. 생성자
	public InstanceTest() {
		
	}
	
	// 2. field

	//class variable : class 이름으로 사용할 수 있는 변수
	public static int a = 100;	//a의 공간이 생성되는 곳은 Method Area
								//instance를 만들지 않고도 사용할 수 있음
	//instance variable : instance가 있어야지 사용할 수 있는 variable
	int b = 200;				//b는 instance가 생성된 후에 그 안에 공간이 생성됨
								//공간이 생성되는 곳은..당연히 Heap

	
	// 3. method	
	public void instanceCall(String msg) {
		System.out.println(msg);
	}
	
	public static void staticCall(String msg) { //클래스 이름으로 바로 가능
		System.out.println(msg);
	}
	
	public static void main(String msg) {
		int k = 100;			//local variable(지역변수) => stack에 저장되고
								//메소드가 종료하면 당연히 없어져요
		InstanceTest hong = new InstanceTest();
		
		hong.a = 300;			//instance를 이용해서 static field를 이용할 수 있음
		InstanceTest.a = 500;	//static field이기 때문에 class를 이용해서 사용할 수 있음
		
		hong.b = 300;			//OK
//		InstanceTest.b = 500;	//Error 이렇게 사용할 수 없음
	}
	
	
	
	
}//
