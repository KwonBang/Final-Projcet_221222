package Parking;

public class CompactCar extends Car{
	public CompactCar() {
		super.pay = 20000;
	}
	@Override
	public void discount2() {
		if (super.familyCnt>=4) {
			super.pay = (int) (super.pay*0.9);
		}
		
	}

}
