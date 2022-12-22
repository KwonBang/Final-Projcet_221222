package ex;

public class Ex01 {

	public static void main(String[] args) {
		int[][] a = {
				{1,0,0,1,1,1,1,1},
				{1,1,0,0,0,0,0,0},
				{1,1,0,1,1,1,0,0},
				{1,1,0,1,1,1,0,0},
				{1,0,1,1,0,1,0,1},
				{1,0,1,1,0,1,0,1},
				{0,0,1,0,0,0,0,0},
				{0,1,1,0,1,1,1,1}
		};
		/*for(int i = 0;i<a.length;i++) {
			for(int j = 0;j<a[i].length;j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("-------------------------------");
		for(int i = 0;i<a.length;i++) {
			for(int j = 0;j<a[i].length;j++) {
				
			}
			System.out.println();
		}*/
		
		for(int i = 0;i<a.length;i++) {
			int cnt = 0;
			for(int j = 0;j<a[i].length;j++) {
				if(a[i][j]==0){
					cnt++;
				}
				if(j+1<a.length&&a[i][j]==0&&a[i][j+1]!=0&&cnt>=4){
					System.out.println("i "+i+" j "+j+" °¹¼ö "+cnt);
				}
			}
			if(cnt>=4) {
				System.out.println(i+" "+cnt);
			}else {
				
			}
		}
	}
}
