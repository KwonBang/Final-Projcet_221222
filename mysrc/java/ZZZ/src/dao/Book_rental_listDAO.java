package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.BookDTO;
import dto.Book_rental_listDTO;

public class Book_rental_listDAO {
	private Connection conn = null;
	public Book_rental_listDAO() {
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
	public ArrayList<Book_rental_listDTO> select_rentalOne(String id,String title) {
		ResultSet resultSet = null;
		int chk = 0;
		if(connect()) {
			ArrayList<Book_rental_listDTO> list = new ArrayList<>();
			String sql = "select * from rental_list where id = ? and title = ?";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, id);
				psmt.setString(2, title);
				resultSet = psmt.executeQuery();
				while(resultSet.next()) {
					Book_rental_listDTO book_rental_listDTO = new Book_rental_listDTO();
					book_rental_listDTO.setRental_no(resultSet.getInt("rental_no"));
					book_rental_listDTO.setTitle(resultSet.getString("title"));
					book_rental_listDTO.setInfo(resultSet.getString("info"));
					book_rental_listDTO.setWriter(resultSet.getString("writer"));
					book_rental_listDTO.setInfo(resultSet.getString("id"));
					book_rental_listDTO.setRental_date(resultSet.getDate("rental_date").toLocalDate());
					book_rental_listDTO.setBook_no(resultSet.getInt("book_no"));
					list.add(book_rental_listDTO);
					chk++;
				}
				if(chk>0) {
					return list;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}
	public boolean insert(BookDTO bookDTO,String login_member_id) {
		if(connect()) {
			String sql = "insert into book_rental_list values(rental_no_seq.nextval,?,?,sysdate)";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setInt(1,bookDTO.getNo());
				psmt.setString(2, login_member_id);
				int a = psmt.executeUpdate();
				if(a!= 0) {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}
	public ArrayList<Book_rental_listDTO> rental_books(String id) {
		ArrayList<Book_rental_listDTO> list = new ArrayList<>();
		ResultSet resultSet = null;
		int chk = 0;
		if(connect()) {
			String sql="select title from rental_list where id=? group by title";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1,id);
				resultSet = psmt.executeQuery();
				while(resultSet.next()) {
					Book_rental_listDTO book_rental_listDTO = new Book_rental_listDTO();
					book_rental_listDTO.setTitle(resultSet.getString("title"));
					list.add(book_rental_listDTO);
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
	public boolean return_book(String id,String rental_no) {
		if(connect()) {
			String sql = "delete from book_rental_list where rental_no = ? and id = ?";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				int a = Integer.parseInt(rental_no);
				psmt.setInt(1, a);
				psmt.setString(2, id);
				int chk = psmt.executeUpdate();
				conn.close();
				if(chk>0) {
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}
}
