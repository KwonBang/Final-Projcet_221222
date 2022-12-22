package TestCode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import word.WordInfo;
//DAO용어는 data access object
// 데이터베이스에 접속하여 쿼리를 실행
//쿼리 실행 후리턴값을 받는 작업을 수행하는
//객체를 의미적으로 DAO라고 한다.
// 이 객체는 드라이버로딩
// 연결요청, 쿼리전송, 결과값을 받는다.
// 자원을 반납하는 코드가 포함된다. 
public class WordDAO {
	//데이터베이스 연결을 위한 자원(객체)의 주소를 저장할 참조변수 선언
	private Connection conn = null;
	public WordDAO(){
		//예외.. 프로그램 실행 중에 발생하는 것.. 에러: 실행조차 안됨..
		try {
			// 1. 드라이버 로딩(필요한 클래스를 자바로 로드)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("로드 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("로드 실패");
		}
	}
	//필요할때마다 커넥션 얻어는 메서드 정의
	public boolean connect() {
		try {
			// 커넥션을 시도하고 그 결과를 얻어 오는 코드... 
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "11111111");
			System.out.println("연결성공");
			return true;
		} catch (SQLException e) {
			System.out.println("연결실패");
			return false;
		}
	}
	// insert into word1 values ('a','b','c','d',default);
	public void insertWord(WordInfoDTO w) {
		//2. 연결요청을 하고 쿼리전송 결과를 받고 연결자원을 반납하는 순서 
		if(connect()) {
			String sql="insert into word1 values (?,?,?,?,default)";
			//실제 쿼리를 전달하는 객체
			try {
				PreparedStatement psmt = conn.prepareStatement(sql); //쿼리 객체 얻어 오기
				psmt.setString(1, w.getEngName());  //mapping
				psmt.setString(2, w.getKorName());  //mapping
				psmt.setString(3, w.getImporFlag());  //mapping
				psmt.setString(4, w.getComment());  //mapping
				int r = psmt.executeUpdate();   // 쿼리 실행 후 리턴값 저장.
				System.out.println(r+"건이 입력되었습니다");
				conn.close();  // 연결자원을 반납
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("연결을 할 수 없어서 입력을 하지 못합니다.");
		}
	}
	public void delWord(WordInfo winfo) {
		if(connect()) {
			String sql="delete from word1 where eng=?";
			//실제 쿼리를 전달하는 객체
			try {
				PreparedStatement psmt = conn.prepareStatement(sql); //쿼리 객체 얻어 오기
				psmt.setString(1,winfo.getEngName());
				int r = psmt.executeUpdate();   // 쿼리 실행 후 리턴값 저장.
				System.out.println(r+"건이 삭제되었습니다");
				conn.close();  // 연결자원을 반납
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("연결을 할 수 없어서 입력을 하지 못합니다.");
		}
	}
	public ArrayList<WordInfo> allSelect() {
		/*일반적으로 select결과를 가져올때는
		 * 튜플이 한 개일 경우는 DTO객체를 가져오고 튜플이 여러개일 경우는 ArrayList
		 * HashMap(**)으로 가져와도 상관없다
		 */
		ResultSet rs = null;//쿼리실행 결과를 리턴받는 객체
		if(connect()) {
			String sql="select * from word1";
			ArrayList<WordInfo> wordList =  new ArrayList<>();
			//실제 쿼리를 전달하는 객체
			try {
				Statement stmt = conn.createStatement();//쿼리 객체 얻어 오기
				rs = stmt.executeQuery(sql);// 쿼리 실행 후 리턴값 저장.
				while(rs.next()) {	//있는지 확인 하는 코드
			/*가져오는 코드
			 * rs참조변수는 첫번째 튜플부터 가리키고 있다. 그튜플부터 가져온다.
			 * 튜플 가져올때는 DTO를 사용한다. 그래서 첫번째 튜플을 가져오기위해 객체를 만들고
			 * 그 객체에 값을 저장하기 위해 setter사용 rs로부터 해당컬럼을 가져와서 set
			 * DTO객체에 저장한다.rs에서 값을 가져올때는 rs.getString("컬럼명");
			 */
					WordInfo w = new WordInfo();
					w.setEngName(rs.getString("eng"));
					w.setKorName(rs.getString("kor"));
					w.setImporFlag(rs.getString("imor"));
					w.setComment(rs.getString("comm"));
					w.setMissCnt(rs.getInt("misscnt"));
					wordList.add(w);
				}
				conn.close();  // 연결자원을 반납
				return wordList;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("연결을 할 수 없어서 입력을 하지 못합니다.");
		}
		return null;
	}
	public void modWord(WordInfo winfo) {
		if(connect()) {
			String sql="delete from word1 where eng=?";
			//실제 쿼리를 전달하는 객체
			try {
				PreparedStatement psmt = conn.prepareStatement(sql); //쿼리 객체 얻어 오기
				psmt.setString(1,winfo.getEngName());
				int r = psmt.executeUpdate();   // 쿼리 실행 후 리턴값 저장.
				System.out.println(r+"건이 삭제되었습니다");
				conn.close();  // 연결자원을 반납
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("연결을 할 수 없어서 입력을 하지 못합니다.");
		}
	}



}
