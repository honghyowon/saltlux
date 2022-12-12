package sampleproj;

class ThreadEx_07_1 implements Runnable {

	@Override
	public void run() {
		
		while(true) {
			System.out.println(Thread.currentThread().getName());	// 현재Thread를 찾는다
			
			try {
			Thread.sleep(1000);
			} catch (InterruptedException e) {
				
			}
			
		}
		
	}
	
}

public class ThreadEx_07 {
	public static void main(String[] args) {
		// Runnable interface를 구현한 class의 instance를 생성
		Runnable r = new ThreadEx_07_1();
		
		Thread t1 = new Thread(r, "*");		//하는 일이 없기때문에 하는 일이 있는 r를 넣어줌
		Thread t2 = new Thread(r, "**");
		Thread t3 = new Thread(r, "***");
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			Thread.sleep(2000);		//main thread가 졸게 된다
			t1.suspend();			//t1을 일시정지
			Thread.sleep(2000);
			t2.suspend();
			Thread.sleep(2000);
			t1.resume();
			Thread.sleep(2000);
			t1.stop();
			t2.stop();
			Thread.sleep(2000);
			t3.stop();
			
 		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
