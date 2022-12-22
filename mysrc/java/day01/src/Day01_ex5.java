
public class Day01_ex5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 1000, b = 400, gaptime = 0;
		/*a1000m을갔고 b는400m을갔다 b가 a의 위치까지 갈때 필요한 시간 b는 1분에 100m을간다
		예를들어 gaptime이 2이면 2분이고, 걸어간 길이는 200m이다*/
		gaptime = a/100-b/100;	//조건은 a와 b의값이 변할때마다 결과값도 바뀌어야 한다.
		System.out.println(gaptime +"분 필요합니다");
	}

}
