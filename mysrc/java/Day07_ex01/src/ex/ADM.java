package ex;

import java.util.Scanner;

public class ADM {
	Scanner in = new Scanner(System.in);
	String adm_id = "ADM";
	String adm_pw = "adm";
	MemberManager manager = null;
	MarketMain marketmain = null;
	GoodsManager goodsManager = null;

	public int adm_login() {
		System.out.println("�����ھ��̵� �Է�");
		String id = in.nextLine();
		System.out.println("�����ں�й�ȣ �Է�");
		String pw = in.nextLine();
		if(adm_id.equals(id)&&adm_pw.equals(pw)) {
			System.out.println("������ �α���");
			return 0;
		}else {
			System.out.println("�����ڰ� �ƴմϴ�.");
			return 1;
		}
	}
	public void adm_menu() {
		for(;;) {
			System.out.println("1. ������ ȸ������ �޴�");
			System.out.println("2. ������ ���ǰ��� �޴�");
			System.out.println("3. �α׾ƿ�");
			int a = in.nextInt();
			in.nextLine();
			if(a == 1) {
				adm_member_menu();
			}else if(a == 2) {
				adm_goods_menu();
			}else if(a == 3) {
				return;
			}
		}
	}
	public void adm_goods_menu() {
		for(;;) {
			System.out.println("1. ���� ���");
			System.out.println("2. ��ü ���� ���");
			System.out.println("3. ���� ����");
			System.out.println("4. ���� ����");
			System.out.println("5. ������ü ����");
			System.out.println("6. �ڷΰ���");
			int a = in.nextInt();
			in.nextLine();
			if(a == 1) {
				goodsManager.goods_add();
			}else if(a == 2){
				goodsManager.goods_prt();
			}else if(a == 3){
				goodsManager.goods_modify();
			}else if(a == 4){
				goodsManager.goods_delete();
			}else if(a == 5){
				adm_goodsList_clear();
			}else if( a== 6){
				return;
			}
		}
	}
	public void adm_member_menu() {
		for(;;) {
			System.out.println("1. ȸ�� ���");
			System.out.println("2. ��ü ȸ�� ���");
			System.out.println("3. ȸ�� ���� ����");
			System.out.println("4. ȸ�� ����");
			System.out.println("5. ȸ����ü ����");
			System.out.println("6. �ڷΰ���");
			int a = in.nextInt();
			in.nextLine();
			if(a==1) {
				manager.addmember();
			}else if(a == 2){
				adm_info_prt();
			}else if(a == 3){
				adm_member_modify();
			}else if(a == 4){
				System.out.println("������ ȸ����ȣ �Է�");
				a = in.nextInt();
				in.nextLine();
				adm_member_delete(a);
			}else if(a == 5){
				adm_members_clear();
			}else if(a == 6){
				return;
			}
		}
	}
	public void adm_member_modify() {
		System.out.println("������ ȸ�� ��ȣ �Է�");
		int index = in.nextInt();
		in.nextLine();
		System.out.println("1. ���̵� ����");
		System.out.println("2. ��й�ȣ ����");
		System.out.println("3. �̸� ����");
		System.out.println("4. ���� ����");
		int a = in.nextInt();
		in.nextLine();
		if(a == 1) {
			String id = in.nextLine();
			for(int i = 0;i<manager.members.size();i++) {
				if(manager.members.get(i).id.equals(id)) {
					System.out.println("������ ���̵� �����մϴ�.");
					return;
				}
			}
			manager.members.get(index).id=id;
		}else if(a == 2){
			String pw = in.nextLine();
			manager.members.get(index).pw=pw;
		}else if(a == 3){
			String name = in.nextLine();
			manager.members.get(index).name=name;
		}else if(a == 4){
			int age = in.nextInt();
			in.nextLine();
			manager.members.get(index).age=age;
		}
	}
	public void adm_info_prt() {
		for(int i = 0;i<manager.members.size();i++) {
			System.out.println(i+"�� ȸ�� ����");
			System.out.println("���̵� : "+manager.members.get(i).id);
			System.out.println("��й�ȣ : "+manager.members.get(i).pw);
			System.out.println("�̸� : "+manager.members.get(i).name);
			System.out.println("���� : "+manager.members.get(i).age);
			System.out.println();
		}
	}
	public void adm_member_delete(int a) {
		if(a<manager.members.size()) {
			manager.members.remove(a);
			System.out.println("���� �Ϸ�");
		}else {
			System.out.println("��ġ�ϴ� ȸ����ȣ�� �����ϴ�.");
		}
	}
	public void adm_members_clear() {
		System.out.println("�����ھ��̵� �Է�");
		String id = in.nextLine();
		System.out.println("�����ں�й�ȣ �Է�");
		String pw = in.nextLine();
		if(adm_id.equals(id)&&adm_pw.equals(pw)) {
			System.out.println("1. ��üȸ�� ����");
			System.out.println("2. ���");
			int a = in.nextInt();
			in.nextLine();
			if(a == 1) {
				manager.members.clear();
				System.out.println("�����Ϸ�");
			}else if(a == 2) {
				System.out.println("��ҵǾ����ϴ�");
			}
		}else {
			System.err.println("�����ڰ� �ƴմϴ�");
		}
	}
	public void adm_goodsList_clear() {
		System.out.println("�����ھ��̵� �Է�");
		String id = in.nextLine();
		System.out.println("�����ں�й�ȣ �Է�");
		String pw = in.nextLine();
		if(adm_id.equals(id)&&adm_pw.equals(pw)) {
			System.out.println("1. ��ü ���� ����");
			System.out.println("2. ���");
			int a = in.nextInt();
			in.nextLine();
			if(a == 1) {
				goodsManager.goodsList.clear();
				System.out.println("�����Ϸ�");
			}else if(a == 2) {
				System.out.println("��ҵǾ����ϴ�");
			}
		}else {
			System.err.println("�����ڰ� �ƴմϴ�");
		}
	}
}
