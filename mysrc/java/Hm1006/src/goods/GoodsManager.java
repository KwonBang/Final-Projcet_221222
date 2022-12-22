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
		System.out.println("���Ǿ��̵� �Է��ϼ���");
		String goods_id = in.nextLine();
		for(;;) {
			if(goodsDAO.find_id(goods_id)!=null) {
				System.out.println("�̹� �����ϴ� ���̵� �Դϴ�.");
				System.out.println("���̵� �Է��ϼ���");
				goods_id = in.nextLine();
			}else {
				goods.setGoods_id(goods_id);
				break;
			}
		}
		System.out.println("�̸��� �Է��ϼ���");
		String goods_name = in.nextLine();
		goods.setGoods_name(goods_name);
		System.out.println("������ �Է��ϼ���");
		int cnt = in.nextInt();
		in.nextLine();
		goods.setCnt(cnt);
		System.out.println("������ �Է��ϼ���");
		int price = in.nextInt();
		in.nextLine();
		goods.setPrice(price);
		System.out.println("�Ǹ��ڸ� �Է��ϼ���");
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
		System.out.println("������ ���Ǿ��̵� �Է��ϼ���");
		String goods_id = in.nextLine();
			if(goodsDAO.find_id(goods_id)==null) {
				System.out.println("�������� �ʴ� ���̵� �Դϴ�.");
				return;
			}
		System.out.println("������ ����");
		System.out.println("1. �����̸�");
		System.out.println("2. ����");
		System.out.println("3. ����");
		System.out.println("4. �Ǹ��� �̸�");
		System.out.println("4. ��¥");
		String input = in.nextLine();
		switch(input) {
			case "1" : column = "goods_name";
			System.out.println("���ο� �����̸��� �Է��ϼ���");
			set = in.nextLine();
			break;
			case "2" : column = "cnt";
			System.out.println("���ο� ������ �Է��ϼ���");
			set = in.nextLine();
			break;
			case "3" : column = "price";
			System.out.println("���ο� ������ �Է��ϼ���");
			set = in.nextLine();
			break;
			case "4" : column = "seller_name";
			System.out.println("���ο� �Ǹ��� �̸��� �Է��ϼ���");
			set = in.nextLine();
			break;
			case "5" : column = "goods_date";
			System.out.println("���ο� ��¥�� �Է��ϼ���");
			set = in.nextLine();
			break;
		}
		goodsDAO.mod(column,set,goods_id);
	}
	public void del() {
		System.out.println("������ �ܾ� �Է�");
		String id = in.nextLine();
		goodsDAO.del(id);
	}
	public void search() {
		System.out.println("�˻����Է� (���̵� or �̸�)");
		String input = in.nextLine();
		list = goodsDAO.search(input);
		for(Goods goods : list) {
			goods.prt();
		}
	}
	public void avg() {
		System.out.println("������ ����̻� ���� ����");
		list = goodsDAO.avg();
		for(Goods goods : list) {
			goods.prt();
		}
	}
}
