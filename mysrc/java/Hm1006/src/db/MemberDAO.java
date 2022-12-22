package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import member.Member;

public class MemberDAO {
	private Connection conn = null;
	public MemberDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("로드 실패");
		}
	}
	public boolean connect() {
		try {
			conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "11111111");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("연결 실패");
			return false;
		}
	}
	public void mod(String column,String set,String id) {
		if(connect()) {
			String sql="update member1 set "+column+" = ? where id= ?";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, set);
				psmt.setString(2, id);
				psmt.executeUpdate();
				System.out.println("수정 완료");
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("연결을 할 수 없어서 입력을 하지 못합니다.");
		}
	}
	public ArrayList<Member> search(String a) {
		ArrayList<Member> list = new ArrayList<>();
		ResultSet resultSet = null;
		if(connect()) {
			String sql="select * from member1 where id like %?% or name like %?%";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1,a);
				psmt.setString(2,a);
				resultSet = psmt.executeQuery();
				while(resultSet.next()) {
					Member member = new Member();
					member.setId(resultSet.getString("id"));
					member.setName(resultSet.getString("name"));
					member.setPass(resultSet.getString("pass"));
					member.setAddr(resultSet.getString("addr"));
					member.setPoint(resultSet.getInt("point"));
					list.add(member);
				}
				conn.close();
				return list;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("연결을 할 수 없어서 입력을 하지 못합니다.");
		}
		return null;
	}
	public void memberset(Member member) {
		if(connect()) {
			String sql="insert into member1 values(?,?,?,?,?)";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, member.getId());
				psmt.setString(2, member.getName());
				psmt.setString(3, member.getPass());
				psmt.setString(4, member.getAddr());
				psmt.setInt(5, member.getPoint());
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
	public void del(String id) {
		if(connect()) {
			String sql="delete from member1 where id=?";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1,id);
				int a = psmt.executeUpdate();
				System.out.println(a+"개 삭제 완료");
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("연결을 할 수 없어서 입력을 하지 못합니다.");
		}
	}
	public ArrayList<Member> allselect() {
		ResultSet rs = null;
		if(connect()) {
			String sql="select * from member1";
			ArrayList<Member> list = new ArrayList<>();
			try {
				Statement stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					Member member = new Member();
					member.setId(rs.getString("id"));
					member.setName(rs.getString("name"));
					member.setPass(rs.getString("pass"));
					member.setAddr(rs.getString("addr"));
					member.setPoint(rs.getInt("point"));
					list.add(member);
				}
				conn.close();
				return list;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("연결을 할 수 없어서 입력을 하지 못합니다.");
		}
		return null;
	}
	public Member find_id(String id) {
		ResultSet rs = null;
		if(connect()) {
			String sql="select * from member1 where id=?";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1,id);
				rs = psmt.executeQuery();
				if (rs.next()) {
					Member member = new Member();
					member.setId(rs.getString("id"));
					member.setName(rs.getString("name"));
					member.setPass(rs.getString("pass"));
					member.setAddr(rs.getString("addr"));
					member.setPoint(rs.getInt("point"));
					return member;
				}
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("연결을 할 수 없어서 입력을 하지 못합니다.");
		}
		return null;
	}
}
