package main;

import java.util.Scanner;
import goods.Goods_menu;
import member.Member;
import member.MemberManager;
import member.Member_menu;
import shopping.Shopping_menu;

public class MainMenu {
	private Scanner in = new Scanner(System.in);
	private Member_menu member_menu = new Member_menu();
	private Goods_menu goods_menu = new Goods_menu();
	private Shopping_menu shopping_menu = new Shopping_menu();
	private MemberManager memberManager = new MemberManager();
	public MainMenu() {
		for(;;) {
			System.out.println("1. 고객 관리");
			System.out.println("2. 물건 관리");
			System.out.println("3. 쇼핑");
			String input = in.nextLine();
			switch (input) {
			case "1":
				member_menu.menu();
				break;
			case "2":
				goods_menu.menu();
				break;
			case "3":
				System.out.println("로그인");
				Member member = memberManager.login();
				if(member!=null) {
					shopping_menu.shoppingmenu(member);
					break;
				}else {
					break;
				}
			}
		}
	}
}
