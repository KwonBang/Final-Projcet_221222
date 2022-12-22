package ex;

import java.util.ArrayList;

public class Member {
	ArrayList<BasketGoods> basket = new ArrayList<>();
	String id = null;
	String pw = null;
	String name = null;
	int age = 0;
	public void member_info() {
		System.out.println("아이디 : "+this.id);
		System.out.println("비밀번호 : "+this.pw);
		System.out.println("이름 : "+this.name);
		System.out.println("나이 : "+this.age);
	}
	public void member_basket() {
		System.out.println("장바구니 목록 (총 "+basket.size()+"개)");
		for(int i = 0;i<basket.size();i++) {
//			int cnt = 0;
//			for(int j = 0;j<i;j++) {
//				if(basket.get(i).buyGoods.name.equals(basket.get(j).buyGoods.name)) {
//					cnt++;
//				}
//			}
//			if(cnt==0) {
			System.out.println("장바구니목록 "+i+"번 ");
			basket.get(i).basketgoods_prt();
//			System.out.println("구매수량 : "+buy_cnt);
			System.out.println("--------------");
			}
//		}
	}
}
