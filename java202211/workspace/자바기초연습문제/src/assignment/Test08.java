package assignment;

public class Test08 {
	public static void main(String[] args) {
		String str = args[0];
		char[] cha = str.toCharArray();
		
		for(int i = cha.length - 1; i >= 0; i--) {
			System.out.print(cha[i]);
		}
	}
}
