package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto.BookDTO;
import dto.MemberDTO;

public class BookDAO {
	private Connection conn = null;
	public BookDAO() {
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
	public boolean insert_book(BookDTO bookDTO) {
		if(connect()) {
			String sql="insert into book values(book_no_seq.nextval,?,?,?)";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, bookDTO.getTitle());
				psmt.setString(2, bookDTO.getInfo());
				psmt.setString(3, bookDTO.getWriter());
				int r = psmt.executeUpdate();
				System.out.println(r+"건이 입력되었습니다");
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}else {
			System.out.println("연결을 할 수 없어서 입력을 하지 못합니다.");
			return false;
		}
		return true;
	}
	public boolean mod_title(int book_no,String title) {
		if(connect()) {
			String sql="update book set title = ? where book_no = ?";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, title);
				psmt.setInt(2, book_no);
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
	public boolean mod_info(int book_no,String info) {
		if(connect()) {
			String sql="update book set info = ? where book_no = ?";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, info);
				psmt.setInt(2, book_no);
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
	public boolean mod_writer(int book_no,String writer) {
		if(connect()) {
			String sql="update book set writer = ? where book_no = ?";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, writer);
				psmt.setInt(2, book_no);
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
	public ArrayList<BookDTO> search(String a) {
		ArrayList<BookDTO> list = new ArrayList<>();
		ResultSet resultSet = null;
		int chk = 0;
		if(connect()) {
			String sql="select title from book where title like '%' ||?|| '%' group by title order by title";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1,a);
				resultSet = psmt.executeQuery();
				while(resultSet.next()) {
					BookDTO bookDTO = new BookDTO();
					bookDTO.setTitle(resultSet.getString("title"));
					list.add(bookDTO);
					chk++;
				}
				conn.close();
				if(chk>0) {
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
	public boolean delete_book(int no) {
		if(connect()) {
			String sql="delete from book where book_no=?";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setInt(1, no);
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
		}
		return false;
	}
	public BookDTO select_no_One(String select) {
		ResultSet rs=null;
		BookDTO w = null;
		if(connect()) {
			try {
				String sql="select * from book where book_no=?";
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, select);
				rs = psmt.executeQuery();
				if(rs.next()) {
					w = new BookDTO();
					w.setNo(rs.getInt("book_no"));
					w.setTitle(rs.getString("title"));
					w.setInfo(rs.getString("info"));
					w.setWriter(rs.getString("writer"));
				}
				conn.close();
				if(w!=null) {
					return w;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}
	public ArrayList<BookDTO> allselect(){
		ResultSet resultSet = null;
		int chk = 0;
		if(connect()) {
			String sql="select * from book";
			ArrayList<BookDTO> list = new ArrayList<>();
			try {
				Statement stmt = conn.createStatement();
				resultSet = stmt.executeQuery(sql);
				while(resultSet.next()) {
					BookDTO bookDTO = new BookDTO();
					bookDTO.setNo(resultSet.getInt("book_no"));
					bookDTO.setInfo(resultSet.getString("info"));
					bookDTO.setWriter(resultSet.getString("writer"));
					bookDTO.setTitle(resultSet.getString("title"));
					list.add(bookDTO);
					chk++;
				}
				conn.close();
				if(chk>0) {
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
	public ArrayList<BookDTO> select_title_group() {
		ResultSet rs = null;
		int chk = 0;
		if(connect()) {
			String sql="select title from book group by title order by title";
			ArrayList<BookDTO> list = new ArrayList<>();
			try {
				Statement psmt = conn.createStatement();
				rs = psmt.executeQuery(sql);
				while(rs.next()) {
					BookDTO bookDTO = new BookDTO();
					bookDTO.setTitle(rs.getString("title"));
					list.add(bookDTO);
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
	public ArrayList<BookDTO> select_title(String title) {
		ResultSet rs = null;
		int chk = 0;
		if(connect()) {
			String sql="select * from book where title = ? order by title";
			ArrayList<BookDTO> list = new ArrayList<>();
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1,title);
				rs = psmt.executeQuery();
				while(rs.next()) {
					BookDTO bookDTO = new BookDTO();
					bookDTO.setNo(rs.getInt("book_no"));
					bookDTO.setTitle(rs.getString("title"));
					bookDTO.setInfo(rs.getString("info"));
					bookDTO.setWriter(rs.getString("writer"));
					list.add(bookDTO);
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
	
	
	
	
	
	
	
	
	
	
	
	
	
}
