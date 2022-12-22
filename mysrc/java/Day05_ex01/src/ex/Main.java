package ex;

public class Main {

	public static void main(String[] args) {
		Ex01 e = new Ex01();
		e.info();
		System.out.println(e.count());
		e.inprice(1000);
		e.info();
		e.infosave("아이디저장", 20, 2000);
		e.info();
	}

}
