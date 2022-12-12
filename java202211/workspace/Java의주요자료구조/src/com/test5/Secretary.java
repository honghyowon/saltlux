package com.test5;

public class Secretary extends Employee implements Bonus{

	
	public Secretary() {
	
	}
	
	
	

	public Secretary(String name, int number, String department, int salary) {
		super(name, number, department, salary);

	}




	@Override
	public void incentive(int pay) {
		setSalary(pay);
		setSalary((int)((pay * 0.8) + getSalary()));	//정수와 실수면 범위가 큰 실수값이 됨=> int로 형변환
		
	}


	@Override
	public double tax() {
		
		return getSalary() * 0.1 ;
	}

}//
