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
	public void study() {	//�ֱ� ������ 2ȸ�̻��ϰ�� ��������
		ArrayList<Value> vList = new ArrayList<>();
		ArrayList<String> fList = new ArrayList<>();
		int point = 0;
		int fs = 0;
		for(Entry<String,Value> entry : hMap.entrySet()) {
			vList.add(entry.getValue());
		}
		for(int i = 0;i<vList.size();i++) {
			int rd = (int)(Math.random()*vList.size());
			System.out.println("�濡 �´� ������ �Է� �ϼ���");
			System.out.println("�� : "+vList.get(rd).get_body());
			if(fs>=2) {
				System.out.println("���� ����");
			}
			String w = in.nextLine();
			if(vList.get(rd).get_word().equalsIgnoreCase(w)) {
				point+=10;
				System.out.println("����");
				if(fs>=2) {
					fs=0;
				}
			}else {
				fList.add(w);
				System.out.println("����");
				fs++;
			}
		}
		System.out.println("���� : "+vList.size()*10);
		System.out.println("���� : "+point);
		System.out.println("���� ���� : "+fList.size());
		System.out.println("���� ���");
		for(int i = 0;i<fList.size();i++) {
			System.out.println(fList.get(i));
		}
	}
	
	
	public void random_list() {	//���� ������ 2���̻� Ʋ����� ��������
		ArrayList<Wrong_answer> wList = new ArrayList<>();
		int wchk = 0;
		int point = 0;
		//int fs = 0;	//�ֱ� ������ 2ȸ�̻��ϰ�� ��������
		ArrayList<String> rList = new ArrayList<>(hMap.keySet());
		for(int i = 0;i<rList.size();i++) {
			int chk = 0;
			Collections.shuffle(rList);
			System.out.println("�������� �ܾ ���߼���.");
			System.out.println(hMap.get(rList.get(i)).get_body());
			for(int j = 0;j<wList.size();j++) {
				if(wList.get(j).answer.equals(rList.get(i))) {
					if(wList.get(j).wrong_cnt>=2) {
						System.out.println("���� ����");
					}
				}
			}
			/*if(fs>=2) {
				System.out.println("���� ����");
			}*/
			String input = in.nextLine();
			if(rList.get(i).equalsIgnoreCase(input)) {
				System.out.println("���� �Դϴ�.");
				//fs--;
				point+=10;
				for(int a = 0;a<wList.size();a++) {
					if(wList.get(a).answer.equals(rList.get(i))) {
						wList.get(a).wrong_cnt--;
					}
				}
			}else {
				System.out.println("���� �Դϴ�.");
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
		System.out.println("���� : "+rList.size()*10);
		System.out.println("���� : "+point);
		System.out.println("�� ���� ���� : "+wchk);
		for(int i = 0;i<wList.size();i++) {
			wList.get(i).w_prt();
		}
	}
}



