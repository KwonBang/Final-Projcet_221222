package Market;

import java.util.ArrayList;
import java.util.Scanner;

public class Member {
	String name = "Guest";
	ArrayList<Goods> basket = new ArrayList<>();
	Scanner in = new Scanner(System.in);
	GoodsManager gm1 = null;
	public Member(GoodsManager a) {
		gm1=a;
	}
	public void goshopping() {
		for(;;) {
			System.out.println("1.  �����ϱ�");
			System.out.println("2.  ��ٱ���");
			System.out.println("3.  �����޴�");
			int selMenu = in.nextInt();
			in.nextLine();
			if(selMenu==1) {
				shopping();
			}else if(selMenu == 2) {
				basketList();
			}else if(selMenu == 3) {
				break;
			}
		}
	}
	public void shopping() {
		System.out.println("������");
		gm1.listGoods();
		System.out.println("��ٱ��Ͽ� ���� ���ǹ�ȣ �Է�");
		int sel = in.nextInt();
		in.nextLine();
		
		basket.add(gm1.gList.get(sel));
		gm1.gList.get(sel).cnt-=1;
		gm1.gList.get(sel).buy++;
		
		System.out.println("------------------");
	}
	public void basketList() {
		for(int i = 0;i<basket.size();i++) {
				basket.get(i).prt();
		}
			System.out.println("--------------");
		
	}
}
