package tr;

import java.util.ArrayList;

public class Wrong_answer {
	String answer = null;
	int wrong_cnt = 0;
	ArrayList<String> aList =new ArrayList<>();
	public void w_prt() {
		System.out.println("정답은 : "+answer);
		for(int i = 0;i<aList.size();i++) {
			System.out.println("입력한 답 : "+aList.get(i));
		}
		System.out.println("오답 횟수 : "+wrong_cnt);
		System.out.println("---------------");
	}
}
