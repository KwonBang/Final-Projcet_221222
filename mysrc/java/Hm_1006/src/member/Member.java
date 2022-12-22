package member;

import java.util.ArrayList;

import shopping.Basket;

public class Member {
	private String id = null;
	private String name = null;
	private String pass = null;
	private String addr = null;
	private int point = 0;
	private ArrayList<Basket> basketList= new ArrayList<>();
	
	public ArrayList<Basket> getBasketList() {
		return basketList;
	}
	public void setBasketList(ArrayList<Basket> basketList) {
		this.basketList = basketList;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public void memberinfo() {
		System.out.println("-----------------------");
		System.out.println("이아디 : "+id);
		System.out.println("이름 : "+name);
		System.out.println("비밀번호 : "+pass);
		System.out.println("주소 : "+addr);
		System.out.println("포인트 : "+point);
	}
}
