package ex;

import java.util.ArrayList;

public class Member {
	ArrayList<BasketGoods> basket = new ArrayList<>();
	String id = null;
	String pw = null;
	String name = null;
	int age = 0;
	public void member_info() {
		System.out.println("���̵� : "+this.id);
		System.out.println("��й�ȣ : "+this.pw);
		System.out.println("�̸� : "+this.name);
		System.out.println("���� : "+this.age);
	}
	public void member_basket() {
		System.out.println("��ٱ��� ��� (�� "+basket.size()+"��)");
		for(int i = 0;i<basket.size();i++) {
//			int cnt = 0;
//			for(int j = 0;j<i;j++) {
//				if(basket.get(i).buyGoods.name.equals(basket.get(j).buyGoods.name)) {
//					cnt++;
//				}
//			}
//			if(cnt==0) {
			System.out.println("��ٱ��ϸ�� "+i+"�� ");
			basket.get(i).basketgoods_prt();
//			System.out.println("���ż��� : "+buy_cnt);
			System.out.println("--------------");
			}
//		}
	}
}
