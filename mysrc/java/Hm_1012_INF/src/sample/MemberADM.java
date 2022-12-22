package sample;

import java.util.Scanner;

import dao.DAO_INF;
import dao.MariaDAO;
import dao.MongoDAO;
import dao.MysqlDAO;
import dao.OracleDAO;
import dto.MemberDTO;

public class MemberADM {
	Scanner in = new Scanner(System.in);
	DAO_INF nowDao = null;
	public MemberADM() {
		System.out.println("저장할 데이터베이스 선택");
		System.out.println("원하시는 데이터베이스를 선택하세요");
		System.out.println("1. Oracle");
		System.out.println("2. Mysql");
		System.out.println("3. MariaDB");
		System.out.println("4. MongoDB");
		int input = in.nextInt();
		in.nextLine();
		switch (input ) {
		case 1:
			nowDao = new OracleDAO();
			break;
		case 2:
			nowDao = new MysqlDAO();
			break;
		case 3:
			nowDao = new MariaDAO();
			break;
		case 4:
			nowDao = new MongoDAO();
			break;
		}
		running();
	}
	public void running() {
		while(true) {
			menu();
			int input = in.nextInt();
			in.nextLine();
			switch (input ) {
			case 1:
				addMember();
				break;
			case 2:
				delMember();
				break;
			case 3:
				
				break;
			}
		}
	}
	private void addMember() {
		MemberDTO m = new MemberDTO();
		nowDao.insert(m);
	}
	private void delMember() {
		
	}
	public void menu() {
		System.out.println("1. 회원등록");
		System.out.println("2. 회원삭제");
		System.out.println("3. 회원보기");
	}
}
