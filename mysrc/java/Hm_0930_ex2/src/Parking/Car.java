package Parking;

import java.util.ArrayList;

public abstract class Car {
	String carId = null;
	int pay = 0;
	boolean low_mission = false;
	int familyCnt = 1;
	String indate = null;
	ArrayList<Integer> pArrayList = new ArrayList<>();
	public void setdate(boolean low_mission,int familyCnt,String indate) {
		this.low_mission = low_mission;
		this.familyCnt = familyCnt;
		this.indate = indate;
	}
	public void setcarId(String carId) {
		this.carId = carId;
	}
	public void discount1() {
		if(low_mission) {
			pay/=2;
		}
	}
	public void info() {
		System.out.println("�����̵� : "+this.carId);
		System.out.println("������� : "+this.pay);
		System.out.println("�������� : "+this.low_mission);
		System.out.println("�������� : "+this.familyCnt);
		System.out.println("��ϳ�¥ : "+this.indate);
	}
	public abstract void discount2();
	public void pay() {
		discount1();
		discount2();
		System.out.println("�������");
		info();
	}
}
