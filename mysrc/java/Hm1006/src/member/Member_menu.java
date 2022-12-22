package member;

import java.util.Scanner;

public class Member_menu {
	private Scanner in = new Scanner(System.in);
	private MemberManager manager = new MemberManager();
	public void menu() {
		for(;;) {
			System.out.println("-----회원 관리 메뉴-----");
			System.out.println("1. 고객 등록");
			System.out.println("2. 고객 목록 보기");
			System.out.println("3. 고객 수정");
			System.out.println("4. 고객 삭제");
			System.out.println("5. 고객 검색");
			System.out.println("6. 뒤로가기");
			String input = in.nextLine();
			switch(input) {
				case "1" : manager.memberset();
					break;
				case "2" : manager.prt();
					break;
				case "3" : manager.mod();
					break;
				case "4" : manager.del();
					break;
				case "5" : manager.search();
					break;
				case "6" :
					return;
			}
		}
	}
}
