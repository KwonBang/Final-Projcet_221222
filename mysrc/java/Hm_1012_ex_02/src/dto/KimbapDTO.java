package dto;

public class KimbapDTO extends FoodDTO{
	private String info = "�������� ������ ��������";
	private String name = null;
	private int cnt = 0;
	private int price = 0;
	@Override
	public void prt() {
		System.out.println("���� : "+info);
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
		System.out.println("���� : "+info);
		System.out.println("����̸� : "+name);
		System.out.println(cnt+"��");
		System.out.println("���� : "+price);
	}
}
