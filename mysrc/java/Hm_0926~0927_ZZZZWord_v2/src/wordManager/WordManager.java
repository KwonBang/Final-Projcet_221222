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
	// �ܾ� ����, ����, ����, ��ü����
	// WordInfo ��ü�� �ʿ��մϴ�..�� ��ü�� �����ϰ� �ִ�.
	// ������ �ݵ�� �ʿ��� ���� �ƴϴ�.. �����Ҷ��� �ʿ��ϴ�..
	private Connection conn = null;
	private WordInfo winfo = new WordInfo();
	private Scanner in = new Scanner(System.in);
	private WordDAO wdDao = new WordDAO();
	//private HashMap<String,WordInfo> wList = new HashMap<>();

	public WordManager(){
		try {
			// 1. ����̹� �ε�(�ʿ��� Ŭ������ �ڹٷ� �ε�)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("�ε� ����");
		} catch (ClassNotFoundException e) {
			//e.printStackTrace();
			System.out.println("�ε� ����");
		}
	}
	/*public HashMap<String, WordInfo> getwList() {
		return wList;
	}*/
	public void wordManagerRun() {
		//	for(;;) {
		while(true) {
			menu();
			System.out.println("���� >>");
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
		/*����. Ű����� �Է��� ���� ����.
		 * ���� : select * from word1;
		 * select ������ ��ȸ
		 * listword()���� ��ȸ�� �����͸� �����;� �Ѵ�.(���ϰ��޾ƿ´�)
		 */
		ArrayList<WordInfo> wordList = wdDao.allSelect();
		for(WordInfo w : wordList) {
			w.prt();
		}
		for(WordInfo w : wordList) {
			w.tuple();
		}
		/*System.out.println("-- ��ϵ� �ܾ� ��� -- ("+wList.size()+")");
		for(String keyinfo : wList.keySet()) {
			System.out.println("<�ܾ�����> "+keyinfo);
			WordInfo temp = wList.get(keyinfo);
			temp.prt();
			System.out.println("----------------------");
		}*/
	}
	private void modWord() {
		System.out.println("������ �ܾ� �Է�");
		String engName = in.nextLine();
		winfo.setEngName(engName);
		System.out.println("���ο� �ѱ� �� �Է�");
		String korName = in.nextLine();
		winfo.setKorName(korName);
		wdDao.modWord(winfo);
	}
	private void delWord() {
		System.out.println("������ ����ܾ� �Է�");
		String engName = in.nextLine();
		winfo.setEngName(engName);
		wdDao.delWord(winfo);
	}
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
	public void addWord(WordInfo winfo) {
		//���� ������ �����Ͽ� �ܾ �����ͺ��̽��� �����ϵ��� �ڵ�
		System.out.println("������ ���� �ܾ� �Է��ϼ���");
		String engName = in.nextLine();
		winfo.setEngName(engName);
		System.out.println("�ܾ��� �ѱ��ǹ̸� �Է��ϼ���");
		String korName = in.nextLine();
		winfo.setKorName(korName);
		System.out.println("�߿䵵�� �Է��ϼ���");
		String imporFlag = in.nextLine();
		winfo.setImporFlag(imporFlag);
		System.out.println("�ڸ�Ʈ�� �Է��ϼ���");
		String comment = in.nextLine();
		winfo.setComment(comment);
		if(connect()) {
			String sql="insert into word1 values (?,?,?,?,default)";
			//���� ������ �����ϴ� ��ü
			try {
				PreparedStatement psmt = conn.prepareStatement(sql); //���� ��ü ��� ����
				psmt.setString(1, winfo.getEngName());  //mapping
				psmt.setString(2, winfo.getKorName());  //mapping
				psmt.setString(3, winfo.getImporFlag());  //mapping
				psmt.setString(4, winfo.getComment());  //mapping
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
		/*winfo = new WordInfo();		
		System.out.println("�ܾ��߰� -----");
		System.out.println("key�� ����� ���� �ܾ� �Է��ϼ���");
		String keyWord = in.nextLine();
		System.out.println("Value �� �ѱ� �ܾ��� �ǹ̸� �Է��ϼ���");
		String valueKorWord = in.nextLine();
	//	System.out.println("Value ��  �߿䵵�� �Է��ϼ���");
	//	String valueimporWord = in.nextLine();
	//	System.out.println("Value �� ���� �Է��ϼ���");
	//	String valuecommetkeyWord = in.nextLine();
	//	winfo.setComment(valuecommetkeyWord);
	//	winfo.setImporFlag(valueimporWord);
		winfo.setKorName(valueKorWord);
		wList.put(keyWord, winfo);*/
	}
	private void menu() {
		System.out.println("1. �߰�");
		System.out.println("2. ����");
		System.out.println("3. ����");
		System.out.println("4. ��ü����");
		System.out.println("5. ����");
	}
}
