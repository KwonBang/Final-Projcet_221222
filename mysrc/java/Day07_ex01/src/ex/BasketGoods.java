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
		System.out.println("���� ����");
		buyGoods.goods_prt();
		System.out.println("���� ����");
		System.out.println("���� : "+buy_cnt);
		System.out.println("���� : "+buy_price);
		System.out.println("��¥ : "+buy_Date);
	}
}
