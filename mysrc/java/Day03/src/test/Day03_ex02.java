package test;

public class Day03_ex02 {

	public static void main(String[] args) {
		// 10. 배열에서 가장 큰 값을 찾으세요.
		int[] point = { 23, 45, 22, 34, 67, 38 };
		int m = 0;
		for (int i = 0; i < 6; i++) {
			if (point[i] > m) {
				m = point[i];
			}
		}
		System.out.println(m);
	}
}
