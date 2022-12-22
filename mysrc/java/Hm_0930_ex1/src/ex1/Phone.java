package ex1;

public abstract class Phone {
	String name = null;
	int cnt = 0;
	int price = 0;
	public abstract void calls();
	public void call() {
		System.out.println("전화걸기");
	}
	public void answer_a_call() {
		System.out.println("전화받기");
	}
	public void prt() {
		System.out.println(name);
		System.out.println(cnt);
		System.out.println(price);
	}
}
