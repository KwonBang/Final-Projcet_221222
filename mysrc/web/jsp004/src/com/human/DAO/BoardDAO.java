package com.human.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.human.vo.BoardVO;

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
	public void board_insert(BoardVO boardVO) {
		if(connect()) {
			String sql="insert into board_server values(board_cnt.nextval,?,?,?,?,?,default,default)";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1,boardVO.getName());
				psmt.setString(2,boardVO.getEmail());
				psmt.setString(3,boardVO.getTitle());
				psmt.setString(4,boardVO.getContent());
				psmt.setString(5,boardVO.getPass());
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
	public ArrayList<BoardVO> board_selectAll(){
		ResultSet rs = null; // 쿼리의 결과를 리턴받기 위한 객체
		ArrayList<BoardVO> allList = new ArrayList<>();
		if(connect()) {
			try {
				String sql="select * from board_server";  // 완성된쿼리
				Statement stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				while(rs.next()) {  // rs는 튜플을 통채로 가져온다.
					BoardVO b = new BoardVO(); //튜플하나당 객체 한개 
					b.setName(rs.getString("name"));
					b.setCnt(rs.getInt("cnt"));
					b.setContent(rs.getString("content"));
					b.setEmail(rs.getString("email"));
					b.setIndate(rs.getString("indate"));
					b.setTitle(rs.getString("title"));
					b.setNum(rs.getInt("num"));
					allList.add(b);
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
	            String sql="select * from board_server where num=?";  // 완성된쿼리
	            PreparedStatement psmt = conn.prepareStatement(sql);
	            psmt.setString(1, num);
	            rs = psmt.executeQuery();
	            if(rs.next()) {  // rs는 튜플을 통채로 가져온다.
	               BoardVO b = new BoardVO(); //튜플하나당 객체 한개 
	               b.setName(rs.getString("name"));
	               b.setCnt(rs.getInt("cnt"));
	               b.setContent(rs.getString("content"));
	               b.setEmail(rs.getString("email"));
	               b.setIndate(rs.getString("indate"));
	               b.setIndate(rs.getString("indate"));               
	               b.setTitle(rs.getString("title"));
	               b.setNum(rs.getInt("num"));
	               return b;
	            }
	         } catch (Exception e) {
	            // TODO: handle exception
	         }         
	      }
	      return null;      
	   }
}
