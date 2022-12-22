package extends_ex1;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<Child_M> child_Ms = new ArrayList<>();
		ArrayList<Child_W> child_Ws = new ArrayList<>();
		//남자2, 여자2
		Child_M cm1 = new Child_M();
		cm1.name = "silverSoo";
		cm1.prt();
		cm1.eatting();
		Child_M cm2 = new Child_M();
		Child_W cw1 = new Child_W();
		cw1.name = "silverSoo";
		cw1.prt();
		cw1.eatting();
		Child_W cw2 = new Child_W();
	}

}
