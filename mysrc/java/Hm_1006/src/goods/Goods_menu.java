package goods;

import java.util.Scanner;

public class Goods_menu {
	private Scanner in = new Scanner(System.in);
	private GoodsManager goodsManager = new GoodsManager();
	public void menu() {
		for(;;) {
			System.out.println("1. 물건 등록");
			System.out.println("2. 물건 수정");
			System.out.println("3. 물건 삭제");
			System.out.println("4. 물건 검색");
			System.out.println("5. 재고량 분석");
			System.out.println("6. 뒤로가기");
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
