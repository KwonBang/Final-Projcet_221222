package test;

public class Day03_ex01 {

	public static void main(String[] args) {
		// 1. �����ڵ��� ��°��� ���ڵ��Ͻÿ�
		int a = 40;
		if (a > 50 || a > 100) {
			System.out.println("ok");
		}

		// 2. �����ڵ��� ��°��� ���ڵ��Ͻÿ�
		// int a=40;
		if (a % 2 == 0) {
			System.out.println("¦��");
		} else {
			System.out.println("Ȧ��");
		}

		// 3. �����ڵ��� ��°��� ���ڵ��Ͻÿ�
		for (int i = 2; i < 6; i++) {
			System.out.println(i);
		}

		// 4.�����ڵ��� ��°��� ���ڵ��Ͻÿ�
		int sum = 0;	//����. �������� �����ΰ� ����
		for (int i = 0; i < 4; i++) {	//i=0 i=1 i=2 i=3
			sum += i;
		}
		System.out.println(sum);

		// 5. �����ڵ��� ��°��� ���ڵ��Ͻÿ�
		for (int i = 0; i < 10; i++) {
			System.out.print(i + "/");
		}

		// 6. �����ڵ��� ��°��� ���ڵ��Ͻÿ�
		int[] point = { 23, 45, 22, 34, 67 };
		for (int i = 0; i < 5; i++) {
			System.out.println(point[4 - i]);
		}

		// 7.�����ڵ��� ��°��� ���ڵ��Ͻÿ�
		// int[] point = {23,45,22,34,67};
		int sum7 = 0;
		for (int i = 0; i < 5; i++) {
			if (point[i] > 10) {
				sum7 += point[i];
			}
		}
		System.out.println(sum7);

		// ---------------------- ���� ------------------------------
		// 8.��� �迭�� ���� ���� ���� ����Ͻÿ�.
		int[] qpoint = { 23, 45, 22, 34, 67, 38 };
		int q8 = 0;
		for (int i = 0; i < 6; i++) {
			q8 += qpoint[i];
		}
		System.out.println(q8);
		// 9. �迭�� ���� Ȧ���� ��츸 ���� ���� ����Ͻÿ�.
		// int[] point = {23,45,22,34,67,38};
		int q9 = 0;
		for (int i = 0; i < 6; i++) {
			if (qpoint[i] % 2 == 1) {
				q9 += qpoint[i];
			}
		}
		System.out.println(q9);
		// 10. �迭���� ���� ū ���� ã������.
		// int[] point = { 23, 45, 22, 34, 67, 38 };
		int m = 0;
		for (int i = 0; i < 6; i++) {
			if (qpoint[i] > m) {
				m = qpoint[i];
			}
		}
		System.out.println(m);
		// 11. �迭���� 30���� ū ���� ��� ��ΰ���?
		// int[] point = {23,45,22,34,67,38};
		int c = 0;
		for (int i = 0; i < 6; i++) {
			if (qpoint[i] > 30) {
				c++;
			}
		}
		System.out.println(c);
		/*
		 * 12. ������ ���� ����Ͻÿ�. 1+2+3+4+5+6+7+8+9+10=���Ѱ����
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
		// 13. 1���� 100������ Ȧ���� Ȧ������, ¦���� ¦������ �� �� ���� ��������Ͻÿ�.
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
		 * 14. ����ã�� ���ڴ� 0���� 100���� �ϳ��� �����ϸ� �� ���ڴ� ���Ͽ� �����Ѵ�. ���� ���� 70�� �Ѿ�� �ϴ� ���ڰ� �ٷ�
		 * �����̴�. ���� ���ڸ� ����Ͻÿ�. �������, ���� ���� 64�϶� 10�� ���ϸ� 74�� �ȴ�. �̶� 10�̹��� ���ڰ� �ȴ�. ��, �츮��
		 * ��� �����θ� �ذ��մϴ�.
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
		 * F15. �Ǻ���ġ ������ ���� ���Ͻÿ�. �Ǻ���ġ ���� 20 ���ϱ��� ���Ͻø� �˴ϴ�. �Ǻ���ġ ������ ��Ģ�� 0�� 1�� �������� �ΰ���
		 * ���� ���� ���� ���� �˴ϴ�. 0+1+1+2+3+5+8+13 = ����
		 */
		int p = 0;
		for(int i=3;i<18;i++) {
			i=(p-1)+(p-2);
			System.out.println(i);
		}
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
