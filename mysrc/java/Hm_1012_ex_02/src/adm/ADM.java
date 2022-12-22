package adm;

import java.util.ArrayList;
import java.util.Scanner;
import dao.FoodDAO_INF;
import dao.KimbapDAO;
import dao.RamenDAO;
import dao.TteokbokkiDAO;
import dto.FoodDTO;
import dto.KimbapDTO;
import dto.RamenDTO;
import dto.TteokbokkiDTO;

public class ADM {
	Scanner in = new Scanner(System.in);
	ArrayList<FoodDTO> list = new ArrayList<>();
	public ADM() {
		while(true) {
			main();
			int input = in.nextInt();
			in.nextLine();
			switch (input) {
			case 1 :
				menu();
				break;
			case 2 :
				ListView();
				break;
			}
		}
	}
	private void main() {
		System.out.println("1. 주문하기");
		System.out.println("2. 주문내역보기");
	}
	private void ListView() {
		for(int i = 0;i<list.size();i++) {
			list.get(i).prt();
		}
	}
	private void menu() {
		FoodDAO_INF dao = null;
		FoodDTO dto = null;
		while(true) {
			Prt();
			int input = in.nextInt();
			in.nextLine();
			switch (input) {
			case 1 :
				dao = new RamenDAO();
				dto = new RamenDTO();
				foodmenu(dao,dto);
				break;
			case 2 :
				dao = new TteokbokkiDAO();
				dto = new TteokbokkiDTO();
				foodmenu(dao,dto);
				break;
			case 3 :
				dao = new KimbapDAO();
				dto = new KimbapDTO();
				foodmenu(dao,dto);
				break;
			case 4 :
				return;
			}
		}
	}
	private void foodmenu(FoodDAO_INF dao,FoodDTO dto) {
		while(true) {
			foodmenuprt();
			int input = in.nextInt();
			in.nextLine();
			switch (input) {
			case 1 :
				dao.info(dto);
				break;
			case 2 :
				list.add(dao.basket(dto));
				break;
			case 3 :
				
				break;
			case 4 :
				return;
			}
		}
	}
	
	private void foodmenuprt() {
		System.out.println("1. 설명보기");
		System.out.println("2. 장바구니에 담기");
		System.out.println("3. 계산하기");
		System.out.println("4. 뒤로가기");
	}
	private void Prt() {
		System.out.println("메뉴선택");
		System.out.println("1. 라면");
		System.out.println("2. 떡볶이");
		System.out.println("3. 김밥");
		System.out.println("4. 뒤로가기");
	}
}
