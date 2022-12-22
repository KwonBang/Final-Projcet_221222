package ex1;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Samsung samsung = new Samsung();
		Iphone iphone = new Iphone();
		samsung.name = "»ï¼º";
		samsung.cnt = 1;
		samsung.price = 100;
		samsung.prt();
		samsung.call();
		samsung.answer_a_call();
		iphone.name = "¾ÖÇÃ";
		iphone.cnt = 1;
		iphone.price = 1000;
		iphone.prt();
		iphone.call();
		iphone.answer_a_call();
		iphone.blocknum();
		ArrayList<Phone> pList = new ArrayList<>();
		Phone ip1 = new Iphone();
		Phone smp1 = new Samsung();
		ip1.name = "IÆù";
		smp1.name = "»ï¼º";
		pList.add(ip1);
		pList.add(smp1);
		for(Phone i : pList) {
			i.prt();
		}
	}

}
