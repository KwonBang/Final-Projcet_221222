package dao;

import dto.CardDTO;

public class W_DAO implements Card_INF{

	@Override
	public void pay(CardDTO c) {
		System.out.println("우리둘이 카드로 결제합니다");
	}

}
