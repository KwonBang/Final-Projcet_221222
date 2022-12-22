package ex;

import java.util.ArrayList;
import java.util.Scanner;

public class GoodsManager {
	ArrayList<Goods> goodsList = new ArrayList<>();
	Scanner in = new Scanner(System.in);

	public void goods_add() {
		Goods goods = new Goods();
		System.out.println("�����̸� �Է�");
		String name = in.nextLine();
		for(int i = 0;i<goodsList.size();i++) {
			if(goodsList.get(i).name.equals(name)) {
				System.out.println("�̹� ��ϵ� ���� �̸��Դϴ�.");
				return;
			}
		}
		System.out.println("���Ǵܰ� �Է�");
		int price = in.nextInt();
		in.nextLine();
		System.out.println("���Ǽ��� �Է�");
		int cnt = in.nextInt();
		in.nextLine();
		goods.name=name;
		goods.price=price;
		goods.cnt=cnt;
		goodsList.add(goods);
	}
	public int goods_prt() {
		if(goodsList.size()==0) {
			System.out.println("��ϵ� ������ �����ϴ�.");
			return 0;
		}else {
			System.out.println("\t"+"��ϵ� ���Ǹ��");
			for(int i = 0;i<goodsList.size();i++) {
				System.out.println("���ǹ�ȣ : "+i);
				goodsList.get(i).goods_prt();
			}
			return 1;
		}
	}
	public void goods_modify() {
		System.out.println("������ ���� ��ȣ");
		int a = in.nextInt();
		in.nextLine();
		if(a>=goodsList.size()) {
			System.out.println("������ ���ǹ�ȣ�� �������� �ʽ��ϴ�.");
			return;
		}
		System.out.println("1. �����̸� ����");
		System.out.println("2. �ܰ� ����");
		System.out.println("3. ���� ����");
		int b = in.nextInt();
		in.nextLine();
		if(b==1) {
			System.out.println("���ο� �����̸� �Է�");
			String name = in.nextLine();
			for(int i = 0;i<goodsList.size();i++) {
				if(goodsList.get(i).name.equals(name)) {
					System.out.println("�̹� ��ϵ� ���� �̸��Դϴ�.");
					return;
				}
			}
			goodsList.get(a).name=name;
			System.out.println("���� �Ϸ�");
		}else if(b==2) {
			System.out.println("���ο� �ܰ� �Է�");
			int price = in.nextInt();
			in.nextLine();
			goodsList.get(a).price=price;
			System.out.println("���� �Ϸ�");
		}else if(b==3) {
			System.out.println("���ο� ���� �Է�");
			int cnt = in.nextInt();
			in.nextLine();
			goodsList.get(a).cnt=cnt;
			System.out.println("���� �Ϸ�");
		}
	}
	public void goods_delete() {
		System.out.println("������ ���� ��ȣ");
		int a = in.nextInt();
		in.nextLine();
		if(a>=goodsList.size()) {
			System.out.println("������ ���ǹ�ȣ�� �������� �ʽ��ϴ�.");
			return;
		}else if(a<goodsList.size()) {
			goodsList.remove(a);
			System.out.println("�����Ϸ�");
		}
	}
}
