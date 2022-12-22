package com.human.lotto;

public class lotto {
	public int[] number() {
		int rendamNumber[] = new int[6];
		for (int i = 0; i < 6; i++)
		{
			rendamNumber[i] = (int)(Math.random() * 45) + 1; // 정수 생성
			for (int j = 0; j < i; j++) {
				if (rendamNumber[j] == rendamNumber[i]) {
					i--;
				}
			}
		}
		return rendamNumber;
	}
	public int[] choiceNumber(int a,int b) {
		int rendamNumber[] = new int[6];
		rendamNumber[0] = a;
		rendamNumber[1] = b;
		for (int i = 2; i < 6; i++){
			rendamNumber[i] = (int)(Math.random() * 45) + 1; // 정수 생성
			for (int j = 0; j < i; j++) {
				if (rendamNumber[j] == rendamNumber[i]) {
					i--;
				}
			}
		}
		return rendamNumber;
	}
}
