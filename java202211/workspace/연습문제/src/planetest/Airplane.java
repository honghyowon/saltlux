package planetest;

public class Airplane extends Plane{
	
	//생성자
	public Airplane() {
		
	}
	
	public Airplane(String planeName,int fuelSize) {
		super(planeName,fuelSize);
	}
	
	
	@Override
	public void flight(int distance) {
		//연료량은 운행거리 * 3 만큼 줄이면 됨
		//fuelSize가 private 이라서 getter&setter로 가져옴
		setFuelSize(getFuelSize() - (distance*3));

	}
	
		
	
}//


class CargoPlane extends Plane{

	public CargoPlane() {
		super();
	}

	public CargoPlane(String planeName, int fuelSize) {
		super(planeName, fuelSize);
	}

	@Override
	public void flight(int distance) {
		setFuelSize(getFuelSize() - (distance*5));
		
	}
	
}
