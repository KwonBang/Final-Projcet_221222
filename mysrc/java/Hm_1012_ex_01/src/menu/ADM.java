package menu;

import java.util.Scanner;


import dao.Card_INF;
import dao.H_DAO;
import dao.S_DAO;
import dao.W_DAO;
import dto.CardDTO;

public class ADM {
	Scanner in = new Scanner(System.in);
	Card_INF dao = null;
	public ADM() {
		menu();
	}
	public void menu() {
		while(true) {
			System.out.println("ī����� �ý���");
			System.out.println("ī�弱��");
			System.out.println("1. ������");
			System.out.println("2. ���");
			System.out.println("3. �츮����");
			int input = in.nextInt();
			in.nextLine();
			switch(input) {
			case 1 :
				dao = new H_DAO();
				break;
			case 2 :
				dao = new S_DAO();
				break;
			case 3 :
				dao = new W_DAO();
				break;
			}
			pay();
		}
	}
	public void pay() {
		while(true) {
			Prt();
			int input = in.nextInt();
			in.nextLine();
			switch (input ) {
			case 1:
				CardDTO c = new CardDTO();
				dao.pay(c);
				return;
			case 2:
				return;
			}
		}
	}
	private void Prt() {
		System.out.println("1. �����ϱ�");
		System.out.println("2. �ڷΰ���");
	}
}
