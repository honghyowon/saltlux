package com.test;

class Customer {
	public String name;
	public long	balance;
}

public class ExceptionTest {

	public static void main(String[] args) throws Exception{
		
		System.out.println("예외상황을 발생시켜요!");
				
		int result = 10/0;		//문법적인 오류는 없음
								//하지만 Runtime에 이상한 상황(Exception)이 발생
		
		System.out.println("여기는 출력되나요 !");
	}
}
