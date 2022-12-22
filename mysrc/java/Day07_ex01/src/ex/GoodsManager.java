package ex;

import java.util.ArrayList;
import java.util.Scanner;

public class GoodsManager {
	ArrayList<Goods> goodsList = new ArrayList<>();
	Scanner in = new Scanner(System.in);

	public void goods_add() {
		Goods goods = new Goods();
		System.out.println("물건이름 입력");
		String name = in.nextLine();
		for(int i = 0;i<goodsList.size();i++) {
			if(goodsList.get(i).name.equals(name)) {
				System.out.println("이미 등록된 물건 이름입니다.");
				return;
			}
		}
		System.out.println("물건단가 입력");
		int price = in.nextInt();
		in.nextLine();
		System.out.println("물건수량 입력");
		int cnt = in.nextInt();
		in.nextLine();
		goods.name=name;
		goods.price=price;
		goods.cnt=cnt;
		goodsList.add(goods);
	}
	public int goods_prt() {
		if(goodsList.size()==0) {
			System.out.println("등록된 물건이 없습니다.");
			return 0;
		}else {
			System.out.println("\t"+"등록된 물건목록");
			for(int i = 0;i<goodsList.size();i++) {
				System.out.println("물건번호 : "+i);
				goodsList.get(i).goods_prt();
			}
			return 1;
		}
	}
	public void goods_modify() {
		System.out.println("수정할 물건 번호");
		int a = in.nextInt();
		in.nextLine();
		if(a>=goodsList.size()) {
			System.out.println("수정할 물건번호가 존재하지 않습니다.");
			return;
		}
		System.out.println("1. 물건이름 수정");
		System.out.println("2. 단가 수정");
		System.out.println("3. 수량 수정");
		int b = in.nextInt();
		in.nextLine();
		if(b==1) {
			System.out.println("새로운 물건이름 입력");
			String name = in.nextLine();
			for(int i = 0;i<goodsList.size();i++) {
				if(goodsList.get(i).name.equals(name)) {
					System.out.println("이미 등록된 물건 이름입니다.");
					return;
				}
			}
			goodsList.get(a).name=name;
			System.out.println("수정 완료");
		}else if(b==2) {
			System.out.println("새로운 단가 입력");
			int price = in.nextInt();
			in.nextLine();
			goodsList.get(a).price=price;
			System.out.println("수정 완료");
		}else if(b==3) {
			System.out.println("새로운 수량 입력");
			int cnt = in.nextInt();
			in.nextLine();
			goodsList.get(a).cnt=cnt;
			System.out.println("수정 완료");
		}
	}
	public void goods_delete() {
		System.out.println("삭제할 물건 번호");
		int a = in.nextInt();
		in.nextLine();
		if(a>=goodsList.size()) {
			System.out.println("삭제할 물건번호가 존재하지 않습니다.");
			return;
		}else if(a<goodsList.size()) {
			goodsList.remove(a);
			System.out.println("삭제완료");
		}
	}
}
