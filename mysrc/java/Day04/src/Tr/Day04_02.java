package Tr;

import java.security.NoSuchAlgorithmException;

public class Day04_02 {

	public static void main(String[] args) {
		/*1. 다음과 같이 출력하세요
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
		for(int i=0;i<4;i++) {		//for문 2개로
			for(int j=0;j<5;j++)
				if(j>=-i+4) {
					System.out.print("*");
				}else {
					System.out.print("0");
				}
			System.out.println();
		}
		System.out.println("---------------");
		/*2. 다음과 같이 출력하세요
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
		홀수의 합을 구하시오*/
		int[] a = {10,23,23,25,10,4};
		int sum=0;
		for(int i=0;i<6;i++) {
			sum+=a[i];
		}
		System.out.println(sum);
		System.out.println("---------------");
		/*4.
		int[] a = {10,23,23,25,10,4};
		짝수는 모두 몇개인가?*/
		int cnt=0;
		for(int i=0;i<6;i++) {
			if(a[i]%2==0)
				cnt++;
		}
		System.out.println(cnt);
		System.out.println("---------------");
		/*5. 
		랜덤숫자 1-15까지 뽑아서 짝수인 숫자만 저장하세요*/
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
		로또번호를 저장하세요. 중복가능
		출력형태는 23/44/21/25/23/1+78*/
		int[] lotto = new int[7];
		for(int i=0;i<7;i++) {
			int rd = (int)(Math.random()*45+1);
			lotto[i]=rd;
			System.out.print(lotto[i]+"/");
		}
		System.out.println();
		System.out.println("---------------");
		/*7.
		로또 번호를 저장하세요. 중복 불가능
		출력행태는 23/44/21/25/23/1+78 */
		for(int i=0;i<7;i++) {
			int rd = (int)(Math.random()*45+1);
			
		}
		System.out.println("---------------");
		/*8. 
		1번부터 45번 숫자를 랜덤으로 1000번 뽑는다.
		가장 많이 나온 숫자 7개를 출력한다. <가장 많이 나온숫자가 여러번일경우는
		작은 숫자가 우선한다>*/
		
		System.out.println("---------------");
		/*9.
		무작위로 비밀번호 4자리를 만드려고 한다.
		passInt 배열에서 랜던한 값 4개를 뽑아서 mypass를 완성한다.*/
		int[] passInt={1,2,3,4,5,6,7,8,9};
		String mypass = " ";
		for(int i=0;i<4;i++) {
			int pass = (int)(Math.random()*9);
			mypass+=passInt[pass]+"";
		}
		System.out.println(mypass);
		/*__[10번, 11번]______________________________________
		위 배열은 토지 위에 건물을 나타낸 것이다. 숫자는 층(높이)이다
		값이 0 인 경우는 빈자리이며 건물을 지을 수 있다
		인덱스는 0부터 시작된다.
		위 배열의 값은 바뀔 수 있다.*/
		int[] a10 = {10,20,0,30,45,0,0,60,0,0,0,56};
		System.out.println("---------------");
		/*10. [배열] 빈자리는 모두 몇 개인가?*/  
		int cnt10=0;
		for(int i=0;i<12;i++) {
			if(a10[i]==0) {
				cnt10++;
			}
		}
		System.out.println(cnt10);
		System.out.println("---------------");
		/*11. 배열의 값 중 0이 하나 있으면 사이즈1, 0이 연속 2개 있으면 사이즈 2이다.   사이즈2짜리 건물을 세우려고 한다. 사이즈는 연속된 빈자리의 최대 범위이다.
		       (사이즈가 2 이상이면 건물을 세울 수 있다)건물을 세울 수 있는 공간은 몇 개인가? 
		       사이즈는 배열의 크기를 벗어 나지 않은 범위에서 어떤 숫자를 넣어도
		       건물을 세울 수 있는 공간이 나와야 한다.*/

		System.out.println("---------------");
		/*12.
		for문을 사용하여 배열의 값을 한칸씩 뒤로 이동시키시오 맨 끝자리를 처음 자리로 이동*/
		int[] a12 = {10,23,23,25,10,4};
















	}

}
