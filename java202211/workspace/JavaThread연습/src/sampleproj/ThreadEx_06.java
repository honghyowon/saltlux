package sampleproj;

import javax.swing.JOptionPane;

class ThreadEx_06_1 extends Thread {
	
	@Override
	public void run() {
		
		int i = 10;									// 지역변수
		
		while(i != 0 && !isInterrupted()) {			// this.isInterrupted에서 this. 생략
			System.out.println(i--);				// 10출력 후 i값을 1감소
			// busy-waiting
			for(long k=0; k<300000000000000000L; k++);
		}
		System.out.println("카운트가 종료되었습니다.");
		
	}
}

public class ThreadEx_06 {
	public static void main(String[] args) {
		Thread t = new ThreadEx_06_1();				// thread instance 생성
		
			t.start();								// thread를 Runnable상태로 전이시킴
													// 바로 실행은 안 되지만
													// 언젠가는 Thread Scheduler에 의해 실행됨
			String data = JOptionPane.showInputDialog("값을 입력하세요.");
			//JOptionPane은 class, showInputDialog는 static으로 지정됨
			
			System.out.println(data);
			
		t.interrupt();		                        // thread를 interrupt 시켰음
													// thread가 중지/일지정지 등은 발생하지 않음
													// 로직으로 thread의 행동을 제어해야 함
//			t.suspend();
//			t.stop();
		
	}
	
}//
