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
		System.out.println("관리자아이디 입력");
		String id = in.nextLine();
		System.out.println("관리자비밀번호 입력");
		String pw = in.nextLine();
		if(adm_id.equals(id)&&adm_pw.equals(pw)) {
			System.out.println("관리자 로그인");
			return 0;
		}else {
			System.out.println("관리자가 아닙니다.");
			return 1;
		}
	}
	public void adm_menu() {
		for(;;) {
			System.out.println("1. 관리자 회원관리 메뉴");
			System.out.println("2. 관리자 물건관리 메뉴");
			System.out.println("3. 로그아웃");
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
			System.out.println("1. 물건 등록");
			System.out.println("2. 전체 물건 목록");
			System.out.println("3. 물건 수정");
			System.out.println("4. 물건 삭제");
			System.out.println("5. 물건전체 삭제");
			System.out.println("6. 뒤로가기");
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
			System.out.println("1. 회원 등록");
			System.out.println("2. 전체 회원 목록");
			System.out.println("3. 회원 정보 수정");
			System.out.println("4. 회원 삭제");
			System.out.println("5. 회원전체 삭제");
			System.out.println("6. 뒤로가기");
			int a = in.nextInt();
			in.nextLine();
			if(a==1) {
				manager.addmember();
			}else if(a == 2){
				adm_info_prt();
			}else if(a == 3){
				adm_member_modify();
			}else if(a == 4){
				System.out.println("삭제할 회원번호 입력");
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
		System.out.println("수정할 회원 번호 입력");
		int index = in.nextInt();
		in.nextLine();
		System.out.println("1. 아이디 수정");
		System.out.println("2. 비밀번호 수정");
		System.out.println("3. 이름 수정");
		System.out.println("4. 나이 수정");
		int a = in.nextInt();
		in.nextLine();
		if(a == 1) {
			String id = in.nextLine();
			for(int i = 0;i<manager.members.size();i++) {
				if(manager.members.get(i).id.equals(id)) {
					System.out.println("동일한 아이디가 존재합니다.");
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
			System.out.println(i+"번 회원 정보");
			System.out.println("아이디 : "+manager.members.get(i).id);
			System.out.println("비밀번호 : "+manager.members.get(i).pw);
			System.out.println("이름 : "+manager.members.get(i).name);
			System.out.println("나이 : "+manager.members.get(i).age);
			System.out.println();
		}
	}
	public void adm_member_delete(int a) {
		if(a<manager.members.size()) {
			manager.members.remove(a);
			System.out.println("삭제 완료");
		}else {
			System.out.println("일치하는 회원번호가 없습니다.");
		}
	}
	public void adm_members_clear() {
		System.out.println("관리자아이디 입력");
		String id = in.nextLine();
		System.out.println("관리자비밀번호 입력");
		String pw = in.nextLine();
		if(adm_id.equals(id)&&adm_pw.equals(pw)) {
			System.out.println("1. 전체회원 삭제");
			System.out.println("2. 취소");
			int a = in.nextInt();
			in.nextLine();
			if(a == 1) {
				manager.members.clear();
				System.out.println("삭제완료");
			}else if(a == 2) {
				System.out.println("취소되었습니다");
			}
		}else {
			System.err.println("관리자가 아닙니다");
		}
	}
	public void adm_goodsList_clear() {
		System.out.println("관리자아이디 입력");
		String id = in.nextLine();
		System.out.println("관리자비밀번호 입력");
		String pw = in.nextLine();
		if(adm_id.equals(id)&&adm_pw.equals(pw)) {
			System.out.println("1. 전체 물건 삭제");
			System.out.println("2. 취소");
			int a = in.nextInt();
			in.nextLine();
			if(a == 1) {
				goodsManager.goodsList.clear();
				System.out.println("삭제완료");
			}else if(a == 2) {
				System.out.println("취소되었습니다");
			}
		}else {
			System.err.println("관리자가 아닙니다");
		}
	}
}
