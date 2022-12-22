package main;

import java.util.ArrayList;

import Parking.Car;
import Parking.CompactCar;
import Parking.Runabout;

public class ParkingM {
	private ArrayList<Car> carlist = new ArrayList<>();
	public ParkingM() {
		Car newCompact = new CompactCar();
		newCompact.setcarId("경차1");
		newCompact.setdate(false, 1, "20220915");
		newCompact.info();
		System.out.println("-----할인후-----");
		newCompact.discount1();
		newCompact.discount2();
		newCompact.info();
		carlist.add(newCompact);
		
		newCompact = new Runabout();
		newCompact.setcarId("소형1");
		newCompact.setdate(true, 1, "20220922");
		newCompact.info();
		System.out.println("-----할인후-----");
		newCompact.discount1();
		newCompact.discount2();
		newCompact.info();
		carlist.add(newCompact);
		
	}
}
