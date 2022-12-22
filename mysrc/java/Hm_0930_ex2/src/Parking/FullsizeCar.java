package Parking;

public class FullsizeCar extends Car{
	public FullsizeCar() {
		super.pay = 70000;
	}
	@Override
	public void discount2() {
		System.out.println("할인이 적용되지 않는 차입니다.");
		
	}

}
