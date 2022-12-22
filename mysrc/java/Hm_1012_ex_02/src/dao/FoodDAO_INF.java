package dao;

import java.util.Scanner;

import dto.FoodDTO;

public interface FoodDAO_INF {
	Scanner in = new Scanner(System.in);
	public void info(FoodDTO dto);
	public FoodDTO basket(FoodDTO dto);
	public void pay(FoodDTO dto);
}
