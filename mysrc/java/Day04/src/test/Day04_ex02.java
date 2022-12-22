package test;

public class Day04_ex02 {

	public static void main(String[] args) {
		/*문제1.
		 * 1	5	9	13	17
		 * 2	6	10	14	18
		 * 3	7	11	15	19
		 * 4	8	12	16	20
		 */
		int cnt = 1;
		int[][] a1 = new int[4][5];
		for(int i = 0;i<5;i++) {
			for(int j = 0;j<4;j++) {
				a1[j][i]=cnt;
				cnt++;
			}
		}
		for(int i = 0;i<4;i++) {
			for(int j = 0;j<5;j++) {
				System.out.print(a1[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("----------------");
		/* 문제2.
		 * 17	13	9	5	1
		 * 18	14	10	6	2
		 * 19	15	11	7	3
		 * 20	16	12	8	4
		 */
		cnt=1;
		int[][] a2 = new int[4][5];
		for(int i = 4;i>=0;i--) {
			for(int j =0;j<4;j++) {
				a2[j][i]=cnt++;
			}
		}
		for(int i = 0;i<4;i++) {
			for(int j = 0;j<5;j++) {
				System.out.print(a2[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("----------------");
		/* 문제3. 각행의 합을 출력하시오*/
		int[][] a3 = {
				{5,32,23,34,2},
				{4,12,13,36,6},
				{87,62,21,43,97},
				{65,32,12,32,22}
		};
		int sum = 0;
		for(int i = 0;i<4;i++) {
			for(int j = 0;j<5;j++) {
				sum+=a3[i][j];
			}
			System.out.println(sum);
			sum=0;
		}
		System.out.println("----------------");
		/*문제4. 위 3번 배열에서 열의 합을 각각 출력하시오*/
		sum=0;
		for(int i = 0;i<5;i++) {
			for(int j = 0;j<4;j++) {
				sum+=a3[j][i];
			}
			System.out.println(sum);
			sum=0;
		}
		System.out.println("----------------");
		/*문제5.
		 * 1	2	3	4	5	
		 * 10	9	8	7	6
		 * 11	12	13	14	15
		 * 20	19	18	17	16
		 */
		cnt=1;
		int[][] a5 = new int[4][5];
		for(int i = 0;i<4;i++) {
			if(i%2==0) {
				for(int j = 0;j<5;j++) {
					a5[i][j]=cnt++;
				}
			}else if(i%2==1) {
				for(int j = 4;j>=0;j--) {
					a5[i][j]=cnt++;
				}
			}
		}
		for(int i = 0;i<4;i++) {
			for(int j = 0;j<5;j++) {
				System.out.print(a5[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("----------------");
		/*문제6.
		 * 1	2	4	7	11
		 * 3	5	8	12	15
		 * 6	9	13	16	18
		 * 10	14	17	19	20
		 *
		 *0.0
		 *0.1 1.0
		 *0.2 1.1 2.0
		 *0.3 1.2 2.1 3.0
		 *0.4 1.3 2.2 3.1
		 *1.4 2.3 3.2
		 *2.4 3.3
		 *3.4
		 */
		cnt=1;
		int[][] a6 = new int[4][5];
		for(int i = 0;i<8;i++) {
			for(int j = 0;j<4;j++) {
				int k =i-j;
				if(k>=0&&k<5) {
					a6[j][k]=cnt;
					cnt++;
				}
			}
		}
		for(int i = 0;i<4;i++) {
			for(int j = 0;j<5;j++) {
				System.out.print(a6[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("----------------");
		/*문제7. 다음배열을 선언하고 2개의 배열의 합을 구하시오
		 * 1	2	3	4	5	
		 * 10	9	8	7	6
		 * 11	12	13	14	15
		 * 20	19	18	17	16
		 * 
		 * 54	23	23	53	23
		 * 3	21	22	32	2
		 * 2	32	22	12	23
		 * 32	32	12	33	32
		 */
		int[][] a7 = {
				{54,23,23,53,23},
				{3,21,22,32,2},
				{2,32,22,12,23},
				{32,32,12,33,32},
		};
		int[][] a7_1 = new int[4][5];
		for(int i = 0;i<4;i++) {
			for(int j = 0;j<5;j++) {
				a7_1[i][j]=a5[i][j]+a7[i][j];
				System.out.print(a7_1[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("----------------");
		/*문제8.
		 * 1	2	3	4	5
		 * 14	15	16	17	6
		 * 13	20	19	18	7
		 * 12	11	10	9	8
		 */
		int[][] a8 = new int[4][5]; 
		int s1 = 0;
		int s2 = 1;
		int s3 = 3;
		int s4 = 2;
		int s5 = 4;
		cnt=1;
		for(int u = 0;u<2;u++) {
			for(int i = s1;i<=s5;i++) {
				a8[s1][i]=cnt;
				cnt++;
			}
			for(int i = s2;i<=s3;i++) {
				a8[i][s5]=cnt;
				cnt++;
			}
			for(int i = s3;i>=s1;i--) {
				a8[s3][i]=cnt;
				cnt++;
			}
			if(u==1) {
				break;
			}
			for(int i = s4;i>=s2;i--) {
				a8[i][s1]=cnt;
				cnt++;
			}
			s1=s2;
			s3--;
			s5--;
			s2++;
		}
		for(int i = 0;i<4;i++) {
			for(int j = 0;j<5;j++) {
				System.out.print(a8[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("----------------");
		/*문제9. 아래와 같이 변경 단 배열을 새로 만들지 않는다.
		 *  3  54  23  23  53
		 *  2  32  21  55  87
		 * 32  22  18  90  27
		 * 39  12  33  94  65
		 */
		int[][] a = {
				{54,23,23,53,87},
				{ 3,21,55,90,27},
				{ 2,32,22,18,65},
				{32,39,12,33,94}
		};
		int y0 = 0;
		int y1 = 1;
		int y2 = 2;
		int y3 = 3;
		int y4 = 4;
		int x = 0;
		for(int j = 0;j<2;j++) {
			for(int i = y1;i<=y4;i++) {
				x = a[y0][i];
				a[y0][i]=a[y0][y0];
				a[y0][y0]=x;
			}
			for(int i = y1;i<y4;i++) {
				x=a[i][y4];
				a[i][y4]=a[y0][y0];
				a[y0][y0]=x;
			}
			for(int i = y3;i>=y0;i--) {
				x=a[y3][i];
				a[y3][i]=a[y0][y0];
				a[y0][y0]=x;
			}
			if(j==1) {
				break;
			}
			for(int i = y2;i>=y0;i--) {
				x=a[i][y0];
				a[i][y0]=a[y0][y0];
				a[y0][y0]=x;
			}
			y0++;
			y1++;
			y3--;
			y4--;
		}
		for(int i = 0;i<4;i++) {
			for(int j = 0;j<5;j++) {
				System.out.print(a[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("----------------");
		int[][] a9 = {
				{54,23,23,53,87},
				{ 3,21,55,90,27},
				{ 2,32,22,18,65},
				{32,39,12,33,94}
		};
		int[][] a9_1 = new int[4][5];
		for(int i = 0;i<4;i++) {
			for(int j = 0;j<5;j++) {
				a9_1[i][j]=a9[i][j];
			}
		}
		int q1 = 0;
		int q2 = 4;
		int q3 = 3;
		int w1 = 1;
		for(int j = 0;j<2;j++) {
			if(j==1) {
				cnt = 1;
			}else {
				cnt = 0;
			}
			for(int i =w1;i<=q2;i++) {
				a9[q1][i]=a9_1[q1][cnt];
				cnt++;
			}
			if(j==1) {
				cnt = 1;
			}else {
				cnt = 0;
			}
			for(int i = w1;i<=q3;i++) {
				a9[i][q2]=a9_1[cnt][q2];
				cnt++;
			}
			if(j==1) {
				cnt = 3;
			}else {
				cnt = 4;
			}
			for(int i = q3;i>=q1;i--) {
				a9[q3][i]=a9_1[q3][cnt];
				cnt--;
			}
			if(j==1) {
				cnt = 1;
			}else {
				cnt = 2;
			}
			for(int i = q3;i>=w1;i--) {
				a9[cnt][q1]=a9_1[i][q1];
				cnt--;
			}
			q1++;
			w1++;
			q2--;
			q3--;
		}
		for(int i = 0;i<4;i++) {
			for(int j = 0;j<5;j++) {
				System.out.print(a9[i][j]+"\t");
			}
			System.out.println();
		}
	}
}
