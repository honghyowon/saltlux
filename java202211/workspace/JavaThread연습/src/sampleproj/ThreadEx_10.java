package sampleproj;

class ThreadEx_10_1 extends Thread {
	@Override
	public void run() {
		for(int i=0; i<100; i++) {
			System.out.print("-");
		}
	}
}//

class ThreadEx_10_2 extends Thread {

	@Override
	public void run() {
		for(int i=0; i<100; i++) {
			System.out.print("|");
		}

	}
}//

public class ThreadEx_10 {

	public static void main(String[] args) {
		long startTime = 0;		// 시간체크해보려고 넣음
		
		Thread t1 = new ThreadEx_10_1();
		Thread t2 = new ThreadEx_10_2();
		
		t1.start();
		t2.start();
		
		startTime = System.currentTimeMillis();	//숫자로 현지시간을 표현 (밀리세컨즈단위)
		
		try {
			t1.join();			// t1이 끝날 때까지 main을 멈추고, t1이 끝나면 main 다시 실행
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("소요시간 : " + (System.currentTimeMillis() - startTime));
		
		
	}
	
}//
