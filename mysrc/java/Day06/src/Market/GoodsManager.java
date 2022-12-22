package Market;

import java.util.ArrayList;
import java.util.Scanner;
public class GoodsManager {
	Scanner in = new Scanner(System.in);
	ArrayList<Goods> gList = new ArrayList<>(); 

	GoodsManager(){
		// ������ ���� �ϴ� ��ü : ���� ���, ����, ����, ����1������ ǥ���ϰ��� �ƴ� ���� ��ü�� �����ϴ� Ŭ����
		/*for(;;) {
			menu();
			int selMenu= in.nextInt();
			in.nextLine();
			if(selMenu==1) {
				addGoods();
			}else if(selMenu == 2) {
				listGoods();
			}else if(selMenu == 3) {
				modGoods();
			}else if(selMenu == 4) {
				delGoods();
			}else if(selMenu == 5) {
				searchGoods();
			}else if(selMenu == 6) {
				break;
			}
		}*/
	}
	public void start() {
		for(;;) {
			menu();
			int selMenu= in.nextInt();
			in.nextLine();
			if(selMenu==1) {
				addGoods();
			}else if(selMenu == 2) {
				listGoods();
			}else if(selMenu == 3) {
				modGoods();
			}else if(selMenu == 4) {
				delGoods();
			}else if(selMenu == 5) {
				searchGoods();
			}else if(selMenu == 6) {
				break;
			}
		}
	}
	private void searchGoods() {
		System.out.println("<�˻�> �̸��� �Է��ϼ���");
		String schName = in.nextLine();
		for(int i=0; i < gList.size(); i++) {
			if(gList.get(i).name.equals(schName)) {
				gList.get(i).prt();
				return;
			}
		}
		System.out.println("��ġ�ϴ� �̸��� �����ϴ�");
	}
	private void delGoods() {
		System.out.println("<����> �̸��� �Է��ϼ���");
		String delName = in.nextLine();
		for(int i=0; i < gList.size(); i++) {
			if(gList.get(i).name.equals(delName)) {
				gList.remove(i);
				System.out.println("���� �Ǿ����ϴ�.");
				return;
			}
		}
		System.out.println("�̸��� �����ϴ�.");
	}
	private void modGoods() {
		// �̸����� �����Ͻÿ�.. �̸����� �����ϴµ� �����ϰ� ���ݸ� ������ �����ϴ�.. 
		System.out.println("<����> �̸��� �Է��ϼ���");
		String modName = in.nextLine();
		for(int i=0; i < gList.size(); i++) {
			if(gList.get(i).name.equals(modName)) {
				System.out.println("������ �Է��ϼ���");
				int newInt = in.nextInt();
				in.nextLine();
				gList.get(i).cnt=newInt;
				System.out.println("������ �Է��ϼ���");
				newInt = in.nextInt();
				in.nextLine();
				gList.get(i).price=newInt;
				System.out.println("�����Ϸ�.");
				return;
			}
		}
		System.out.println("�̸��� �����ϴ�.");
	}
	private void addGoods() {  // �����߰�
		Goods newGoods = new Goods();  // newGoods������ �� : ��ü�� �ּҰ�   
		System.out.println("�̸� �Է�");
		String name = in.nextLine();
		for(int i = 0;i<gList.size();i++) {
			if(gList.get(i).name.equals(name)) {
				System.out.println("������ �̸��� �����մϴ�.");
				return;
			}
		}
		System.out.println("���̵��Է�");
		String id = in.nextLine();
		System.out.println("�����Է�");
		int cnt=in.nextInt();
		in.nextLine();
		System.out.println("�����Է�");
		int price = in.nextInt();
		in.nextLine();
		newGoods.setting(name, id, cnt, price);
		gList.add(newGoods);
	}
	public void listGoods() {
		for(int i=0; i < gList.size(); i++) {
			System.out.println(i +" �� ����----");
			gList.get(i).prt();
			System.out.println("-------------");
		}
	}

	private void menu() {
		// TODO Auto-generated method stub
		System.out.println("1.  ���ǵ��");
		System.out.println("2.  ��ü����");
		System.out.println("3.  ���Ǽ���");
		System.out.println("4.  ���ǻ���");
		System.out.println("5.  ���ǰ˻�");
		System.out.println("6.  ���� �޴�");
		System.out.println(">>>> <�޴�����>");
	}





}