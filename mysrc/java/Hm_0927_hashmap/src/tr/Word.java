package tr;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;

public class Word {
	private HashMap<String,Value> hMap = new HashMap<>();
	private Scanner in = new Scanner(System.in);
	public HashMap<String,Value> hsm(){
		return hMap;
	}
	public void set_word() {
		Value v = new Value();
		System.out.println("������ �ܾ� �Է�");
		String key = in.nextLine();
		if(hMap.containsKey(key)) {
			System.out.println("�ߺ��� �ܾ�� ������ �� �����ϴ�.");
			return;
		}
		System.out.println("������ �ܾ� �� �Է�");
		String value = in.nextLine();
		System.out.println("������ �ܾ� ���� �Է�");
		String comment = in.nextLine();
		System.out.println("������ �ܾ� �߿䵵 �Է�  1.��, 2.��, 3.��");
		int g = in.nextInt();
		in.nextLine();
		if(g==1) {
			v.set_grade("��");
		}else if(g==2) {
			v.set_grade("��");
		}else if(g==3) {
			v.set_grade("��");
		}else {
			System.out.println("1, 2, 3 �߿� �Է��ϼ���");
			return;
		}
		v.set_word(key);
		v.set_body(value);
		v.set_comment(comment);
		hMap.put(key,v);
		System.out.println("����Ϸ�");
	}
	public void delete_word(String key) {
		if(search_word(key)==0) {
			System.out.println("1.����");
			System.out.println("2.���");
			int num = in.nextInt();
			in.nextLine();
			if(num==1) {
				hMap.remove(key);
				System.out.println("���� �Ǿ����ϴ�.");
			}else if(num==2) {
				System.out.println("��� �Ǿ����ϴ�.");
			}
		}else {
			return;
		}
	}
	public int search_word(String key) {
		if(hMap.containsKey(key)) {
			System.out.println("�ܾ� : "+key);
			hMap.get(key).prt();
			return 0;
		}else {
			System.out.println("��ġ�ϴ� �ܾ �����ϴ�.");
			return 1;
		}
	}
	public void prt_word() {
		System.out.println("1. ��ü �ܾ�� �� �߿䵵 ����");
		System.out.println("2. ��ü �ܾ ����");
		System.out.println("3. ��ü �ܾ��� �游 ����");
		System.out.println("4. ��ü �ܾ��� ���� ����");
		System.out.println("5. ��ü �ܾ��� �߿䵵�� ����");
		System.out.println("6. �ܾ���� �޴��� ���Ʊ��");
		int num = in.nextInt();
		in.nextLine();
		if(num==1) {
			System.out.println("����� ��ü �ܾ��� ������� ���");
			//Ȯ��� ���� hMap.entrySet()�� entry�� ����
			size_word();
			for(Entry<String, Value> entry : hMap.entrySet()) {
				System.out.println("�ܾ� : " + entry.getKey()+" "+"�� : "+
						entry.getValue().get_body()+" "+"���� : "+entry.getValue().get_comment()+" "+"�߿䵵 : "+entry.getValue().get_grade());
			}
		}else if(num==2) {
			System.out.println("����� ��ü �ܾ ����");
			size_word();
			for(Entry<String, Value> entry : hMap.entrySet()) {
				System.out.println("�ܾ� : " + entry.getKey());
			}
		}else if(num==3) {
			System.out.println("����� ��ü �ܾ��� �游 ����");
			size_word();
			for(Entry<String, Value> entry : hMap.entrySet()) {
				System.out.println("�� : "+entry.getValue().get_body());
			}
		}else if(num==4) {
			System.out.println("����� ��ü �ܾ��� ���� ����");
			size_word();
			for(Entry<String, Value> entry : hMap.entrySet()) {
				System.out.println("�߿䵵 : "+entry.getValue().get_comment());
			}
		}else if(num==5) {
			System.out.println("����� ��ü �ܾ��� �߿䵵�� ����");
			size_word();
			for(Entry<String, Value> entry : hMap.entrySet()) {
				System.out.println("�߿䵵 : "+entry.getValue().get_grade());
			}
		}else if(num==6) {
			return;
		}
	}
	public void modify_word() {
		int num = 0;
		System.out.println("������ �ܾ� �Է�");
		String key = in.nextLine();
		if(!hMap.containsKey(key)) {
			System.out.println("��ġ�ϴ� �ܾ �����ϴ�.");
			return;
		}else {
			System.out.println("1. �ܾ� ����");
			System.out.println("2. �� ����");
			System.out.println("3. ���� ����");
			System.out.println("4. �߿䵵 ����");
			System.out.println("5. �ܾ���� �޴��� ���Ʊ��");
			num = in.nextInt();
			in.nextLine();
			if(num==1) {
				System.out.println("���ο� �ܾ� �Է�");
				String newkey = in.nextLine();
				if(hMap.containsKey(newkey)) {
					System.out.println("�ߺ��� �ܾ�� ������ �� �����ϴ�.");
					return;
				}
				hMap.put(newkey, hMap.get(key));
				hMap.remove(key);
				System.out.println("���� �Ϸ�");
			}else if(num==2) {
				System.out.println("���ο� �ܾ� �� �Է�");
				String newvalue = in.nextLine();
				hMap.get(key).set_body(newvalue);;
				System.out.println("���� �Ϸ�");
			}else if(num==3) {
				System.out.println("���ο� �ܾ� ���� �Է�");
				String newcomment = in.nextLine();
				hMap.get(key).set_comment(newcomment);
				System.out.println("���� �Ϸ�");
			}else if(num==4) {
				System.out.println("���ο� �ܾ� �߿䵵 �Է�");
				String newgrade = in.nextLine();
				hMap.get(key).set_grade(newgrade);
				System.out.println("���� �Ϸ�");
			}if(num==5) {
				return;
			}
		}
	}
	public void size_word() {
		System.out.println("����� �ܾ��");
		System.out.println(hMap.size());
	}
}
