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
		System.out.println("라면종류 선택");
		System.out.println("1. 쉰라면");
		System.out.println("2. 쥔라면");
		System.out.println("3. 뒤로가기");
		int input = in.nextInt();
		in.nextLine();
		switch (input) {
		case 1:
			a.setName("쉰라면");
			a.setPrice(1500);
			FoodDTO b = (FoodDTO) a;
			return b;
		case 2:
			a.setName("쥔라면");
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
