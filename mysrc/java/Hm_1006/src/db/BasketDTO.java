package db;

import java.time.LocalDate;

public class BasketDTO {
	private String goods_id = null;
	private int cnt = 0;
	private LocalDate basket_date = LocalDate.now();
	public LocalDate getBasket_date() {
		return basket_date;
	}
	public void setBasket_date(LocalDate basket_date) {
		this.basket_date = basket_date;
	}
	public String getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(String goods_id) {
		this.goods_id = goods_id;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
}
