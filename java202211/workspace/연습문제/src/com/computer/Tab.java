package com.computer;

public class Tab extends Computer implements Graphic{

	public Tab() {

	}
	
	
	
	
	public Tab(String name, int cpu, int memory, int battery) {
		super();
		this.name = name;
		this.cpu = cpu;
		this.memory = memory;
		this.battery = battery;
	}
	
	
	@Override
	public double rendering(int size) {
		return (double)size/(getCpu() * getMemory()) * 20;	//double을 넣어서 강제로 형변환
	}

	@Override
	public void operate(int time) {
		//입력으로 돌아온 시간 5당 1씩 배터리가 감소
		int result = time/5;
		//프로그램에서 연산(+,-,*,/)은 일단 같은 데이터 타입끼리 발생
		setBattery(getBattery() - result);	//상위 클래스의 필드에서 가져와야하기 때문에 setter

		
	}
	
	

	
	
}//


