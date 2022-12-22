package goods;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import db.GoodsDAO;

public class GoodsManager {
	private GoodsDAO goodsDAO = new GoodsDAO();
	private Scanner in = new Scanner(System.in);
	private ArrayList<Goods> list = null;
	public void goodset() {
		Goods goods = new Goods();
		System.out.println("물건아이디를 입력하세요");
		String goods_id = in.nextLine();
		for(;;) {
			if(goodsDAO.find_id(goods_id)!=null) {
				System.out.println("이미 존재하는 아이디 입니다.");
				System.out.println("아이디를 입력하세요");
				goods_id = in.nextLine();
			}else {
				goods.setGoods_id(goods_id);
				break;
			}
		}
		System.out.println("이름을 입력하세요");
		String goods_name = in.nextLine();
		goods.setGoods_name(goods_name);
		System.out.println("수량을 입력하세요");
		int cnt = in.nextInt();
		in.nextLine();
		goods.setCnt(cnt);
		System.out.println("가격을 입력하세요");
		int price = in.nextInt();
		in.nextLine();
		goods.setPrice(price);
		System.out.println("판매자를 입력하세요");
		String seller_name = in.nextLine();
		goods.setSeller_name(seller_name);
		goods.setGoods_date(LocalDate.now());
		goodsDAO.goodsset(goods);
	}
	public void prt() {
		list = goodsDAO.allselect();
		for(Goods goods : list) {
			goods.prt();
		}
	}
	public void mod() {
		String column = null;
		String set = null;
		System.out.println("수정할 물건아이디를 입력하세요");
		String goods_id = in.nextLine();
			if(goodsDAO.find_id(goods_id)==null) {
				System.out.println("존재하지 않는 아이디 입니다.");
				return;
			}
		System.out.println("수정할 정보");
		System.out.println("1. 물건이름");
		System.out.println("2. 수량");
		System.out.println("3. 가격");
		System.out.println("4. 판매자 이름");
		System.out.println("4. 날짜");
		String input = in.nextLine();
		switch(input) {
			case "1" : column = "goods_name";
			System.out.println("새로운 물건이름을 입력하세요");
			set = in.nextLine();
			break;
			case "2" : column = "cnt";
			System.out.println("새로운 수량을 입력하세요");
			set = in.nextLine();
			break;
			case "3" : column = "price";
			System.out.println("새로운 가격을 입력하세요");
			set = in.nextLine();
			break;
			case "4" : column = "seller_name";
			System.out.println("새로운 판매자 이름을 입력하세요");
			set = in.nextLine();
			break;
			case "5" : column = "goods_date";
			System.out.println("새로운 날짜을 입력하세요");
			set = in.nextLine();
			break;
		}
		goodsDAO.mod(column,set,goods_id);
	}
	public void del() {
		System.out.println("삭제할 단어 입력");
		String id = in.nextLine();
		goodsDAO.del(id);
	}
	public void search() {
		System.out.println("검색어입력 (아이디 or 이름)");
		String input = in.nextLine();
		list = goodsDAO.search(input);
		for(Goods goods : list) {
			goods.prt();
		}
	}
	public void avg() {
		System.out.println("수량이 평균이상 남은 물건");
		list = goodsDAO.avg();
		for(Goods goods : list) {
			goods.prt();
		}
	}
}
