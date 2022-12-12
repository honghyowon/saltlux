package com.test;

import java.util.HashSet;

public class SetTest {

	public static void main(String[] args) {
	
		HashSet<String> set = new HashSet<String>();
		
		//set안에 데이터를 저장하는 건 쉬움
		set.add("123");
		set.add("홍길동");
		set.add("신사임당");
		set.add("Hello");
		
		//set안에 저장된 데이터를 꺼내려면 어떻게 해야 하나요?
		//set은 순서가 없음. 순서를 이용해서 꺼낼 수 없음
		//set은 key가 없음	. key를 이요해서 꺼낼 수 없음
		for(String s : set) {
			System.out.println(s);
		}
		
	}
	
}//
