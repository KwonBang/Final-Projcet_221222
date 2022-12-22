package test;

import java.util.ArrayList;

public class Test {
	//테스트용클래스
	public static void main(String[] args) {
		/* 객체를 여러개만들고 객체를 하나의 변수로 핸들링 하기위해 배열을 사용 했었다
		 * 배열의 특징 : 연속적인 공간, 순서가 있다. 선언된 배열의 크기를 변경하기 힘들다(단점)
		 * 자바개발에서는 ArrayList 자료형을 많이 사용합니다.
		 * List의 하위개념이 ArrayList 일반적으로 자바에서는 List라고 많이 이야기 합니다.
		 * List의 특징 : 연속공간, 순서가 있다. 크기가 유동적이다. 사용하는 만큼이다. 사용하기 더 편하다.
		 * 
		 * 실제 면접에서 배열과 List의 특징은 단골질문이다.*/
		ArrayList<Member> mList = new ArrayList<>();
		Member m1 = new Member("kim", 11);
		Member m2 = new Member("lee", 22);
		mList.add(m1);
		mList.add(m2);
		mList.add(m2);
		mList.get(0);
		System.out.println(mList.get(0));
		System.out.println(mList.get(1));
		System.out.println(mList.get(2));
		for(int i = 0;i<mList.size();i++) {
			mList.get(i).prt();
		}
		System.out.println("--------------");
		//1
		mList.get(1).name="park";
		//2
		for(int i = 0;i<mList.size();i++) {
			mList.get(i).prt();
		}
		//3
		mList.add(new Member("choi", 33));
		System.out.println("--------------");
		//4
		for(int i = 0;i<mList.size();i++) {
			mList.get(i).prt();
		}
		System.out.println("--------------");
		//5
		mList.remove(0);
		//6
		for(int i = 0;i<mList.size();i++) {
			mList.get(i).prt();
		}
		System.out.println("--------------");
		//7
		for(int i = 0;i<mList.size();i++) {
			System.out.println(mList.get(i).name);
		}
		
	}
}
