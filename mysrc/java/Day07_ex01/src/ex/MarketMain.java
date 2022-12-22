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
			System.out.println("1. �����ϱ�");
			System.out.println("2. ��ٱ���");
			System.out.println("3. ��ٱ��� ����");
			System.out.println("4. ȸ����������");
			System.out.println("5. �α׾ƿ�");
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
				System.out.print("��й�ȣ : ");
				String pw = in.nextLine();
				if(manager.members.get(login_index).pw.equals(pw)) {
					manager.members.get(login_index).member_info();
					manager.member_modify_info();
				}else {
					System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�.");
				}
			}else if(a==5) {
				return;
			}
		}
	}
	public void basket_clear() {
		System.out.println("��ٱ��ϸ� ����ðڽ��ϱ�?");
		System.out.println("1. ��ü �����");
		System.out.println("2. ���� �����");
		System.out.println("3. ���");
		int a = in.nextInt();
		in.nextLine();
		if(a==1) {
			manager.members.get(login_index).basket.clear();
			System.out.println("��ٱ��ϰ� ��������ϴ�.");
		}else if(a==2) {
			manager.members.get(login_index).member_basket();
			System.out.println("��� ��ٱ��� ��� ��ȣ ����");
			int b = in.nextInt();
			in.nextLine();
			manager.members.get(login_index).basket.remove(b);
			System.out.println("��ٱ��Ͽ��� ���������ϴ�, ��ٱ��� ��� ��ȣ�� ���� �Ǿ����ϴ�.");
		}else if(a==3) {
			System.out.println("��� �Ǿ����ϴ�.");
		}
	}
	public void goods_basket_in() {
		System.out.println("��ٱ��Ͽ� ���� ���ǹ�ȣ �Է�");
		int a = in.nextInt();
		in.nextLine();
		BasketGoods basketGoods = new BasketGoods();
		basketGoods.buyGoods = goodsManager.goodsList.get(a);
		basketGoods.buy_price = goodsManager.goodsList.get(a).price;
		System.out.println("���� �Է�");
		int b = in.nextInt();
		in.nextLine();
		basketGoods.buy_cnt=b;
		goodsManager.goodsList.get(a).cnt -= basketGoods.buy_cnt;
		manager.members.get(login_index).basket.add(basketGoods);
	}
}
