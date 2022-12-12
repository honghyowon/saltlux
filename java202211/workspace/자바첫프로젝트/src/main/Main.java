package main;

import test.Customer;

public class Main {

	public static void main(String[] args) { //생성자
		// 프로그램의 entry point
		// 이제.. 간단하게 instance를 class로부터 생성해 보아요!
		System.out.println("프로그램 시작!");
	
		Customer hong = new Customer();	// reference data type
		// hong => reference variable(참조 변수)
		//		  변수긴 변수인데 메모리 주소에 대한 참조값(해쉬값)이 들어가 있음
		// instance는 메모리에 존재해요! (메모리 공간 중 어디에 위치하냐면..Heap이라고 불리는 영역에 존재함)
		// 우리가 사용하는 건 결국 instance를 사용함. 이 공간을 사용하기 위해 참조변수를 이용함
		// 그래서 우리가 편하게(일반적으로) hong을 객체라고 얘기함
		
		// test.Customer hong = new test.Customer(); //test라는 package 안 쓰고 싶으면 import 해야함
		// 클래스타입으로 hong이라는 변수를 만들고 new test.Customer()라는 메모리공간(instance)
		hong.balance = 1000;
		
		Customer shin = new Customer();
		
		
	}
}
