package db;

import java.time.LocalDate;

public class GoodsDTO {
	private String goods_id = null;
	private String goods_name = null;
	private int cnt = 0;
	private int price = 0;
	private String seller_name = null;	
	private LocalDate goods_date = LocalDate.now();
	public void prt() {
		System.out.println("물건 아이디 : "+goods_id);
		System.out.println("물건 이름 : "+goods_name);
		System.out.println("물건 수량 : "+cnt);
		System.out.println("물건 가격 : "+price);
		System.out.println("판매자 이름 : "+seller_name);
		System.out.println("날짜 : "+goods_date);
	}
	public String getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(String goods_id) {
		this.goods_id = goods_id;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
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
	public String getSeller_name() {
		return seller_name;
	}
	public void setSeller_name(String seller_name) {
		this.seller_name = seller_name;
	}
	public LocalDate getGoods_date() {
		return goods_date;
	}
	public void setGoods_date(LocalDate goods_date) {
		this.goods_date = goods_date;
	}
}
