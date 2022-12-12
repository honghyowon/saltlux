package sampleproj;

public class ThreadEx_04 implements Runnable{
	
	//field
	static boolean autoSave = false;
	
	public static void main(String[] args) {
		
		Thread t = new Thread(new ThreadEx_04());
//		t.setDaemon(true);		//자신을 만든 thread(Main)의 보조 thread가 됨
		
		t.start();
		
		for(int i=0; i<10; i++) {
			try {
				Thread.sleep(1000);		
			} catch(InterruptedException e) {
			}
			if( i == 5) {
				autoSave = true;
				
			}//try() end
			
		}//for() end
		
	}

	@Override
	public void run() {
		
		while(true) {
			// Thread를 일정시간동안 재울 거에요
			try {
				Thread.sleep(3000);				//밀리세컨즈 단위 => 3초, class 이름으로 sleep method 바로 호출 => static
												//일정 시간동안 thread를 재웠다가,
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			if(autoSave) {
				System.out.println("자동저장 되었어요!");
			}
			
		}//while() end
		
	}
	
}//
