package test;

public class Day03_ex02 {

	public static void main(String[] args) {
		// 10. �迭���� ���� ū ���� ã������.
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
