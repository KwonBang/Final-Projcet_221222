package TestCode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*DAO용어는 data access object
 *데이터베이스에 접속하여 쿼리를 실행
 *쿼리 실행 후 리턴값을 받는 작업을 수행하는
 *객체를 의미적으로 DAO라고 한다.
 *이객체는 드라이버로딩
 *연결요청, 쿼리전송, 결과값을 받는다.
 *자원을 반납하는 코드가 포함된다.
 */
public class WordDAO {
	//데이터베이스 연결을 위한 자원(객체)의 주소를 저장할 참조변수 선언
	private Connection conn = null;
	WordDAO() {
		//예외 프로그램 실행 중에 발생하는것..에러 : 실행조차 안됨
		try {
			//1. 드라이버 로딩(필요한 클래스를 자바로 로드)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("로드 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch black
			//e.printStackTrace();
			System.out.println("로드 실패");
		}
	}
	//필요할때마다 커넥션 얻는 메서드 정의
	public boolean connect() {
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","11111111");
			System.out.println("연결 성공");
			return true;
		} catch (SQLException e) {
			System.out.println("연결 실패");
			return false;
		}
	}
	//insert into word1 values('a','b','c','d',default);
	public void insertWord(WordInfoDTO w) {
		//2. 연결요청을 하고 쿼리전송 결과를 받고 연결자원을 반납하는 순서
		if(connect()) {
			String sql = "insert into word1 values('a','b','c','d',default)";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);//쿼리 객체 얻어 오기
				psmt.setString(1, w.getEngName());//mapping
				psmt.setString(2, w.getKorName());//mapping
				psmt.setString(3, w.getImporFlag());//mapping
				psmt.setString(4, w.getComment());//mapping
				int r = psmt.executeUpdate();	//쿼리 실행 후 리턴값 저장.
				System.out.println(r+"건이 입력되었습니다.");
				conn.close();	//연결 자원을 반납
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("연결을 할 수 없어서 입력하지 못합니다.");
		}
	}
	
}
