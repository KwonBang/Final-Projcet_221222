
public class Day01_02 {

	public static void main(String[] args) {
		/*영역, 들여쓰기, 변수, 선언문, 구현문, 연산자(사칙연산 :
		= : 대입연산자
		+ : 더하기
		- : 빼기
		* : 곱하기
		/ :나누기 묷
		% : 나머지)
		*/
		String name="휴먼";
		int point=100;
		
		name = name + "교육";
		point = 300;
		
		System.out.println(name);	//휴먼교육
		System.out.println(point);	//300
		
		
		double avalue=18;	// 의도 : 변수하나 만든것
		double bvalue=4;
		double result=0;	//의도는 위 두개의 변수값을 던한 값을 저장
		double result1=0;
		double result2=0;
		double result3=0;
		
		result = avalue + bvalue;
		result1 = avalue * bvalue;
		result2 = avalue / bvalue;	//18/4	:4.5
		result3 = avalue % bvalue;
		
		System.out.println("결과값 : "+result);			//22
		System.out.println("결과값 : "+result1);			//72
		System.out.println("결과값 : "+result2);			//4
		System.out.println("결과값 : "+result3);			//2
		System.out.println("결과값 : "+(avalue - bvalue));	//14
				
	}

}
