package hmshopDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import hmshopVO.BoardVO;

public class BoardDAO {
	private Connection conn = null;
	public BoardDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("로드성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("로드 실패");
		}
	}
	public boolean connect() {
		try {
			conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "11111111");
			System.out.println("연결성공");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("연결 실패");
			return false;
		}
	}
	public void insert(BoardVO boardVO) {
		if(connect()) {
			String sql="insert into hmshop values(?,?,?,?,?,?,default,?)";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setInt(1,boardVO.getNum());
				psmt.setString(2,boardVO.getId());
				psmt.setString(3,boardVO.getName());
				psmt.setString(4,boardVO.getPass());
				psmt.setString(5,boardVO.getTitle());
				psmt.setString(6,boardVO.getContent());
				psmt.setString(7,boardVO.getChkbox());
				psmt.executeUpdate();
				System.out.println("등록 완료");
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("연결을 할 수 없어서 입력을 하지 못합니다.");
		}
	}
	public ArrayList<BoardVO> selectAll(){
		ResultSet rs = null; // 쿼리의 결과를 리턴받기 위한 객체
		ArrayList<BoardVO> allList = new ArrayList<>();
		if(connect()) {
			try {
				String sql="select * from hmshop order by num";  // 완성된쿼리
				Statement stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				while(rs.next()) {  // rs는 튜플을 통채로 가져온다.
					BoardVO boardVO = new BoardVO(); //튜플하나당 객체 한개 
					boardVO.setNum(rs.getInt("num"));
					boardVO.setId(rs.getString("id"));
					boardVO.setName(rs.getString("name"));
					boardVO.setPass(rs.getString("pass"));
					boardVO.setTitle(rs.getString("title"));
					boardVO.setContent(rs.getString("content"));
					boardVO.setIndate(rs.getString("indate"));
					boardVO.setChkbox(rs.getString("chkbox"));
					allList.add(boardVO);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}

		}
		return allList;


	}
	public BoardVO selectOne(String num){
		ResultSet rs = null; // 쿼리의 결과를 리턴받기 위한 객체      
		if(connect()) {
			try {
				String sql="select * from hmshop where num=?";  // 완성된쿼리
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, num);
				rs = psmt.executeQuery();
				if(rs.next()) {  // rs는 튜플을 통채로 가져온다.
					BoardVO boardVO = new BoardVO(); //튜플하나당 객체 한개 
					boardVO.setNum(rs.getInt("num"));
					boardVO.setId(rs.getString("id"));
					boardVO.setName(rs.getString("name"));
					boardVO.setPass(rs.getString("pass"));
					boardVO.setTitle(rs.getString("title"));
					boardVO.setContent(rs.getString("content"));
					boardVO.setIndate(rs.getString("indate"));
					boardVO.setChkbox(rs.getString("chkbox"));
					return boardVO;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}         
		}
		return null;      
	}
	public BoardVO no() {
		ResultSet rs = null; // 쿼리의 결과를 리턴받기 위한 객체      
		if(connect()) {
			try {
				String sql="select HMSHOP_CNT.nextval from dual";  // 완성된쿼리
				Statement psmt = conn.createStatement();
				rs = psmt.executeQuery(sql);
				if(rs.next()) {  // rs는 튜플을 통채로 가져온다.
					System.out.println(1234);
					BoardVO boardVO = new BoardVO(); //튜플하나당 객체 한개 
					boardVO.setNum(rs.getInt("nextval"));
					return boardVO;
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(false);
			}         
		}
		return null;
	}
	public void del(String[] del_num) {
		if (del_num==null) {
			return;
		}
		for(int i = 0;i<del_num.length;i++) {
			if(connect()) {
				String sql="delete from hmshop where num=?";
				try {
					PreparedStatement psmt = conn.prepareStatement(sql);
					psmt.setInt(1,Integer.parseInt(del_num[i]));
					psmt.executeUpdate();
					System.out.println("등록 완료");
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				System.out.println("연결을 할 수 없어서 입력을 하지 못합니다.");
			}
		}
	}
}
