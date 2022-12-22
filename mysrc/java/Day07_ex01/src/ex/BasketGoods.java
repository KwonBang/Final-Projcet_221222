package ex;

public class BasketGoods {
	Goods buyGoods = null;
	int buy_price = 0;
	int buy_cnt = 0;
	String buy_Date = null;
	public BasketGoods() {
		String nowDay="2022=09-22";
		buy_Date=nowDay;
	}


	public void basketgoods_prt() {
		System.out.println("물건 정보");
		buyGoods.goods_prt();
		System.out.println("구매 정보");
		System.out.println("수량 : "+buy_cnt);
		System.out.println("가격 : "+buy_price);
		System.out.println("날짜 : "+buy_Date);
	}
}
