package assignment;

public class Test07 {

	public static void main(String[] args) {
		
		for(int i=0; i <args.length; i++) {
			int checkValue = Integer.parseInt(args[i]);
			if(!(checkValue >= 10 && checkValue <=99)) {
				System.out.println("다시 입력하세요.");
				System.exit(0);
				
			}
		}//for()end
		
		int i1=Integer.parseInt(args[0]);
		int i2=Integer.parseInt(args[1]);
		int i3=Integer.parseInt(args[2]);
		int i4=Integer.parseInt(args[3]);
		int i5=Integer.parseInt(args[4]);
		
		double a, b, c, d, e = 0;
		double totalValue = 0;
		String classValue="";
		
		a = i1;
		b = i2;
		c = i3;
		d = i4;
		d = i5;
		
		totalValue = (a + b /2)*0.6 + ((c+d)/2)*0.2 + e*0.2;
		
		System.out.println("평가점수 : " + totalValue);
		
		
		if(totalValue >= 90) {
			classValue = "Gold Class";
		} else if (totalValue >= 80) {
			classValue = "Sliver Class";
		} else if (totalValue >= 70) {
			classValue = "Bronze Class";
		} else {
			classValue = "Normal Class";
		}
		
		System.out.println("Class : " + classValue);
	}
	
}//
