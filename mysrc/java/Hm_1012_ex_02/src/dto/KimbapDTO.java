package dto;

public class KimbapDTO extends FoodDTO{
	private String info = "옆구리가 터져야 제맛이지";
	private String name = null;
	private int cnt = 0;
	private int price = 0;
	@Override
	public void prt() {
		System.out.println("설명 : "+info);
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public void basketprt() {
		System.out.println("설명 : "+info);
		System.out.println("김밥이름 : "+name);
		System.out.println(cnt+"줄");
		System.out.println("가격 : "+price);
	}
}
