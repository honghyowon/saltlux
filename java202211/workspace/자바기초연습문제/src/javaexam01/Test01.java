package javaexam01;

public class Test01 {
		
//		int a=0;
//		
//		int a1 = Integer.parseInt(args[0]);
//		
//		int result = a1;
//		if((a1%2) == 0) {
//			System.out.println("입력값 : " + a1);
//			System.out.println("2의 배수 입니다.");
//		}else {
//			System.out.println("2의 배수가 아닙니다.");
//		}
//		
		
		
	
	
//---------------------------------강사님 코드	

		
		public static void main(String[] args) {
			
			int data1 = Integer.parseInt(args[0]);
			int result = data1 % 2;
			
			if (result == 0) {
				System.out.println("2의 배수 입니다.");
			} else {
				System.out.println("2의 배수가 아닙니다.");
			}
		}

	
	
}//class() end
