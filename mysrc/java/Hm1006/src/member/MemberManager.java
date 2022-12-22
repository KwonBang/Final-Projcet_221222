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
		System.out.println("아이디를 입력하세요");
		String id = in.nextLine();
		for(;;) {
			if(memberDAO.find_id(id)!=null) {
				System.out.println("이미 존재하는 아이디 입니다.");
				System.out.println("아이디를 입력하세요");
				id = in.nextLine();
			}else {
				member.setId(id);
				break;
			}
		}
		System.out.println("이름를 입력하세요");
		String name = in.nextLine();
		member.setName(name);
		System.out.println("비밀번호를 입력하세요");
		String pass = in.nextLine();
		member.setPass(pass);
		System.out.println("주소를 입력하세요");
		String addr = in.nextLine();
		member.setAddr(addr);
		System.out.println("포인트를 입력하세요");
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
		System.out.println("수정할 아이디를 입력하세요");
		String id = in.nextLine();
			if(memberDAO.find_id(id)==null) {
				System.out.println("존재하지 않는 아이디 입니다.");
				return;
			}
		System.out.println("수정할 정보");
		System.out.println("1. 이름");
		System.out.println("2. 비밀번호");
		System.out.println("3. 주소");
		System.out.println("4. 포인트");
		String input = in.nextLine();
		switch(input) {
			case "1" : column = "name";
			System.out.println("새로운 이름을 입력하세요");
			set = in.nextLine();
			break;
			case "2" : column = "pass";
			System.out.println("새로운 비밀번호을 입력하세요");
			set = in.nextLine();
			break;
			case "3" : column = "addr";
			System.out.println("새로운 주소을 입력하세요");
			set = in.nextLine();
			break;
			case "4" : column = "point";
			System.out.println("새로운 포인트을 입력하세요");
			set = in.nextLine();
			break;
		}
		memberDAO.mod(column,set,id);
	}
	public void del() {
		System.out.println("삭제할 단어 입력");
		String id = in.nextLine();
		memberDAO.del(id);
	}
	public void search() {
		System.out.println("검색어입력 (아이디 or 이름)");
		String input = in.nextLine();
		list = memberDAO.search(input);
		for(Member member : list) {
			member.memberinfo();
		}
	}
	public Member login() {
		System.out.println("아이디를 입력하세요");
		String id = in.nextLine();
		Member member = memberDAO.find_id(id);
		if(member==null) {
			System.out.println("존재하지 않는 아이디 입니다.");
			return null;
		}else {
			System.out.println("비밀번호를 입력하세요");
			String pass = in.nextLine();
			if(!pass.equals(member.getPass())) {
				System.out.println("비밀번호가 틀렸습니다.");
				return null;
			}else {
				
				return member;
			}
		}
	}
}
