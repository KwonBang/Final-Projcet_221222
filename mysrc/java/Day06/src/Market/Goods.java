package Market;
//물건 한개를 의미하는 객체
public class Goods {
	String name = null;
	String id = null;
	int cnt = 0;
	int price = 0;
	int buy = 0;
	
	public void setting(String name,String id,int cnt,int price) {
		//this는 자기자신의 전역변수를 구분할때 사용하는 키워드
		this.name=name;
		this.id=id;
		this.cnt=cnt;
		this.price=price;
	}
	public void prt() {
		System.out.println("이름 : "+this.name);
		System.out.println("아이디 : "+this.id);
		System.out.println("남은수량 : "+this.cnt);
		System.out.println("단가 : "+this.price);
		System.out.println("장바구니에 담은 수량 : "+this.buy);
	}
}
