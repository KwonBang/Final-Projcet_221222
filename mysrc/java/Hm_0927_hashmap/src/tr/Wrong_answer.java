package tr;

import java.util.ArrayList;

public class Wrong_answer {
	String answer = null;
	int wrong_cnt = 0;
	ArrayList<String> aList =new ArrayList<>();
	public void w_prt() {
		System.out.println("������ : "+answer);
		for(int i = 0;i<aList.size();i++) {
			System.out.println("�Է��� �� : "+aList.get(i));
		}
		System.out.println("���� Ƚ�� : "+wrong_cnt);
		System.out.println("---------------");
	}
}
