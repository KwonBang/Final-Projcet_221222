package member;

import java.util.ArrayList;
import java.util.Scanner;

import db.MemberDAO;

public class MemberManager {
	private MemberDAO memberDAO = new MemberDAO();
	private Scanner in = new Scanner(System.in);
	private ArrayList<Member> list = null;
	public void memberset() {
		Member member = new Member();
		System.out.println("���̵� �Է��ϼ���");
		String id = in.nextLine();
		for(;;) {
			if(memberDAO.find_id(id)!=null) {
				System.out.println("�̹� �����ϴ� ���̵� �Դϴ�.");
				System.out.println("���̵� �Է��ϼ���");
				id = in.nextLine();
			}else {
				member.setId(id);
				break;
			}
		}
		System.out.println("�̸��� �Է��ϼ���");
		String name = in.nextLine();
		member.setName(name);
		System.out.println("��й�ȣ�� �Է��ϼ���");
		String pass = in.nextLine();
		member.setPass(pass);
		System.out.println("�ּҸ� �Է��ϼ���");
		String addr = in.nextLine();
		member.setAddr(addr);
		System.out.println("����Ʈ�� �Է��ϼ���");
		int point = in.nextInt();
		in.nextLine();
		member.setPoint(point);
		memberDAO.memberset(member);

	}
	public void prt() {
		list=memberDAO.allselect();
		for(Member a : list) {
			a.memberinfo();
		}
	}
	public void mod() {
		String column = null;
		String set = null;
		System.out.println("������ ���̵� �Է��ϼ���");
		String id = in.nextLine();
			if(memberDAO.find_id(id)==null) {
				System.out.println("�������� �ʴ� ���̵� �Դϴ�.");
				return;
			}
		System.out.println("������ ����");
		System.out.println("1. �̸�");
		System.out.println("2. ��й�ȣ");
		System.out.println("3. �ּ�");
		System.out.println("4. ����Ʈ");
		String input = in.nextLine();
		switch(input) {
			case "1" : column = "name";
			System.out.println("���ο� �̸��� �Է��ϼ���");
			set = in.nextLine();
			break;
			case "2" : column = "pass";
			System.out.println("���ο� ��й�ȣ�� �Է��ϼ���");
			set = in.nextLine();
			break;
			case "3" : column = "addr";
			System.out.println("���ο� �ּ��� �Է��ϼ���");
			set = in.nextLine();
			break;
			case "4" : column = "point";
			System.out.println("���ο� ����Ʈ�� �Է��ϼ���");
			set = in.nextLine();
			break;
		}
		memberDAO.mod(column,set,id);
	}
	public void del() {
		System.out.println("������ �ܾ� �Է�");
		String id = in.nextLine();
		memberDAO.del(id);
	}
	public void search() {
		System.out.println("�˻����Է� (���̵� or �̸�)");
		String input = in.nextLine();
		list = memberDAO.search(input);
		for(Member member : list) {
			member.memberinfo();
		}
	}
	public Member login() {
		System.out.println("���̵� �Է��ϼ���");
		String id = in.nextLine();
		Member member = memberDAO.find_id(id);
		if(member==null) {
			System.out.println("�������� �ʴ� ���̵� �Դϴ�.");
			return null;
		}else {
			System.out.println("��й�ȣ�� �Է��ϼ���");
			String pass = in.nextLine();
			if(!pass.equals(member.getPass())) {
				System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�.");
				return null;
			}else {
				
				return member;
			}
		}
	}
}
