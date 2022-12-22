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
			System.out.println("\t"+"영어단어장"+"\t");
			System.out.println("1. 단어 저장");
			System.out.println("2. 단어 검색");
			System.out.println("3. 단어 수정");
			System.out.println("4. 단어 삭제");
			System.out.println("5. 단어 전체보기");
			System.out.println("6. 저장된 단어 갯수 보기");
			System.out.println("7. 메인메뉴로");
			int num = in.nextInt();
			in.nextLine();
			if(num==1) {
				word.set_word();
			}else if(num==2) {
				System.out.println("검색할 단어 입력");
				key = in.nextLine();
				word.search_word(key);
			}else if(num==3) {
				word.modify_word();
			}else if(num==4) {
				System.out.println("삭제할 단어 입력");
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
			System.out.println("1. 단어 관리 메뉴");
			System.out.println("2. 단어 공부하기");
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
