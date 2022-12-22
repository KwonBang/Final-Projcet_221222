package tr;

import java.util.Scanner;

public class Day03_02 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		// ctrl + shift + 알파벳 o
		// 예를 들어 메뉴를 키보드로 입력 받는다. 1번은 콜라, 2번은 사이다, 3번은 커피, 4번은 쥬스
		// 추가적으로 콜라의 종류가 1. 코크 2. 펩사
		System.out.println("메뉴를 선택하세요!!");
		int inputdata = in.nextInt(); // 입력값이 3이라고 가정
		System.out.println(inputdata);
		if (inputdata == 1) {
			// 콜라를 출력하는 코딩
			System.out.println("콜라의 종류를 선택하시오");
			int seldata = 1;
			if (seldata == 1) {
				System.out.println("코크");
			} else if (seldata == 2) {
				System.out.println("펩사");
			}
		} else if (inputdata == 2) {
			System.out.println("사이다");
		} else if (inputdata == 3) {
			System.out.println("커피");
		} else if (inputdata == 4) {
			System.out.println("쥬스");
		}

	}

}
