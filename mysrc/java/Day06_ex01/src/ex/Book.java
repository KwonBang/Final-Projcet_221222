package ex;

public class Book {
	int no = 0;
	String name = null;
	int year = 0;
	String writer = null;
	public void bookInput(int no,String name,int year,String writer) {
		this.no=no;
		this.name=name;
		this.year=year;
		this.writer=writer;
	}
	public void bookList() {
		System.out.println("고유번호 : "+this.no);
		System.out.println("책이름 : "+this.name);
		System.out.println("연도 : "+this.year);
		System.out.println("작성자 : "+this.writer);
	}
	
}
