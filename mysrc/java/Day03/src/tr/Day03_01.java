package tr;
public class Day03_01 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//예를 들어 > 테스트결과 60점 이상이면 합격 60점 미만이면 불합격이라고 출력
		int point = 50;	//point 테스트의 결과

		if(point>=60){
			System.out.println("합격");
		}else{
			System.out.println("불합격");
		}
		//중첩if	들여쓰기 중요
		if(point>=60) {
			if(point<=80) {
				System.out.println("잘했어요");
			}
		}
		/*만약 조건에 따라 처리해야 할것이 여러개라면?
		예를 들어, 점수에 따라 A, B, C, D, E 로 등급을 나눈다면
		A : 90-100 B : 80-89 C : 70-79 ~~~*/
		int apoint = 80;
		/*조건1이 먼저 판별, 거짓이면 조건2를 판별, 거짓이면 조건3을 판별, 
		이때 참이면 조건3이 참일때 실행하고 끝*/
		if(/*조건1*/apoint>=90) {
			//조건1이 참일때 실행후 조건문 종료
			System.out.println("A");
		}else if(/*조건2*/apoint>=80) {
			//조건2가 참일때 실행후 조건문 종료
			System.out.println("B");
		}else if(/*조건3*/apoint>=70) {
			//조건3이 참일때 실행후 조건문 종료
			System.out.println("C");
		}else if(/*조건4*/apoint>=60) {
			//조건4가 참일때 실행후 조건문 종료
			System.out.println("D");
		}else if(/*조건5*/apoint>=50) {
			//조건3이 참일때 실행후 조건문 종료
			System.out.println("E");
		}
	}

}
