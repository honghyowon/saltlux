package bpackage;

public class CClass {

	// constructor
	
	// field	
	
	// method
	
	public static void main(String[] args) {
		BClass b = new BClass();
//		b.bField = 100;		//접근자체가 안 되면 어떻게 값을 바꿔야 하나요?
		b.setbField(100);	//setter를 이용해서 값을 바꿔야함 !
	}

}//
