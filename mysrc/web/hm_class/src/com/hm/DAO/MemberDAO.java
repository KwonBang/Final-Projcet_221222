package com.hm.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.hm.VO.MemberVO;


public class MemberDAO {
private Connection conn = null;
	
	// 싱글톤은 객체는 하나, 필요하다면 주소만 공유 >> 불필요한 객체를 생성하지 않아서 성능이나 안정성면에서 좋음 (GC동작할 필요가 없음)
	// 싱글톤에서 객체는 본인이 만들고 공용변수 하나를 선언하여 공용변수로 필요한 객체에게 알려 줍니다.
	
	public static MemberDAO memberDAO;
	public static MemberDAO getInstance() {
		if(memberDAO==null) {
			memberDAO = new MemberDAO();
		}
		return memberDAO;
	}
	
	private MemberDAO() {
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
	public void insert(MemberVO memberVO) {
		if(connect()) {
			String sql="insert into member_hm values(member_hm_seq.nextval,?,?,?,?,?)";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1,memberVO.getName());
				psmt.setString(2,memberVO.getTel());
				psmt.setString(3,memberVO.getAddress());
				psmt.setString(4,memberVO.getJoindate());
				psmt.setString(5,memberVO.getGrade());
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
	public int nowCnt() {
		int nowNumber = -1;
		if(connect()) {
			try {
				String sql="select member_hm_seq.nextval from dual";  // 완성된쿼리
				Statement psmt = conn.createStatement();
				ResultSet rs = psmt.executeQuery(sql);
				if(rs.next()) {  // rs는 튜플을 통채로 가져온다.
					nowNumber=rs.getInt("nextval");
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(false);
			}         
		}
		return nowNumber;
	}
	public ArrayList<MemberVO> selectAll(){
	      ResultSet rs = null; // 쿼리의 결과를 리턴받기 위한 객체
	      ArrayList<MemberVO> allList = new ArrayList<>();
	      if(connect()) {
	         try {
	            String sql="select * from member_hm";  // 완성된쿼리
	            Statement stmt = conn.createStatement();
	            rs = stmt.executeQuery(sql);
	            // 단일 객체또는 숫자를 리턴 or 리스트를 리턴 해야 하기에  while문사용
	            while(rs.next()) {  // rs는 튜플을 통채로 가져온다.
	               MemberVO b = new MemberVO(); //튜플하나당 객체 한개 
	               
	               allList.add(b);
	            }
	         } catch (Exception e) {
	            // TODO: handle exception
	         }         
	      }
	      return allList;      
	   }
}
