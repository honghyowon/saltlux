package sample;

interface myInterface {
	
	void aa(); //	public abstract 생략
	
}

//class myClass implements myInterface {
//	
//	@Override
//	public void aa() {
//		// TODO Auto-generated method stub
//		
//	}
//}

public class InterfaceTest {

	public static void main(String[] args) {
		
		myInterface a = new myInterface() {

			@Override
			public void aa() {
				// TODO Auto-generated method stub
				
			}
			
			
		};
	}
}
