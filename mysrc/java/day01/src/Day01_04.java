
public class Day01_04 {

	public static void main(String[] args) {
		//이번 주제는 형변환 (쉽게 말하면 자료형을 변환시킨다.
		int a = 10, b = a;
		double c = a;	//선언한 변수는 C (double타입), 값은 정수가 됩니다
						//서로 타입이 다른데 에러가 나지 않는다. 자동형변환
		System.out.println(b);
		System.out.println(c);
		
		double d= 13.1;
//		int e = d;	에러. 자동형변환이 되지 않는다. 이유는 큰자료형에서 작은 자료형은 
//					강제형변환을 해야한다.
		int e = (int)d;
		System.out.println(e);
	}

}
