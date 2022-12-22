package tr;


public class Day03_03 {
	public static void main(String[] args) {
		String[] word = {"가","나","다","라"};
		
		for(int i=0;i<4;i++) {
			System.out.println(word[i]);
		}
		//문제1. 다음결과를 예측하시오.
		for(int i=0;i<4;i++) {
			System.out.println(word[i++]);	//가,다
		}
		int[] point = {23,45,22,34,67};
		//문제2. 모든 포인트를 출력하세요.
		for(int i=0;i<5;i++) {
			System.out.println(point[i]);
		}
		//문제3. 출력형식은 23/45/22/34/67/으로 출력하세요
		for(int i=0;i<5;i++) {
			System.out.print(point[i]+"/");
		}
		
		System.out.println();
		
		//문제4. 배열의 값이 짝수만 출력하세요
		for(int i=0;i<=4;i++) {
			if(i%2 == 0) {
				System.out.println(point[i]);
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
