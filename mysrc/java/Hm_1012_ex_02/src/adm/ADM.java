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
		System.out.println("1. �ֹ��ϱ�");
		System.out.println("2. �ֹ���������");
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
		System.out.println("1. ������");
		System.out.println("2. ��ٱ��Ͽ� ���");
		System.out.println("3. ����ϱ�");
		System.out.println("4. �ڷΰ���");
	}
	private void Prt() {
		System.out.println("�޴�����");
		System.out.println("1. ���");
		System.out.println("2. ������");
		System.out.println("3. ���");
		System.out.println("4. �ڷΰ���");
	}
}
