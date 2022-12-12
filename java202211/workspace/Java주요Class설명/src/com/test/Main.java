package com.test;

public class Main {

	public static void main(String[] args) {
		
		
		Student s1 = new Student("홍길동", 20);
		Student s2 = new Student("신사임당", 30);
		Student s3 = new Student("홍길동", 20);
		
		
		// 두 객체가 같은 객체인가요?
		// 1. 진짜 두개의 instance가 같은 메모리 공간을 공유하고 있나요?
		// 2. instance의 내용이 같은가요? 
		
		// 일반적으로 똑같니? => 이 연산자는 "==" 를 사용 => 비교연산자
		// 이 연산의 결과는 true, false 논리값으로 결과가 리턴됨 
		
		System.out.println(s1 == s2);	// false
		System.out.println(s1 == s3);	// false 메모리주소값은 다름 
		System.out.println(s1.equals(s3));	// false , 재정의 후  true
		
		System.out.println(s1.toString());	// com.test.Student@ee7d9f1
		
			
		
	}
	

	
}//
