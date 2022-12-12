package com.test;

import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		
		// ArrayList를 생성해 보자
		ArrayList<Object> a = new ArrayList<Object>();	//Object가 최상위 객체라서 generic을 Object로. string과 int가 둘 다 있음
		a.add("Hello");
		a.add(new Student("홍길동",20));
//		a.add(new Integer(100));	//error는 아니지만 웬만하면 쓰지말라는 표시가 뜸
		a.add(100);					//auto Boxing이 발생하고 사용하는 class는 Integer
		a.add(3.14);				//Double class를 사용.
		
		//통칭해서 wrapper class ??
		
		
		ArrayList<String> b = new ArrayList<String>();
		b.add("Hello");
		b.add("홍길동");
		b.add(new String("소리없는 아우성!"));
//		b.add(100);			//String이 아닌 int라서 오류!
				
	}
	
}//
