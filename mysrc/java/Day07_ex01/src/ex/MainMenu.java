package ex;

import java.util.Scanner;

public class MainMenu {
	ADM adm = new ADM();
	GoodsManager goodsManager = new GoodsManager();
	MemberManager manager = new MemberManager();
	MarketMain marketmain = new MarketMain(manager);
	Scanner in = new Scanner(System.in);
	public MainMenu() {
		marketmain.goodsManager=goodsManager;
		adm.manager=manager;
		adm.marketmain=marketmain;
		adm.goodsManager=goodsManager;
		manager.marketMain=marketmain;
		for(;;) {
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.println("3. 관리자");
			int a = in.nextInt();
			in.nextLine();
			if(a==1) {
				System.out.println("아이디 입력");
				String id = in.nextLine();
				System.out.println("비밀번호 입력");
				String pw = in.nextLine();
				if(manager.login(id, pw)==1) {
					marketmain.market_menu();
				}else if(manager.login(id, pw)==2){
					System.out.println("비밀번호가 틀렸습니다");
				}else if(manager.login(id, pw)==3){
					System.out.println("아이디와 비밀번호가 틀렸습니다.");
				}
			}else if(a==2) {
				manager.addmember();
			}else if(a==3) {
				if(adm.adm_login()==0) {
					adm.adm_menu();
				}
			}
		}
	}
}
