package com.test;

class MyClass extends Exception {
	
}

public class CustomeExceptionTest {

	public static void main(String[] args) throws Exception {
		System.out.println("시작");
			
		throw new MyClass();	//exception 객체가 생성됨 (아직은 그냥 객체 단계)

//		System.out.println("끝");
		
	}	
}//