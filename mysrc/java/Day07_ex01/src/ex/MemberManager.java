package ex;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberManager {
	Scanner in = new Scanner(System.in);
	ArrayList<Member> members = new ArrayList<>();
	MarketMain marketMain = null;
	public void addmember() {
		Member m = new Member();
		System.out.println("id�Է�");
		String id = in.nextLine();
		for(int i = 0;i<members.size();i++) {
			if(members.get(i).id.equals(id)) {
				System.out.println("������ ���̵� �����մϴ�.");
				return;
			}
		}
		System.out.println("��й�ȣ�Է�");
		String pw = in.nextLine();
		System.out.println("�̸��Է�");
		String name = in.nextLine();
		System.out.println("�����Է�");
		int age = in.nextInt();
		in.nextLine();
		m.id = id;
		m.pw = pw;
		m.name = name;
		m.age = age;
		members.add(m);
		System.out.println("ȸ������ �Ϸ�");
	}
	public void member_modify_info() {
		System.out.println("1. ��й�ȣ ����");
		System.out.println("2. �̸� ����");
		System.out.println("3. ���� ����");
		int a = in.nextInt();
		in.nextLine();
		if(a==1) {
			System.out.println("���ο� ��й�ȣ �Է�");
			String pw = in.nextLine();
			members.get(marketMain.login_index).pw=pw;
			System.out.println("���� �Ϸ�");
		}else if(a==2) {
			System.out.println("���ο� �̸� �Է�");
			String name = in.nextLine();
			members.get(marketMain.login_index).name = name;
			System.out.println("���� �Ϸ�");
		}else if(a==3) {
			System.out.println("���ο� ���� �Է�");
			int age = in.nextInt();
			in.nextLine();
			members.get(marketMain.login_index).age = age;
			System.out.println("���� �Ϸ�");
		}
	}
	public int login(String id,String pw) {
		int cnt = 0;
		for(int i = 0;i<members.size();i++) {
			if(members.get(i).id.equals(id)&&members.get(i).pw.equals(pw)) {
				cnt=1;
				marketMain.login_index=i;
			}else if(members.get(i).id.equals(id)&&!members.get(i).pw.equals(pw)) {
				cnt=2;
			}
		}
		if(cnt==1) {
			return 1;
		}else if(cnt==2) {
			return 2;
		}else {
			return 3;
		}
	}
}
