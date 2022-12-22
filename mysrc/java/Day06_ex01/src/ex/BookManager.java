package ex;

import java.util.Scanner;

public class BookManager {
	Scanner in = new Scanner(System.in);
	String[] badWord = {"�ٺ�","��û��","�˰�","������"};
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
				System.out.println("������ å �˻�");
				bookmodify();
			}else if(input==5) {
				del();
			}
		}
	}
	public void menu() {
		System.out.println("1. å ���");
		System.out.println("2. ��ü ����");
		System.out.println("3. å �˻�");
		System.out.println("4. å ���� ����");
		System.out.println("5. å ����");

	}
	private void add() {
		Book newbook = new Book();
		System.out.println("å�̸� �Է�");
		String name = in.nextLine();
		for(int i = 0;i<badWord.length;i++) {
			if(badWord[i].contains(name)) {
				System.out.println("�弳�� ������ �� �����ϴ�.");
				return;
			}
		}
		System.out.println("�����Է�");
		int year;
		year = in.nextInt();
		in.nextLine();
		System.out.println("�ۼ��� �Է�");
		String writer = in.nextLine();
		for(int i = 0;i<books.length;i++) {
			if(books[i]==null) {
				newbook.bookInput(i, name, year, writer);
				books[i]=newbook;
				return;
			}
		}
		System.out.println("���� ������ �����մϴ�.");
	}
	public void prt() {
		for(int i = 0;i<books.length;i++) {
			if(books[i]!=null) {
				System.out.println(i+"�� ����------------");
				books[i].bookList();
				System.out.println();
			}
		}
	}
	public void bookmodify() {
		if(search()==0) {
			System.out.println("��ġ�ϴ� �̸��� �����ϴ�.");
			return;
		}
		System.out.println("������ å�� ������ȣ �Է�");
		int no=in.nextInt();
		int chk = 0;
		for(int i = 0;i<books.length;i++) {
			if(books[i]!=null&&books[i].no==no) {
				chk++;
			}
		}
		if(chk==0) {
			System.out.println("������ ������ȣ�� �����ϴ�.");
			return;
		}
		System.out.print("������ ����"+"\n"+"1.å ����"+"\n"+"2.����"+"\n"+"3.�ۼ���"+"\n");
		int a = in.nextInt();
		in.nextLine();
		if(a == 1) {
			System.out.println("���ο� ���� �Է�");
			String name = in.nextLine();
			for(int i = 0;i<badWord.length;i++) {
				if(badWord[i].contains(name)) {
					System.out.println("�弳�� ������ �� �����ϴ�.");
					return;
				}
			}
			books[no].name=name;
		}else if(a == 2) {
			System.out.println("���ο� �����Է�");
			int year = in.nextInt();
			books[no].year = year;
		}else if(a == 3) {
			System.out.println("���ο� �ۼ��� �Է�");
			String writer = in.nextLine();
			books[no].writer = writer;
		}

	}
	public int search() {
		System.out.println("å�̸� �˻�");
		int cnt = 0;
		String name = in.nextLine();
		for(int i = 0;i<books.length;i++) {
			if(books[i]!=null&&books[i].name.contains(name)) {
				cnt++;
				System.out.println("������ȣ :"+books[i].no+"\n"+"���� : "+
						books[i].name+"\n"+"���� "+books[i].year+"\n"+"�ۼ��� "+books[i].writer+"\n");
			}
		}
		if(cnt==0) {
			return 0;
		}else {
			return 1;
		}
	}
	public void del() {
		System.out.println("������ ���� �˻�");
		if(search()==0) {
			System.out.println("��ġ�ϴ� �̸��� �����ϴ�.");
			return;
		}
		System.out.println("������ å�� ������ȣ");
		int no = in.nextInt();
		in.nextLine();
		books[no]=null;
		System.out.println("���� �Ǿ����ϴ�.");
	}
}
