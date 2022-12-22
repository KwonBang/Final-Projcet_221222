package Market;

import java.util.ArrayList;
import java.util.Scanner;
public class GoodsManager {
	Scanner in = new Scanner(System.in);
	ArrayList<Goods> gList = new ArrayList<>(); 

	GoodsManager(){
		// 물건을 관리 하는 객체 : 물건 등록, 수정, 삭제, 물건1개가를 표현하것이 아닌 물건 전체를 관리하는 클래스
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
		System.out.println("<검색> 이름을 입력하세요");
		String schName = in.nextLine();
		for(int i=0; i < gList.size(); i++) {
			if(gList.get(i).name.equals(schName)) {
				gList.get(i).prt();
				return;
			}
		}
		System.out.println("일치하는 이름이 없습니다");
	}
	private void delGoods() {
		System.out.println("<삭제> 이름을 입력하세요");
		String delName = in.nextLine();
		for(int i=0; i < gList.size(); i++) {
			if(gList.get(i).name.equals(delName)) {
				gList.remove(i);
				System.out.println("삭제 되었습니다.");
				return;
			}
		}
		System.out.println("이름이 없습니다.");
	}
	private void modGoods() {
		// 이름으로 수정하시오.. 이름으로 수정하는데 수량하고 가격만 수정이 가능하다.. 
		System.out.println("<수정> 이름을 입력하세요");
		String modName = in.nextLine();
		for(int i=0; i < gList.size(); i++) {
			if(gList.get(i).name.equals(modName)) {
				System.out.println("수량을 입력하세요");
				int newInt = in.nextInt();
				in.nextLine();
				gList.get(i).cnt=newInt;
				System.out.println("가격을 입력하세요");
				newInt = in.nextInt();
				in.nextLine();
				gList.get(i).price=newInt;
				System.out.println("수정완료.");
				return;
			}
		}
		System.out.println("이름이 없습니다.");
	}
	private void addGoods() {  // 물건추가
		Goods newGoods = new Goods();  // newGoods변수의 값 : 객체의 주소값   
		System.out.println("이름 입력");
		String name = in.nextLine();
		for(int i = 0;i<gList.size();i++) {
			if(gList.get(i).name.equals(name)) {
				System.out.println("동일한 이름이 존재합니다.");
				return;
			}
		}
		System.out.println("아이디입력");
		String id = in.nextLine();
		System.out.println("수량입력");
		int cnt=in.nextInt();
		in.nextLine();
		System.out.println("가격입력");
		int price = in.nextInt();
		in.nextLine();
		newGoods.setting(name, id, cnt, price);
		gList.add(newGoods);
	}
	public void listGoods() {
		for(int i=0; i < gList.size(); i++) {
			System.out.println(i +" 번 정보----");
			gList.get(i).prt();
			System.out.println("-------------");
		}
	}

	private void menu() {
		// TODO Auto-generated method stub
		System.out.println("1.  물건등록");
		System.out.println("2.  전체보기");
		System.out.println("3.  물건수정");
		System.out.println("4.  물건삭제");
		System.out.println("5.  물건검색");
		System.out.println("6.  이전 메뉴");
		System.out.println(">>>> <메뉴선택>");
	}





}