package ex;

public class Goods {
	String name = null;
	int price = 0;
	int cnt = 0;
	public void goods_prt() {
		System.out.println("물건 이름 : "+this.name);
		System.out.println("물건 가격 : "+this.price);
		System.out.println("물건 수량 : "+this.cnt);
		System.out.println("---------------------------");
	}
}
