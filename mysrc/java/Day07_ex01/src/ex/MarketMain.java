package ex;

import java.util.Scanner;

public class MarketMain {
	public MarketMain(MemberManager m) {
		manager =m;
	}
	MemberManager manager = null;
	GoodsManager goodsManager = null;
	Scanner in = new Scanner(System.in);
	int login_index = 0;
	public void market_menu() {
		for(;;) {
			System.out.println("1. 구매하기");
			System.out.println("2. 장바구니");
			System.out.println("3. 장바구니 비우기");
			System.out.println("4. 회원정보수정");
			System.out.println("5. 로그아웃");
			int a = in.nextInt();
			in.nextLine();
			if(a==1) {
				if(goodsManager.goods_prt()==0) {
					return;
				}
				goods_basket_in();
			}else if(a==2) {
				manager.members.get(login_index).member_basket();
			}else if(a==3) {
				basket_clear();
			}else if(a==4) {
				System.out.print("비밀번호 : ");
				String pw = in.nextLine();
				if(manager.members.get(login_index).pw.equals(pw)) {
					manager.members.get(login_index).member_info();
					manager.member_modify_info();
				}else {
					System.out.println("비밀번호가 틀렸습니다.");
				}
			}else if(a==5) {
				return;
			}
		}
	}
	public void basket_clear() {
		System.out.println("장바구니를 지우시겠습니까?");
		System.out.println("1. 전체 지우기");
		System.out.println("2. 선택 지우기");
		System.out.println("3. 취소");
		int a = in.nextInt();
		in.nextLine();
		if(a==1) {
			manager.members.get(login_index).basket.clear();
			System.out.println("장바구니가 비워졌습니다.");
		}else if(a==2) {
			manager.members.get(login_index).member_basket();
			System.out.println("비울 장바구니 목록 번호 선택");
			int b = in.nextInt();
			in.nextLine();
			manager.members.get(login_index).basket.remove(b);
			System.out.println("장바구니에서 지워졌습니다, 장바구니 목록 번호가 갱신 되었습니다.");
		}else if(a==3) {
			System.out.println("취소 되었습니다.");
		}
	}
	public void goods_basket_in() {
		System.out.println("장바구니에 담을 물건번호 입력");
		int a = in.nextInt();
		in.nextLine();
		BasketGoods basketGoods = new BasketGoods();
		basketGoods.buyGoods = goodsManager.goodsList.get(a);
		basketGoods.buy_price = goodsManager.goodsList.get(a).price;
		System.out.println("수량 입력");
		int b = in.nextInt();
		in.nextLine();
		basketGoods.buy_cnt=b;
		goodsManager.goodsList.get(a).cnt -= basketGoods.buy_cnt;
		manager.members.get(login_index).basket.add(basketGoods);
	}
}
