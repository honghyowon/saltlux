package com.test5;

import java.util.HashMap;

public class Company {
	
	public static void main(String[] args) {
		HashMap<Integer, Employee> map =
				new HashMap<Integer, Employee>();
		
		map.put(1, new Secretary("Hilery", 1, "secretary", 800));
		map.put(2, new Sales("Clinten", 2, "sales", 1200));
		
		//map에 있는 모든 객체에 대해 출력하시오
		for(Integer i : map.keySet()) {
			System.out.println(map.get(i));	//map에서 key값으로 정보를 얻어옴
		}
		
		//모든 객체에 인센티브를 100씩 지급하시오
		//타입 캐스팅과 동적바인딩 내용을 이해해야 함
		for(Integer i : map.keySet()) {
			((Bonus)(map.get(i))).incentive(100);	//incentive를 사용할 수 있도록 
		}
		
		//map에 있는 모든 객체에 대해 출력하시오
		for(Integer i : map.keySet()) {
			System.out.println(map.get(i) + "    " + map.get(i).tax());
		}
		
		
	}
	
}//
