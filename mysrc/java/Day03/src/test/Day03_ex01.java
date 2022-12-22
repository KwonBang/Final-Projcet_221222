package test;

public class Day03_ex01 {

	public static void main(String[] args) {
		// 1. 다음코드의 출력값을 손코딩하시오
		int a = 40;
		if (a > 50 || a > 100) {
			System.out.println("ok");
		}

		// 2. 다음코드의 출력값을 손코딩하시오
		// int a=40;
		if (a % 2 == 0) {
			System.out.println("짝수");
		} else {
			System.out.println("홀수");
		}

		// 3. 다음코드의 출력값을 손코딩하시오
		for (int i = 2; i < 6; i++) {
			System.out.println(i);
		}

		// 4.다음코드의 출력값을 손코딩하시오
		int sum = 0;	//선언. 변수선언 무엇인가 저장
		for (int i = 0; i < 4; i++) {	//i=0 i=1 i=2 i=3
			sum += i;
		}
		System.out.println(sum);

		// 5. 다음코드의 출력값을 손코딩하시오
		for (int i = 0; i < 10; i++) {
			System.out.print(i + "/");
		}

		// 6. 다음코드의 출력값을 손코딩하시오
		int[] point = { 23, 45, 22, 34, 67 };
		for (int i = 0; i < 5; i++) {
			System.out.println(point[4 - i]);
		}

		// 7.다음코드의 출력값을 손코딩하시오
		// int[] point = {23,45,22,34,67};
		int sum7 = 0;
		for (int i = 0; i < 5; i++) {
			if (point[i] > 10) {
				sum7 += point[i];
			}
		}
		System.out.println(sum7);

		// ---------------------- 업글 ------------------------------
		// 8.모든 배열의 값을 합한 값을 출력하시오.
		int[] qpoint = { 23, 45, 22, 34, 67, 38 };
		int q8 = 0;
		for (int i = 0; i < 6; i++) {
			q8 += qpoint[i];
		}
		System.out.println(q8);
		// 9. 배열의 값이 홀수인 경우만 합한 값을 출력하시오.
		// int[] point = {23,45,22,34,67,38};
		int q9 = 0;
		for (int i = 0; i < 6; i++) {
			if (qpoint[i] % 2 == 1) {
				q9 += qpoint[i];
			}
		}
		System.out.println(q9);
		// 10. 배열에서 가장 큰 값을 찾으세요.
		// int[] point = { 23, 45, 22, 34, 67, 38 };
		int m = 0;
		for (int i = 0; i < 6; i++) {
			if (qpoint[i] > m) {
				m = qpoint[i];
			}
		}
		System.out.println(m);
		// 11. 배열에서 30보다 큰 값은 모두 몇개인가요?
		// int[] point = {23,45,22,34,67,38};
		int c = 0;
		for (int i = 0; i < 6; i++) {
			if (qpoint[i] > 30) {
				c++;
			}
		}
		System.out.println(c);
		/*
		 * 12. 다음과 같이 출력하시오. 1+2+3+4+5+6+7+8+9+10=합한결과값
		 */
		int sum12 = 0;
		for (int i = 1; i < 11; i++) {
			sum12 += i;
			if (i < 10) {
				System.out.print(i + "+");
			} else if (i == 10) {
				System.out.print(i + "=" + sum12);
			}
		}
		System.out.println();
		// 13. 1부터 100숫자중 홀수는 홀수끼리, 짝수는 짝수끼리 더 한 값을 각각출력하시오.
		int sum13a = 0;
		int sum13b = 0;
		for (int i = 1; i < 101; i++) {
			if (i % 2 == 1) {
				sum13a += i;
			} else {
				sum13b += i;
			}
		}
		System.out.println(sum13a);
		System.out.println(sum13b);
		/*
		 * 14. 범인찾기 숫자는 0부터 100까지 하나씩 증가하며 그 숫자는 더하여 저장한다. 합한 값이 70을 넘어가게 하는 숫자가 바로
		 * 범인이다. 범인 숫자를 출력하시오. 예를들어, 합한 값이 64일때 10을 더하면 74가 된다. 이때 10이범인 숫자가 된다. 단, 우리가
		 * 배운 것으로만 해결합니다.
		 */
		int sum14 = 0;
		for (int i = 0; i < 101; i++) {
			sum14 += i;
			if (sum14 > 70) {
				System.out.println(i);
				i += 100;
			}
		}
		/*
		 * F15. 피보나치 수열의 합을 구하시오. 피보나치 수는 20 이하까지 합하시면 됩니다. 피보나치 수열의 규칙은 0과 1을 시작으로 두개씩
		 * 더한 값이 다음 값이 됩니다. 0+1+1+2+3+5+8+13 = 총합
		 */
		int p = 0;
		for(int i=3;i<18;i++) {
			i=(p-1)+(p-2);
			System.out.println(i);
		}
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
