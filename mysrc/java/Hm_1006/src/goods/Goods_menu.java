package goods;

import java.util.Scanner;

public class Goods_menu {
	private Scanner in = new Scanner(System.in);
	private GoodsManager goodsManager = new GoodsManager();
	public void menu() {
		for(;;) {
			System.out.println("1. ���� ���");
			System.out.println("2. ���� ����");
			System.out.println("3. ���� ����");
			System.out.println("4. ���� �˻�");
			System.out.println("5. ��� �м�");
			System.out.println("6. �ڷΰ���");
			String input = in.nextLine();
			switch(input) {
				case "1" : 
					goodsManager.goodset();
					break;
				case "2" : 
					goodsManager.mod();
					break;
				case "3" : 
					goodsManager.del();
					break;
				case "4" : 
					goodsManager.search();
					break;
				case "5" : 
					goodsManager.avg();
					break;
				case "6" :
					return;
			}
		}
	}
}
