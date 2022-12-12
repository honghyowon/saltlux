package sampleproj;


class ThreadEx_05_1 extends Thread {
	@Override
	public void run() {
		
		try {
			Thread.sleep(3000);
		}catch(InterruptedException e){
			System.out.println("소리없는 아우성!");
		}
		
		for(int i=0; i<100; i++) {
			System.out.print("-");
		}
		
		System.out.println("<< Thread 1 종료 >>");
	}
}

class ThreadEx_05_2 extends Thread {
	@Override
	public void run() {
		for(int i=0; i<100; i++) {
			System.out.print("|");
		}
		System.out.println("<< Thread 2 종료 >>");
	}
}


public class ThreadEx_05 {

	public static void main(String[] args) {
		Thread t1 = new ThreadEx_05_1();
		Thread t2 = new ThreadEx_05_2();
		
		t1.start();
		t2.start();

		System.out.println("<<main thread 종료>>");
				
	}
	
}//

//package sampleproj;
//
//
//class ThreadEx_05_1 extends Thread {
//	@Override
//	public void run() {
//		for(int i=0; i<90; i++) {
//		System.out.print("-");
//		}
//		System.out.println("<< Thread 1 종료 >>");
//	}
//}
//
//class ThreadEx_05_2 extends Thread {
//	@Override
//	public void run() {
//		for(int i=0; i<90; i++) {
//			System.out.print("|");
//		}
//		System.out.println("<< Thread 2 종료 >>");
//	}
//}
//
//
//public class ThreadEx_05 {
//
//	public static void main(String[] args) {
//		Thread t1 = new ThreadEx_05_1();
//		Thread t2 = new ThreadEx_05_2();
//		
//		t1.start();
//		t2.start();
//		
//		try {
//			t1.sleep(2000);		// Thread.sleep(2000)
//		} catch(InterruptedException e) {
//			e.printStackTrace();
//		}
//		System.out.println("<<main thread 종료>>");
//		
//		
//	}
//	
//}//
//