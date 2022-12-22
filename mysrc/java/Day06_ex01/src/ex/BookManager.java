package ex;

import java.util.Scanner;

public class BookManager {
	Scanner in = new Scanner(System.in);
	String[] badWord = {"바보","멍청이","똥개","말미잘"};
	Book[] books = new Book[10];
	public BookManager() {
		for(;;) {
			menu();
			int input = in.nextInt();
			in.nextLine();
			if(input==1) {
				add();
			}else if(input==2) {
				prt();
			}else if(input==3) {
				search();
			}else if(input==4) {
				System.out.println("수정할 책 검색");
				bookmodify();
			}else if(input==5) {
				del();
			}
		}
	}
	public void menu() {
		System.out.println("1. 책 등록");
		System.out.println("2. 전체 보기");
		System.out.println("3. 책 검색");
		System.out.println("4. 책 정보 수정");
		System.out.println("5. 책 삭제");

	}
	private void add() {
		Book newbook = new Book();
		System.out.println("책이름 입력");
		String name = in.nextLine();
		for(int i = 0;i<badWord.length;i++) {
			if(badWord[i].contains(name)) {
				System.out.println("욕설은 포함할 수 없습니다.");
				return;
			}
		}
		System.out.println("연도입력");
		int year;
		year = in.nextInt();
		in.nextLine();
		System.out.println("작성자 입력");
		String writer = in.nextLine();
		for(int i = 0;i<books.length;i++) {
			if(books[i]==null) {
				newbook.bookInput(i, name, year, writer);
				books[i]=newbook;
				return;
			}
		}
		System.out.println("저장 공간이 부족합니다.");
	}
	public void prt() {
		for(int i = 0;i<books.length;i++) {
			if(books[i]!=null) {
				System.out.println(i+"번 정보------------");
				books[i].bookList();
				System.out.println();
			}
		}
	}
	public void bookmodify() {
		if(search()==0) {
			System.out.println("일치하는 이름이 없습니다.");
			return;
		}
		System.out.println("수정할 책의 고유번호 입력");
		int no=in.nextInt();
		int chk = 0;
		for(int i = 0;i<books.length;i++) {
			if(books[i]!=null&&books[i].no==no) {
				chk++;
			}
		}
		if(chk==0) {
			System.out.println("동일한 고유번호가 없습니다.");
			return;
		}
		System.out.print("수정할 정보"+"\n"+"1.책 제목"+"\n"+"2.연도"+"\n"+"3.작성자"+"\n");
		int a = in.nextInt();
		in.nextLine();
		if(a == 1) {
			System.out.println("새로운 제목 입력");
			String name = in.nextLine();
			for(int i = 0;i<badWord.length;i++) {
				if(badWord[i].contains(name)) {
					System.out.println("욕설은 포함할 수 없습니다.");
					return;
				}
			}
			books[no].name=name;
		}else if(a == 2) {
			System.out.println("새로운 연도입력");
			int year = in.nextInt();
			books[no].year = year;
		}else if(a == 3) {
			System.out.println("새로운 작성자 입력");
			String writer = in.nextLine();
			books[no].writer = writer;
		}

	}
	public int search() {
		System.out.println("책이름 검색");
		int cnt = 0;
		String name = in.nextLine();
		for(int i = 0;i<books.length;i++) {
			if(books[i]!=null&&books[i].name.contains(name)) {
				cnt++;
				System.out.println("고유번호 :"+books[i].no+"\n"+"제목 : "+
						books[i].name+"\n"+"연도 "+books[i].year+"\n"+"작성자 "+books[i].writer+"\n");
			}
		}
		if(cnt==0) {
			return 0;
		}else {
			return 1;
		}
	}
	public void del() {
		System.out.println("삭제할 제목 검색");
		if(search()==0) {
			System.out.println("일치하는 이름이 없습니다.");
			return;
		}
		System.out.println("삭제할 책의 고유번호");
		int no = in.nextInt();
		in.nextLine();
		books[no]=null;
		System.out.println("삭제 되었습니다.");
	}
}
