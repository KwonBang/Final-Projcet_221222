package Parking;

public class Runabout extends Car{
	public Runabout() {
		super.pay = 40000;
	}
	@Override
	public void discount2() {
		if (super.familyCnt>=3) {
			super.pay = (int) (super.pay*0.9);
		}
	}
}
