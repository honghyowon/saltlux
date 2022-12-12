package com.computer;

public class ComputerTest {
	public static void main(String[] args) {
		
		//배열
		Computer[] arrays = new Computer[4];
		//int[]		k	  = new		int[4];
		//arrays안에는 computer라는 클래스 타입의 객체가 들어옴
		//Labtop과 Tap은 둘 다 Computer의 subclass임
		//따라서 IS-A 관계에 의해 .. Labtop과 Tab의 instance는 배열에 저장 가능
		arrays[0] = new Laptop("Laptop01", 2, 1024, 2000);
		arrays[1] = new Laptop("Laptop02", 3, 2048, 2300);
		arrays[2] = new Laptop("Tap01", 2, 1024, 1200);
		arrays[3] = new Laptop("Tap01", 3, 2048, 1300);
		
		// 기본정보 출력
		for(Computer tmp : arrays) {
			System.out.println(tmp);
		}
		
		// 컴퓨터 사용
		for(Computer tmp : arrays) {
			tmp.operate(55);	//동적 바인딩이 발생함
								//overriding된 method가 호출됨
			if(tmp instanceof Laptop) {		//Computer와 Graphic은 아무 상관이 없기때문에 Computer를 Laptop으로.. 
				System.out.println(((Laptop)tmp).rendering(100));
				
				
			} else {
				System.out.println(((Tab)tmp).rendering(100));
			}
		}
		
	}
		
}//
