package tr;

import java.util.Scanner;

public class Menu {
	private Word_study word_study = new Word_study();
	private Scanner in = new Scanner(System.in);
	private Word word = null;
	public Menu() {
		this.word=word_study.addr();
	}
	public void word_menu() {
		String key = null;
		for(;;) {
			System.out.println("\t"+"����ܾ���"+"\t");
			System.out.println("1. �ܾ� ����");
			System.out.println("2. �ܾ� �˻�");
			System.out.println("3. �ܾ� ����");
			System.out.println("4. �ܾ� ����");
			System.out.println("5. �ܾ� ��ü����");
			System.out.println("6. ����� �ܾ� ���� ����");
			System.out.println("7. ���θ޴���");
			int num = in.nextInt();
			in.nextLine();
			if(num==1) {
				word.set_word();
			}else if(num==2) {
				System.out.println("�˻��� �ܾ� �Է�");
				key = in.nextLine();
				word.search_word(key);
			}else if(num==3) {
				word.modify_word();
			}else if(num==4) {
				System.out.println("������ �ܾ� �Է�");
				key = in.nextLine();
				word.delete_word(key);
			}else if(num==5) {
				word.prt_word();
			}else if(num==6) {
				word.size_word();
			}else if(num==7) {
				return;
			}
		}
	}
	public void main_menu() {
		for(;;) {
			System.out.println("1. �ܾ� ���� �޴�");
			System.out.println("2. �ܾ� �����ϱ�");
			int num = in.nextInt();
			in.nextLine();
			if(num==1) {
				word_menu();
			}else if(num==2) {
				word_study.random_list();
			}else if(num==3) {
				word_study.study();
			}
		}
	}
}
