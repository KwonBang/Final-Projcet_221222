
public class Day01_ex10 {

	public static void main(String[] args) {
		/*클래스 새로 만들어 작성
		 학생의 성적을 저장하고 성적표를 출력하는 프로그램을 작성하시오
		 영어점수, 수학점수, 자바점수, 오라클점수, mysql점수
		 점수는 임의대로 출력한다
		 1.과목의 점수를 모두 출력하시오. 소수점 없음
		 2. 모든 과목의 점수의 총합을 출력하시오. 소수점 없음
		 3. 평균을 출력하시오. 소수점있음*/
		int epoint = 20, mpoint = 60, jpoint = 10, opoint = 60, ypoint = 70, 
				avg = epoint + mpoint + jpoint + opoint + ypoint; 
		
		System.out.println("영어점수 : " + epoint+" " + "수학점수 : " + mpoint+" " + "자바점수 : " + 
		jpoint + " " + "mysql점수 : " + ypoint+" " + "자바점수 : " + jpoint );
		
		System.out.println("모든과목의 점수 총합 : " + avg);
		
		System.out.println("평균을 출력하시오 : " + (double)avg/5);
		
		
		
		
		
		
		
		
		
		
	}

}
