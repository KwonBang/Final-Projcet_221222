package dao;

import dto.CardDTO;

public class S_DAO implements Card_INF{

	@Override
	public void pay(CardDTO c) {
		System.out.println("��� ī��� �����մϴ�");
	}

}
