package com.test;

import java.util.HashMap;
import java.util.Set;

public class MapTest {
	
	public static void main(String[] args) {
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		// Map에 데이터를 저장할 때
		map.put("123", "Hello");
		map.put("4", "안녕!");
		map.put("kk", "홍길동");
		map.put("aa", "신사임당");
		map.put("123", "소리없는 아우성");
		
		
		//Map에서 데이터를 추출할 때
		System.out.println(map.get("123"));
		
		//Map안에 있는 모든 key를 알고 싶어요
		Set<String> s = map.keySet();
		for(String a : s) {
			System.out.println(a);
		}
	}
	
}//
