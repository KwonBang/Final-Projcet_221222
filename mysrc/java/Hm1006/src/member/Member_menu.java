package member;

import java.util.Scanner;

public class Member_menu {
	private Scanner in = new Scanner(System.in);
	private MemberManager manager = new MemberManager();
	public void menu() {
		for(;;) {
			System.out.println("-----ȸ�� ���� �޴�-----");
			System.out.println("1. �� ���");
			System.out.println("2. �� ��� ����");
			System.out.println("3. �� ����");
			System.out.println("4. �� ����");
			System.out.println("5. �� �˻�");
			System.out.println("6. �ڷΰ���");
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
