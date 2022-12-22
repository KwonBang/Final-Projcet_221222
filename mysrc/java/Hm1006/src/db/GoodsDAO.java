package db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import goods.Goods;

public class GoodsDAO {
	private Connection conn = null;
	public GoodsDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
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
			String sql="update goods1 set "+column+" = ? where goods_id= ?";
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
	public Goods find_id(String goods_id) {
		ResultSet rs = null;
		if(connect()) {
			String sql="select * from goods1 where goods_id=?";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1,goods_id);
				rs = psmt.executeQuery();
				if (rs.next()) {
					Goods goods = new Goods();
					goods.setGoods_id(rs.getString("goods_id"));
					goods.setGoods_name(rs.getString("goods_name"));
					goods.setCnt(rs.getInt("cnt"));
					goods.setPrice(rs.getInt("price"));
					goods.setSeller_name(rs.getString("seller_name"));
					Date aDate = rs.getDate("goods_date");
					LocalDate localDate = aDate.toLocalDate();
					goods.setGoods_date(localDate);
					return goods;
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
	public void goodsset(Goods goods) {
		if(connect()) {
			String sql="insert into goods1 values(?,?,?,?,?,?)";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, goods.getGoods_id());
				psmt.setString(2, goods.getGoods_name());
				psmt.setInt(3, goods.getCnt());
				psmt.setInt(4, goods.getPrice());
				psmt.setString(5, goods.getSeller_name());
				LocalDate aDate = goods.getGoods_date();
				Date bDate = Date.valueOf(aDate);
				psmt.setDate(6,bDate);
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
	public ArrayList<Goods> allselect(){
		ResultSet rs = null;
		if(connect()) {
			String sql="select * from goods1";
			ArrayList<Goods> list = new ArrayList<>();
			try {
				Statement stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					Goods goods = new Goods();
					goods.setGoods_id(rs.getString("goods_id"));
					goods.setGoods_name(rs.getString("goods_name"));
					goods.setCnt(rs.getInt("cnt"));
					goods.setPrice(rs.getInt("price"));
					goods.setSeller_name(rs.getString("seller_name"));
					Date aDate = rs.getDate("goods_date");
					LocalDate localDate = aDate.toLocalDate();
					goods.setGoods_date(localDate);
					list.add(goods);
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
	public void del(String id) {
		if(connect()) {
			String sql="delete from goods1 where goods_id=?";
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
	public ArrayList<Goods> search(String a) {
		ArrayList<Goods> list = new ArrayList<>();
		ResultSet resultSet = null;
		if(connect()) {
			String sql="select * from member1 where id like %?% or name like %?%";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1,a);
				psmt.setString(2,a);
				resultSet = psmt.executeQuery();
				while(resultSet.next()) {
					Goods goods = new Goods();
					goods.setGoods_id(resultSet.getString("goods_id"));
					goods.setGoods_name(resultSet.getString("goods_name"));
					goods.setCnt(resultSet.getInt("cnt"));
					goods.setPrice(resultSet.getInt("price"));
					goods.setSeller_name(resultSet.getString("seller_name"));
					Date aDate = resultSet.getDate("goods_date");
					LocalDate localDate = aDate.toLocalDate();
					goods.setGoods_date(localDate);
					list.add(goods);
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
	public ArrayList<Goods> avg(){
		ArrayList<Goods> list = new ArrayList<>();
		ResultSet resultSet = null;
		if(connect()) {
			String sql="select * from goods1 a,(select avg(cnt) as c from goods1) b where cnt>c";
			try {
				Statement stmt = conn.createStatement();
				resultSet = stmt.executeQuery(sql);
				while(resultSet.next()) {
					Goods goods = new Goods();
					goods.setGoods_id(resultSet.getString("goods_id"));
					goods.setGoods_name(resultSet.getString("goods_name"));
					goods.setCnt(resultSet.getInt("cnt"));
					goods.setPrice(resultSet.getInt("price"));
					goods.setSeller_name(resultSet.getString("seller_name"));
					Date aDate = resultSet.getDate("goods_date");
					LocalDate localDate = aDate.toLocalDate();
					goods.setGoods_date(localDate);
					list.add(goods);
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
	
}
