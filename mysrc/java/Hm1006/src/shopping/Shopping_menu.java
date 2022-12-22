package shopping;

import goods.GoodsManager;
import member.Member;

import java.util.Scanner;
public class Shopping_menu extends GoodsManager{
	private Scanner in = new Scanner(System.in);
	private Member login_member = null;
	public void shoppingmenu(Member member) {
		this.login_member = member;
		for(;;) {
			System.out.println("1. 쇼핑하기");
			System.out.println("2. 장바구니");
			System.out.println("3. 뒤로가기");
			String input = in.nextLine();
			switch(input) {
			case "1" :
				prt();
				
				break;
			case "2" :
				
				break;
			case "3" : 
				return;
			}
		}
	}
}
