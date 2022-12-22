package ex;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberManager {
	Scanner in = new Scanner(System.in);
	ArrayList<Member> members = new ArrayList<>();
	MarketMain marketMain = null;
	public void addmember() {
		Member m = new Member();
		System.out.println("id입력");
		String id = in.nextLine();
		for(int i = 0;i<members.size();i++) {
			if(members.get(i).id.equals(id)) {
				System.out.println("동일한 아이디가 존재합니다.");
				return;
			}
		}
		System.out.println("비밀번호입력");
		String pw = in.nextLine();
		System.out.println("이름입력");
		String name = in.nextLine();
		System.out.println("나이입력");
		int age = in.nextInt();
		in.nextLine();
		m.id = id;
		m.pw = pw;
		m.name = name;
		m.age = age;
		members.add(m);
		System.out.println("회원가입 완료");
	}
	public void member_modify_info() {
		System.out.println("1. 비밀번호 수정");
		System.out.println("2. 이름 수정");
		System.out.println("3. 나이 수정");
		int a = in.nextInt();
		in.nextLine();
		if(a==1) {
			System.out.println("새로운 비밀번호 입력");
			String pw = in.nextLine();
			members.get(marketMain.login_index).pw=pw;
			System.out.println("수정 완료");
		}else if(a==2) {
			System.out.println("새로운 이름 입력");
			String name = in.nextLine();
			members.get(marketMain.login_index).name = name;
			System.out.println("수정 완료");
		}else if(a==3) {
			System.out.println("새로운 나이 입력");
			int age = in.nextInt();
			in.nextLine();
			members.get(marketMain.login_index).age = age;
			System.out.println("수정 완료");
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
