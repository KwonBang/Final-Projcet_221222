package dto;

public class RamenDTO extends FoodDTO{
	private String info = "���� ���� �����ϻ�, ������ ����� �ϼ�";
	private String name = null;
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
		System.out.println("���� : "+price);
	}
	
}
