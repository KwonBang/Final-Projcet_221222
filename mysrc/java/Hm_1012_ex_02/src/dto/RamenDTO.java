package dto;

public class RamenDTO extends FoodDTO{
	private String info = "면은 그저 시작일뿐, 국물이 라면의 완성";
	private String name = null;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public void basketprt() {
		System.out.println("설명 : "+info);
		System.out.println("라면이름 : "+name);
		System.out.println("가격 : "+price);
	}
	
}
