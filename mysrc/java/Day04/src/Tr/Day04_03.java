package Tr;

public class Day04_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cnt = 1;
		int[][] a = new int[4][8];
		for(int i = 0;i<4;i++) {
			for(int j = 0;j<8;j++) {
				a[i][j]=cnt;
				cnt++;
			}
		}
		for(int i = 0;i<4;i++) {
			for(int j = 0;j<8;j++) {
				System.out.print(a[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("-------------------------------------");
		int ccnt = 1;
		int[][] b = new int[4][5];
		for(int i = 0;i<4;i++) {
			for(int j = 4;j>=0;j--) {
				b[i][j]=ccnt;
				ccnt++;
			}
		}
		for(int i = 0;i<4;i++) {
			for(int j = 0;j<5;j++) {
				System.out.print(b[i][j]+"\t");
			}
			System.out.println();
		}
	}

}
