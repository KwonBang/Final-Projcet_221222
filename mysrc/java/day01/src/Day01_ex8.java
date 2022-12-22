
public class Day01_ex8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10000, pay = 4500, jandon = a - pay;
		/*손님이 낸 금액, 물건 가격, 거스름돈
		거스름돈을 천원짜리 0개, 백원짜리 0개, 십원짜리 0개, 1원짜리 0개의 형식으로 출력하세요*/
		int cjs = jandon/1000%10, qor = jandon/100%10, tlq = jandon/10%10, dlf = jandon/1%10;
		System.out.println("천원짜리 "+cjs+"개"+"백원짜리 "+qor+"개"+"십원짜리 "+tlq+"개"+"일원짜리 "+dlf+"개");
		
		
	}

}
