package Tr;

import java.security.NoSuchAlgorithmException;

public class Day04_02 {

	public static void main(String[] args) {
		/*1. ������ ���� ����ϼ���
		0000*
		000**
		00***
		0****
		 */
		for(int i=0;i<4;i++) {
			for(int j=0;j<4-i;j++) {
				System.out.print(0);
			}
			for(int j=0;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("---------------");
		for(int i=0;i<4;i++) {		//for�� 2����
			for(int j=0;j<5;j++)
				if(j>=-i+4) {
					System.out.print("*");
				}else {
					System.out.print("0");
				}
			System.out.println();
		}
		System.out.println("---------------");
		/*2. ������ ���� ����ϼ���
		 *
		 **
		 ***
		 ****
		 */
		for(int i=0;i<4;i++) {
			for(int j=0;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("---------------");
		/*3. 
		Ȧ���� ���� ���Ͻÿ�*/
		int[] a = {10,23,23,25,10,4};
		int sum=0;
		for(int i=0;i<6;i++) {
			sum+=a[i];
		}
		System.out.println(sum);
		System.out.println("---------------");
		/*4.
		int[] a = {10,23,23,25,10,4};
		¦���� ��� ��ΰ�?*/
		int cnt=0;
		for(int i=0;i<6;i++) {
			if(a[i]%2==0)
				cnt++;
		}
		System.out.println(cnt);
		System.out.println("---------------");
		/*5. 
		�������� 1-15���� �̾Ƽ� ¦���� ���ڸ� �����ϼ���*/
		int[] b=new int[5];
		for(int i=0;i<5;i++) {
			int rd = (int)(Math.random()*15+1);
			if(rd%2==1) {
				i=i-1;
			}else {
				b[i]=rd;
			}
		}
		for(int i=0;i<5;i++) {
			System.out.println(b[i]);
		}
		System.out.println("---------------");
		/*6. 
		�ζǹ�ȣ�� �����ϼ���. �ߺ�����
		������´� 23/44/21/25/23/1+78*/
		int[] lotto = new int[7];
		for(int i=0;i<7;i++) {
			int rd = (int)(Math.random()*45+1);
			lotto[i]=rd;
			System.out.print(lotto[i]+"/");
		}
		System.out.println();
		System.out.println("---------------");
		/*7.
		�ζ� ��ȣ�� �����ϼ���. �ߺ� �Ұ���
		������´� 23/44/21/25/23/1+78 */
		for(int i=0;i<7;i++) {
			int rd = (int)(Math.random()*45+1);
			
		}
		System.out.println("---------------");
		/*8. 
		1������ 45�� ���ڸ� �������� 1000�� �̴´�.
		���� ���� ���� ���� 7���� ����Ѵ�. <���� ���� ���¼��ڰ� �������ϰ���
		���� ���ڰ� �켱�Ѵ�>*/
		
		System.out.println("---------------");
		/*9.
		�������� ��й�ȣ 4�ڸ��� ������� �Ѵ�.
		passInt �迭���� ������ �� 4���� �̾Ƽ� mypass�� �ϼ��Ѵ�.*/
		int[] passInt={1,2,3,4,5,6,7,8,9};
		String mypass = " ";
		for(int i=0;i<4;i++) {
			int pass = (int)(Math.random()*9);
			mypass+=passInt[pass]+"";
		}
		System.out.println(mypass);
		/*__[10��, 11��]______________________________________
		�� �迭�� ���� ���� �ǹ��� ��Ÿ�� ���̴�. ���ڴ� ��(����)�̴�
		���� 0 �� ���� ���ڸ��̸� �ǹ��� ���� �� �ִ�
		�ε����� 0���� ���۵ȴ�.
		�� �迭�� ���� �ٲ� �� �ִ�.*/
		int[] a10 = {10,20,0,30,45,0,0,60,0,0,0,56};
		System.out.println("---------------");
		/*10. [�迭] ���ڸ��� ��� �� ���ΰ�?*/  
		int cnt10=0;
		for(int i=0;i<12;i++) {
			if(a10[i]==0) {
				cnt10++;
			}
		}
		System.out.println(cnt10);
		System.out.println("---------------");
		/*11. �迭�� �� �� 0�� �ϳ� ������ ������1, 0�� ���� 2�� ������ ������ 2�̴�.   ������2¥�� �ǹ��� ������� �Ѵ�. ������� ���ӵ� ���ڸ��� �ִ� �����̴�.
		       (����� 2 �̻��̸� �ǹ��� ���� �� �ִ�)�ǹ��� ���� �� �ִ� ������ �� ���ΰ�? 
		       ������� �迭�� ũ�⸦ ���� ���� ���� �������� � ���ڸ� �־
		       �ǹ��� ���� �� �ִ� ������ ���;� �Ѵ�.*/

		System.out.println("---------------");
		/*12.
		for���� ����Ͽ� �迭�� ���� ��ĭ�� �ڷ� �̵���Ű�ÿ� �� ���ڸ��� ó�� �ڸ��� �̵�*/
		int[] a12 = {10,23,23,25,10,4};
















	}

}
