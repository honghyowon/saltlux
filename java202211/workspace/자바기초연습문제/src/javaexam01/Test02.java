package javaexam01;

public class Test02 {
	public static void main(String[] args) {
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		
		int result = a*b;
		if(1<=result && result < 10) {
			System.out.println("입력값 : " + args[0]+ "*" + args[1] + "=" + result);
			System.out.println("한자리 수 입니다.");
		}else if(10 <= result && result < 100) {
			System.out.println("입력값 : " + args[0]+ "*" + args[1] + "=" + result);
			System.out.println("두자리 수 입니다.");
		}
	}//main() end
}
