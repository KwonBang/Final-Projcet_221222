package dto;

public class TteokbokkiDTO extends FoodDTO{
	private String info = "���� ������ �ϳ� �� �������� ��������~";
	private String name = null;
	private String spicy = null;
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
	public String getSpicy() {
		return spicy;
	}
	public void setSpicy(String spicy) {
		this.spicy = spicy;
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
		System.out.println("������ : "+name);
		System.out.println("�ʱ� : "+spicy);
		System.out.println(cnt+"�κ�");
		System.out.println("���� : "+price);
	}
}
