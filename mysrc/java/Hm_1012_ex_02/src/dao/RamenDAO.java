package dao;

import dto.FoodDTO;
import dto.RamenDTO;

public class RamenDAO implements FoodDAO_INF{
	
	@Override
	public void info(FoodDTO dto) {
		dto.prt();
	}

	@Override
	public FoodDTO basket(FoodDTO dto) {
		RamenDTO a = (RamenDTO) dto;
		System.out.println("������� ����");
		System.out.println("1. �����");
		System.out.println("2. ����");
		System.out.println("3. �ڷΰ���");
		int input = in.nextInt();
		in.nextLine();
		switch (input) {
		case 1:
			a.setName("�����");
			a.setPrice(1500);
			FoodDTO b = (FoodDTO) a;
			return b;
		case 2:
			a.setName("����");
			a.setPrice(2000);
			FoodDTO c = (FoodDTO) a;
			return c;
		case 3:
			return null;
		}
		return null;
	}

	@Override
	public void pay(FoodDTO dto) {
		
	}
	
}
