package Market;

import java.util.Scanner;

public class MainMenu {
	Scanner in = new Scanner(System.in);
	GoodsManager gm = new GoodsManager();
	Member nowuser = new Member(gm);
	public void menu() {
		System.out.println("1. ���ǰ���");
		System.out.println("2. �����ϱ�");
	}
	public MainMenu() {
		nowuser.gm1=gm;
		for(;;) {
			menu();
			int selMenu = in.nextInt();
			in.nextLine();
			if(selMenu==1) {
				gm.start();
			}else if(selMenu == 2) {
				nowuser.goshopping();
			}
		}
	}
}
