package tr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Word_study {
	private Scanner in = new Scanner(System.in);
	private Word word = new Word();
	private HashMap<String,Value> hMap = word.hsm();
	public Word addr() {
		return word;
	}
	public void study() {	//최근 오답이 2회이상일경우 오답조심
		ArrayList<Value> vList = new ArrayList<>();
		ArrayList<String> fList = new ArrayList<>();
		int point = 0;
		int fs = 0;
		for(Entry<String,Value> entry : hMap.entrySet()) {
			vList.add(entry.getValue());
		}
		for(int i = 0;i<vList.size();i++) {
			int rd = (int)(Math.random()*vList.size());
			System.out.println("뜻에 맞는 정답을 입력 하세요");
			System.out.println("뜻 : "+vList.get(rd).get_body());
			if(fs>=2) {
				System.out.println("오답 조심");
			}
			String w = in.nextLine();
			if(vList.get(rd).get_word().equalsIgnoreCase(w)) {
				point+=10;
				System.out.println("정답");
				if(fs>=2) {
					fs=0;
				}
			}else {
				fList.add(w);
				System.out.println("오답");
				fs++;
			}
		}
		System.out.println("만점 : "+vList.size()*10);
		System.out.println("점수 : "+point);
		System.out.println("오답 갯수 : "+fList.size());
		System.out.println("오답 목록");
		for(int i = 0;i<fList.size();i++) {
			System.out.println(fList.get(i));
		}
	}
	
	
	public void random_list() {	//같은 문제를 2번이상 틀릴경우 오답조심
		ArrayList<Wrong_answer> wList = new ArrayList<>();
		int wchk = 0;
		int point = 0;
		//int fs = 0;	//최근 오답이 2회이상일경우 오답조심
		ArrayList<String> rList = new ArrayList<>(hMap.keySet());
		for(int i = 0;i<rList.size();i++) {
			int chk = 0;
			Collections.shuffle(rList);
			System.out.println("뜻을보고 단어를 맞추세요.");
			System.out.println(hMap.get(rList.get(i)).get_body());
			for(int j = 0;j<wList.size();j++) {
				if(wList.get(j).answer.equals(rList.get(i))) {
					if(wList.get(j).wrong_cnt>=2) {
						System.out.println("오답 조심");
					}
				}
			}
			/*if(fs>=2) {
				System.out.println("오답 조심");
			}*/
			String input = in.nextLine();
			if(rList.get(i).equalsIgnoreCase(input)) {
				System.out.println("정답 입니다.");
				//fs--;
				point+=10;
				for(int a = 0;a<wList.size();a++) {
					if(wList.get(a).answer.equals(rList.get(i))) {
						wList.get(a).wrong_cnt--;
					}
				}
			}else {
				System.out.println("오답 입니다.");
				//fs++;
				wchk++;
				for(int j = 0;j<wList.size();j++) {
					if(wList.get(j).answer.equals(rList.get(i))) {
						wList.get(j).aList.add(input);
						wList.get(j).wrong_cnt++;
						chk++;
					}
				}
				if(chk==0) {
					Wrong_answer wrong_answer = new Wrong_answer();
					wrong_answer.aList.add(input);
					wrong_answer.wrong_cnt++;
					wrong_answer.answer = rList.get(i);
					wList.add(wrong_answer);
				}
			}

		}
		System.out.println("만점 : "+rList.size()*10);
		System.out.println("점수 : "+point);
		System.out.println("총 오답 갯수 : "+wchk);
		for(int i = 0;i<wList.size();i++) {
			wList.get(i).w_prt();
		}
	}
}



