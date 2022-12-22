package wordManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.HashMap;
import java.util.Scanner;
import TestCode.WordDAO;
import word.WordInfo;
public class WordManager {
	// 단어 저장, 삭제, 수정, 전체보기
	// WordInfo 객체가 필요합니다..그 객체를 의존하고 있다.
	// 의존이 반드시 필요한 것은 아니다.. 저장할때만 필요하다..
	private Connection conn = null;
	private WordInfo winfo = new WordInfo();
	private Scanner in = new Scanner(System.in);
	private WordDAO wdDao = new WordDAO();
	//private HashMap<String,WordInfo> wList = new HashMap<>();

	public WordManager(){
		try {
			// 1. 드라이버 로딩(필요한 클래스를 자바로 로드)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("로드 성공");
		} catch (ClassNotFoundException e) {
			//e.printStackTrace();
			System.out.println("로드 실패");
		}
	}
	/*public HashMap<String, WordInfo> getwList() {
		return wList;
	}*/
	public void wordManagerRun() {
		//	for(;;) {
		while(true) {
			menu();
			System.out.println("선택 >>");
			int selMenu = in.nextInt();
			in.nextLine();
			if(selMenu==1) {
				addWord(winfo);
			}else if(selMenu==2) {
				delWord();
			}else if(selMenu==3) {
				modWord();
			}else if(selMenu==4) {
				listWord();
			}else {
				break;
			}

		}
	}
	private void listWord() {
		/*절차. 키보드로 입력할 것은 없다.
		 * 쿼리 : select * from word1;
		 * select 데이터 조회
		 * listword()에서 조회한 데이터를 가져와야 한다.(리턴값받아온다)
		 */
		ArrayList<WordInfo> wordList = wdDao.allSelect();
		for(WordInfo w : wordList) {
			w.prt();
		}
		for(WordInfo w : wordList) {
			w.tuple();
		}
		/*System.out.println("-- 등록된 단어 목록 -- ("+wList.size()+")");
		for(String keyinfo : wList.keySet()) {
			System.out.println("<단어정보> "+keyinfo);
			WordInfo temp = wList.get(keyinfo);
			temp.prt();
			System.out.println("----------------------");
		}*/
	}
	private void modWord() {
		System.out.println("수정할 단어 입력");
		String engName = in.nextLine();
		winfo.setEngName(engName);
		System.out.println("새로운 한글 뜻 입력");
		String korName = in.nextLine();
		winfo.setKorName(korName);
		wdDao.modWord(winfo);
	}
	private void delWord() {
		System.out.println("삭제할 영어단어 입력");
		String engName = in.nextLine();
		winfo.setEngName(engName);
		wdDao.delWord(winfo);
	}
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
	public void addWord(WordInfo winfo) {
		//지금 샘플을 참고하여 단어를 데이터베이스에 저장하도록 코딩
		System.out.println("저장할 영어 단어 입력하세요");
		String engName = in.nextLine();
		winfo.setEngName(engName);
		System.out.println("단어의 한글의미를 입력하세요");
		String korName = in.nextLine();
		winfo.setKorName(korName);
		System.out.println("중요도를 입력하세요");
		String imporFlag = in.nextLine();
		winfo.setImporFlag(imporFlag);
		System.out.println("코멘트를 입력하세요");
		String comment = in.nextLine();
		winfo.setComment(comment);
		if(connect()) {
			String sql="insert into word1 values (?,?,?,?,default)";
			//실제 쿼리를 전달하는 객체
			try {
				PreparedStatement psmt = conn.prepareStatement(sql); //쿼리 객체 얻어 오기
				psmt.setString(1, winfo.getEngName());  //mapping
				psmt.setString(2, winfo.getKorName());  //mapping
				psmt.setString(3, winfo.getImporFlag());  //mapping
				psmt.setString(4, winfo.getComment());  //mapping
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
		/*winfo = new WordInfo();		
		System.out.println("단어추가 -----");
		System.out.println("key로 사용할 영어 단어 입력하세요");
		String keyWord = in.nextLine();
		System.out.println("Value 중 한글 단어의 의미를 입력하세요");
		String valueKorWord = in.nextLine();
	//	System.out.println("Value 중  중요도를 입력하세요");
	//	String valueimporWord = in.nextLine();
	//	System.out.println("Value 중 설명 입력하세요");
	//	String valuecommetkeyWord = in.nextLine();
	//	winfo.setComment(valuecommetkeyWord);
	//	winfo.setImporFlag(valueimporWord);
		winfo.setKorName(valueKorWord);
		wList.put(keyWord, winfo);*/
	}
	private void menu() {
		System.out.println("1. 추가");
		System.out.println("2. 삭제");
		System.out.println("3. 수정");
		System.out.println("4. 전체보기");
		System.out.println("5. 종료");
	}
}
