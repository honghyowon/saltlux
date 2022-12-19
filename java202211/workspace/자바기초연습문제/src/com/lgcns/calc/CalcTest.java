//package com.lgcns.calc;
//
//public class CalcTest {
//
//	public static void main(String[] args) {
//		Calc calc = new Calc();
//		
//		int a = 4;
//		int b = 2;
//		
//		int result = calc.sum(4, 2);
//		
//		System.out.println("합 : " + result);
//	}
//}//


package com.lgcns.calc;

import java.util.Scanner;

public class CalcTest {

//	public static void main(String[] args) {
//		Calc calc = new Calc();
//		
//		int a = 4;
//		int b = 2;
//		
//		int resutl = a+b;
//		
//		System.out.println("합 : " + sum);
//		
//		
//		int div = a/b;
//		
//		System.out.println("나누기 : " + div);
//	}
//	
	
//	public class Main {
//		  public static void main(String args[]){
//		    Calc calc = new Calc();
//		    Scanner sc = new Scanner(System.in);
//		    int a, b;
//
//		    a = sc.nextInt();
//		    b = sc.nextInt();
//
//		    System.out.println("합: " + calc.sum(a, b));
//		    System.out.println("차: " + calc.subtract(a, b));
//		    System.out.println("곱: " + calc.multiply(a, b));
//		    System.out.println("나누기: " + calc.divide(a, b));
//		  }
//		}
//	
//	
	
	
	public static void main(String[] args) {

		    Calc calc = new Calc();
		    Scanner sc = new Scanner(System.in);
		    int a, b;

		    a = sc.nextInt();
		    b = sc.nextInt();

		    System.out.println("합: " + calc.sum(a, b));
		    System.out.println("차: " + calc.subtract(a, b));
		    System.out.println("곱: " + calc.multiply(a, b));
		    System.out.println("나누기: " + calc.divide(a, b));
		  }
	}