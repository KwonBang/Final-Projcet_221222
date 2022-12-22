package dao;

import dto.CardDTO;

public class H_DAO implements Card_INF{

	@Override
	public void pay(CardDTO c) {
		System.out.println("현데이 카드로 결제합니다");
	}

}
