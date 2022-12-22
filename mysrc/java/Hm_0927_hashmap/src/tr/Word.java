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
		System.out.println("저장할 단어 입력");
		String key = in.nextLine();
		if(hMap.containsKey(key)) {
			System.out.println("중복된 단어는 저장할 수 없습니다.");
			return;
		}
		System.out.println("저장할 단어 뜻 입력");
		String value = in.nextLine();
		System.out.println("저장할 단어 설명 입력");
		String comment = in.nextLine();
		System.out.println("저장할 단어 중요도 입력  1.상, 2.중, 3.하");
		int g = in.nextInt();
		in.nextLine();
		if(g==1) {
			v.set_grade("상");
		}else if(g==2) {
			v.set_grade("중");
		}else if(g==3) {
			v.set_grade("하");
		}else {
			System.out.println("1, 2, 3 중에 입력하세요");
			return;
		}
		v.set_word(key);
		v.set_body(value);
		v.set_comment(comment);
		hMap.put(key,v);
		System.out.println("저장완료");
	}
	public void delete_word(String key) {
		if(search_word(key)==0) {
			System.out.println("1.삭제");
			System.out.println("2.취소");
			int num = in.nextInt();
			in.nextLine();
			if(num==1) {
				hMap.remove(key);
				System.out.println("삭제 되었습니다.");
			}else if(num==2) {
				System.out.println("취소 되었습니다.");
			}
		}else {
			return;
		}
	}
	public int search_word(String key) {
		if(hMap.containsKey(key)) {
			System.out.println("단어 : "+key);
			hMap.get(key).prt();
			return 0;
		}else {
			System.out.println("일치하는 단어가 없습니다.");
			return 1;
		}
	}
	public void prt_word() {
		System.out.println("1. 전체 단어와 뜻 중요도 보기");
		System.out.println("2. 전체 단어만 보기");
		System.out.println("3. 전체 단어의 뜻만 보기");
		System.out.println("4. 전체 단어의 설명만 보기");
		System.out.println("5. 전체 단어의 중요도만 보기");
		System.out.println("6. 단어관리 메뉴로 돌아기기");
		int num = in.nextInt();
		in.nextLine();
		if(num==1) {
			System.out.println("저장된 전체 단어의 모든정보 목록");
			//확장된 포문 hMap.entrySet()을 entry에 저장
			size_word();
			for(Entry<String, Value> entry : hMap.entrySet()) {
				System.out.println("단어 : " + entry.getKey()+" "+"뜻 : "+
						entry.getValue().get_body()+" "+"설명 : "+entry.getValue().get_comment()+" "+"중요도 : "+entry.getValue().get_grade());
			}
		}else if(num==2) {
			System.out.println("저장된 전체 단어만 보기");
			size_word();
			for(Entry<String, Value> entry : hMap.entrySet()) {
				System.out.println("단어 : " + entry.getKey());
			}
		}else if(num==3) {
			System.out.println("저장된 전체 단어의 뜻만 보기");
			size_word();
			for(Entry<String, Value> entry : hMap.entrySet()) {
				System.out.println("뜻 : "+entry.getValue().get_body());
			}
		}else if(num==4) {
			System.out.println("저장된 전체 단어의 설명만 보기");
			size_word();
			for(Entry<String, Value> entry : hMap.entrySet()) {
				System.out.println("중요도 : "+entry.getValue().get_comment());
			}
		}else if(num==5) {
			System.out.println("저장된 전체 단어의 중요도만 보기");
			size_word();
			for(Entry<String, Value> entry : hMap.entrySet()) {
				System.out.println("중요도 : "+entry.getValue().get_grade());
			}
		}else if(num==6) {
			return;
		}
	}
	public void modify_word() {
		int num = 0;
		System.out.println("수정할 단어 입력");
		String key = in.nextLine();
		if(!hMap.containsKey(key)) {
			System.out.println("일치하는 단어가 없습니다.");
			return;
		}else {
			System.out.println("1. 단어 수정");
			System.out.println("2. 뜻 수정");
			System.out.println("3. 설명 수정");
			System.out.println("4. 중요도 수정");
			System.out.println("5. 단어관리 메뉴로 돌아기기");
			num = in.nextInt();
			in.nextLine();
			if(num==1) {
				System.out.println("새로운 단어 입력");
				String newkey = in.nextLine();
				if(hMap.containsKey(newkey)) {
					System.out.println("중복된 단어는 저장할 수 없습니다.");
					return;
				}
				hMap.put(newkey, hMap.get(key));
				hMap.remove(key);
				System.out.println("수정 완료");
			}else if(num==2) {
				System.out.println("새로운 단어 뜻 입력");
				String newvalue = in.nextLine();
				hMap.get(key).set_body(newvalue);;
				System.out.println("수정 완료");
			}else if(num==3) {
				System.out.println("새로운 단어 설명 입력");
				String newcomment = in.nextLine();
				hMap.get(key).set_comment(newcomment);
				System.out.println("수정 완료");
			}else if(num==4) {
				System.out.println("새로운 단어 중요도 입력");
				String newgrade = in.nextLine();
				hMap.get(key).set_grade(newgrade);
				System.out.println("수정 완료");
			}if(num==5) {
				return;
			}
		}
	}
	public void size_word() {
		System.out.println("저장된 단어갯수");
		System.out.println(hMap.size());
	}
}
