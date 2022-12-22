
public class Day01_ex9 {
	public static Day01_ex9 day01_ex9 = new Day01_ex9();
	public static Day01_ex9 aaa() {
		return day01_ex9;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int a=10;
	      a = a +'a'+'b';
	      System.out.println(a);
	      //자바나 c는 문자(문자열 아닙니다)와 숫자는 공유합니다
	      //컴퓨터 입장에서는 두개가 같은 자료로 생각합니다.
	      //그런데선언문에 의해서 또는 표현에 의해서 문자인 경우와 숫자인 경우를 구분합니다.
	      //문자이면 아스키 코드표를 참조해서 문자로 출력합니다.
	      System.out.println(aaa());
	      
	}

}
