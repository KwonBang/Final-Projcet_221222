package TestCode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import word.WordInfo;
//DAO���� data access object
// �����ͺ��̽��� �����Ͽ� ������ ����
//���� ���� �ĸ��ϰ��� �޴� �۾��� �����ϴ�
//��ü�� �ǹ������� DAO��� �Ѵ�.
// �� ��ü�� ����̹��ε�
// �����û, ��������, ������� �޴´�.
// �ڿ��� �ݳ��ϴ� �ڵ尡 ���Եȴ�. 
public class WordDAO {
	//�����ͺ��̽� ������ ���� �ڿ�(��ü)�� �ּҸ� ������ �������� ����
	private Connection conn = null;
	public WordDAO(){
		//����.. ���α׷� ���� �߿� �߻��ϴ� ��.. ����: �������� �ȵ�..
		try {
			// 1. ����̹� �ε�(�ʿ��� Ŭ������ �ڹٷ� �ε�)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("�ε� ����");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("�ε� ����");
		}
	}
	//�ʿ��Ҷ����� Ŀ�ؼ� ���� �޼��� ����
	public boolean connect() {
		try {
			// Ŀ�ؼ��� �õ��ϰ� �� ����� ��� ���� �ڵ�... 
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "11111111");
			System.out.println("���Ἲ��");
			return true;
		} catch (SQLException e) {
			System.out.println("�������");
			return false;
		}
	}
	// insert into word1 values ('a','b','c','d',default);
	public void insertWord(WordInfoDTO w) {
		//2. �����û�� �ϰ� �������� ����� �ް� �����ڿ��� �ݳ��ϴ� ���� 
		if(connect()) {
			String sql="insert into word1 values (?,?,?,?,default)";
			//���� ������ �����ϴ� ��ü
			try {
				PreparedStatement psmt = conn.prepareStatement(sql); //���� ��ü ��� ����
				psmt.setString(1, w.getEngName());  //mapping
				psmt.setString(2, w.getKorName());  //mapping
				psmt.setString(3, w.getImporFlag());  //mapping
				psmt.setString(4, w.getComment());  //mapping
				int r = psmt.executeUpdate();   // ���� ���� �� ���ϰ� ����.
				System.out.println(r+"���� �ԷµǾ����ϴ�");
				conn.close();  // �����ڿ��� �ݳ�
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("������ �� �� ��� �Է��� ���� ���մϴ�.");
		}
	}
	public void delWord(WordInfo winfo) {
		if(connect()) {
			String sql="delete from word1 where eng=?";
			//���� ������ �����ϴ� ��ü
			try {
				PreparedStatement psmt = conn.prepareStatement(sql); //���� ��ü ��� ����
				psmt.setString(1,winfo.getEngName());
				int r = psmt.executeUpdate();   // ���� ���� �� ���ϰ� ����.
				System.out.println(r+"���� �����Ǿ����ϴ�");
				conn.close();  // �����ڿ��� �ݳ�
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("������ �� �� ��� �Է��� ���� ���մϴ�.");
		}
	}
	public ArrayList<WordInfo> allSelect() {
		/*�Ϲ������� select����� �����ö���
		 * Ʃ���� �� ���� ���� DTO��ü�� �������� Ʃ���� �������� ���� ArrayList
		 * HashMap(**)���� �����͵� �������
		 */
		ResultSet rs = null;//�������� ����� ���Ϲ޴� ��ü
		if(connect()) {
			String sql="select * from word1";
			ArrayList<WordInfo> wordList =  new ArrayList<>();
			//���� ������ �����ϴ� ��ü
			try {
				Statement stmt = conn.createStatement();//���� ��ü ��� ����
				rs = stmt.executeQuery(sql);// ���� ���� �� ���ϰ� ����.
				while(rs.next()) {	//�ִ��� Ȯ�� �ϴ� �ڵ�
			/*�������� �ڵ�
			 * rs���������� ù��° Ʃ�ú��� ����Ű�� �ִ�. ��Ʃ�ú��� �����´�.
			 * Ʃ�� �����ö��� DTO�� ����Ѵ�. �׷��� ù��° Ʃ���� ������������ ��ü�� �����
			 * �� ��ü�� ���� �����ϱ� ���� setter��� rs�κ��� �ش��÷��� �����ͼ� set
			 * DTO��ü�� �����Ѵ�.rs���� ���� �����ö��� rs.getString("�÷���");
			 */
					WordInfo w = new WordInfo();
					w.setEngName(rs.getString("eng"));
					w.setKorName(rs.getString("kor"));
					w.setImporFlag(rs.getString("imor"));
					w.setComment(rs.getString("comm"));
					w.setMissCnt(rs.getInt("misscnt"));
					wordList.add(w);
				}
				conn.close();  // �����ڿ��� �ݳ�
				return wordList;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("������ �� �� ��� �Է��� ���� ���մϴ�.");
		}
		return null;
	}
	public void modWord(WordInfo winfo) {
		if(connect()) {
			String sql="delete from word1 where eng=?";
			//���� ������ �����ϴ� ��ü
			try {
				PreparedStatement psmt = conn.prepareStatement(sql); //���� ��ü ��� ����
				psmt.setString(1,winfo.getEngName());
				int r = psmt.executeUpdate();   // ���� ���� �� ���ϰ� ����.
				System.out.println(r+"���� �����Ǿ����ϴ�");
				conn.close();  // �����ڿ��� �ݳ�
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("������ �� �� ��� �Է��� ���� ���մϴ�.");
		}
	}



}
