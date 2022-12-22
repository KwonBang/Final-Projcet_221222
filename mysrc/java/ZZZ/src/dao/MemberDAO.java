package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto.MemberDTO;

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
			String sql="update member set "+column+" = ? where id= ?";
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
	public ArrayList<MemberDTO> login(String a,String b) {
		ArrayList<MemberDTO> list = new ArrayList<>();
		ResultSet resultSet = null;
		if(connect()) {
			String sql="select * from member where id=? and pwd = ?";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1,a);
				psmt.setString(1,b);
				resultSet = psmt.executeQuery();
				while(resultSet.next()) {
					MemberDTO memberDTO = new MemberDTO();
					memberDTO.setId(resultSet.getString("id"));
					memberDTO.setPwd(resultSet.getString("pwd"));
					memberDTO.setName(resultSet.getString("name"));
					memberDTO.setAddr(resultSet.getString("addr"));
					list.add(memberDTO);
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
	public boolean memberset(MemberDTO memberDTO) {
		if(connect()) {
			String sql="insert into member values(?,?,?,?)";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, memberDTO.getId());
				psmt.setString(2, memberDTO.getPwd());
				psmt.setString(3, memberDTO.getName());
				psmt.setString(4, memberDTO.getAddr());
				int chk = psmt.executeUpdate();
				System.out.println("등록 완료");
				conn.close();
				if(chk>0) {
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}else {
			System.out.println("연결을 할 수 없어서 입력을 하지 못합니다.");
		}
		return false;
	}
	public boolean del(String id) {
		if(connect()) {
			String sql="delete from member where id=?";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1,id);
				int a = psmt.executeUpdate();
				System.out.println(a+"개 삭제 완료");
				conn.close();
				if(a>0) {
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}else {
			System.out.println("연결을 할 수 없어서 입력을 하지 못합니다.");
		}
		return false;
	}
	public ArrayList<MemberDTO> allselect() {
		ResultSet rs = null;
		if(connect()) {
			String sql="select * from member order by id";
			ArrayList<MemberDTO> list = new ArrayList<>();
			try {
				Statement stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					MemberDTO memberDTO = new MemberDTO();
					memberDTO.setId(rs.getString("id"));
					memberDTO.setPwd(rs.getString("pwd"));
					memberDTO.setName(rs.getString("name"));
					memberDTO.setAddr(rs.getString("addr"));
					list.add(memberDTO);
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
	public MemberDTO find_id(String id) {
		ResultSet rs = null;
		if(connect()) {
			String sql="select * from member where id=? order by id";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1,id);
				rs = psmt.executeQuery();
				if (rs.next()) {
					MemberDTO memberDTO = new MemberDTO();
					memberDTO.setId(rs.getString("id"));
					memberDTO.setPwd(rs.getString("pwd"));
					memberDTO.setName(rs.getString("name"));
					memberDTO.setAddr(rs.getString("addr"));
					return memberDTO;
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
	public ArrayList<MemberDTO> select_name_all(String name) {
		ResultSet rs = null;
		int chk = 0;
		if(connect()) {
			String sql="select * from member where name = ? order by name";
			ArrayList<MemberDTO> list = new ArrayList<>();
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1,name);
				rs = psmt.executeQuery();
				while(rs.next()) {
					MemberDTO memberDTO = new MemberDTO();
					memberDTO.setId(rs.getString("id"));
					memberDTO.setPwd(rs.getString("pwd"));
					memberDTO.setName(rs.getString("name"));
					memberDTO.setAddr(rs.getString("addr"));
					list.add(memberDTO);
					chk++;
				}
				conn.close();
				if(chk!=0) {
					return list;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}else {
			System.out.println("연결을 할 수 없어서 입력을 하지 못합니다.");
		}
		return null;
	}
	public ArrayList<MemberDTO> select_name_group(String name) {
		ResultSet rs = null;
		int chk = 0;
		if(connect()) {
			String sql="select name from member where name like '%'||?||'%' group by name order by name";
			ArrayList<MemberDTO> list = new ArrayList<>();
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1,name);
				rs = psmt.executeQuery();
				while(rs.next()) {
					MemberDTO memberDTO = new MemberDTO();
					memberDTO.setId(rs.getString("name"));
					list.add(memberDTO);
					chk++;
				}
				System.out.println(chk);
				conn.close();
				if(chk!=0) {
					return list;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}else {
			System.out.println("연결을 할 수 없어서 입력을 하지 못합니다.");
		}
		return null;
	}
	public boolean mod_name(String name,String id) {
		if(connect()) {
			String sql="update member set name = ? where id = ?";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, name);
				psmt.setString(2, id);
				int r = psmt.executeUpdate();
				System.out.println(r+"건이 입력되었습니다");
				conn.close();
				if(r!=0) {
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}else {
			System.out.println("연결을 할 수 없어서 입력을 하지 못합니다.");
			return false;
		}
		return false;
	}
	public boolean mod_pwd(String pwd,String id) {
		if(connect()) {
			String sql="update member set pwd = ? where id = ?";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, pwd);
				psmt.setString(2, id);
				int r = psmt.executeUpdate();
				System.out.println(r+"건이 입력되었습니다");
				conn.close();
				if(r!=0) {
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}else {
			System.out.println("연결을 할 수 없어서 입력을 하지 못합니다.");
			return false;
		}
		return false;
	}
	public boolean mod_addr(String addr,String id) {
		if(connect()) {
			String sql="update member set addr = ? where id = ?";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, addr);
				psmt.setString(2, id);
				int r = psmt.executeUpdate();
				System.out.println(r+"건이 입력되었습니다");
				conn.close();
				if(r!=0) {
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}else {
			System.out.println("연결을 할 수 없어서 입력을 하지 못합니다.");
			return false;
		}
		return false;
	}
}
