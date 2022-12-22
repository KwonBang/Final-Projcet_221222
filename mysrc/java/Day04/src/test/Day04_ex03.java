package test;

public class Day04_ex03 {

	public static void main(String[] args) {
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
		int q0 = 0;
		int q1 = 1;
		int q2 = 2;
		int q3 = 3;
		int q4 = 4;
		int x = 0;
		for(int j = 0;j<2;j++) {
			for(int i = q1;i<=q4;i++) {
				x = a[q0][i];
				a[q0][i]=a[q0][q0];
				a[q0][q0]=x;
			}
			for(int i = q1;i<q4;i++) {
				x=a[i][q4];
				a[i][q4]=a[q0][q0];
				a[q0][q0]=x;
			}
			for(int i = q3;i>=q0;i--) {
				x=a[q3][i];
				a[q3][i]=a[q0][q0];
				a[q0][q0]=x;
			}
			if(j==1) {
				break;
			}
			for(int i = q2;i>=q0;i--) {
				x=a[i][q0];
				a[i][q0]=a[q0][q0];
				a[q0][q0]=x;
			}
			q0++;
			q1++;
			q3--;
			q4--;
		}
		for(int i = 0;i<4;i++) {
			for(int j = 0;j<5;j++) {
				System.out.print(a[i][j]+"\t");
			}
			System.out.println();
		}
	}
}
