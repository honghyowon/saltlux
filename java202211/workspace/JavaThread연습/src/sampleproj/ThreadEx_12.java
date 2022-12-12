package sampleproj;

class Account {
	//생성자
	public Account() {
		
	}
	
	public Account(int balance) {
		super();
		this.balance = balance;
	}

	// field
	private int balance;
	
	
	// business method
	// synchronized method (동기화 메소드)
	// 이 메소드를 실행한 Thread가 먼저 Lock(Monitor) 획득.
	// 하나의 thread가 메소드를 호출하면 나머지 하나는 block됨 !
	public void withdraw(int money) {
		// ~~~
		// 여기 코드는 동기화 안 됨
		// ~~~
		
	synchronized(this) {
			if(balance >= money) {
				try {
					Thread.sleep(1000);		//현재 수행되는 thread의 method를 재움. 일부러 확인하기 위해
				} catch (Exception e) {
					// TODO: handle exception
				}
				balance -= money;
			}
		}
	
		// ~~~
		// 여기 코드는 동기화 안 됨
		// ~~~
				

	}
	
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
}


class ThreadEx_12_1 implements Runnable {
	//field
	Account acc = new Account(1000);
	
	@Override
	public void run() {
		
		while(acc.getBalance() > 0 ) {
			int money = (int)(Math.random() * 3 + 1) * 100;
						// 0 ~ 3인데 +1 해서 1 ~ 4
			acc.withdraw(money);	//공용객체의 출금처리
			System.out.println("남은 금액 : " + acc.getBalance());
					
		}
		
	}
}


public class ThreadEx_12 {
	public static void main(String[] args) {
		ThreadEx_12_1 r = new ThreadEx_12_1();
		
		Thread t1= new Thread(r);
		Thread t2= new Thread(r);
				
		t1.start();
		t2.start();
	}
}