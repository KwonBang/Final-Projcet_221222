package test;

import java.util.ArrayList;

public class Test {
	//�׽�Ʈ��Ŭ����
	public static void main(String[] args) {
		/* ��ü�� ����������� ��ü�� �ϳ��� ������ �ڵ鸵 �ϱ����� �迭�� ��� �߾���
		 * �迭�� Ư¡ : �������� ����, ������ �ִ�. ����� �迭�� ũ�⸦ �����ϱ� �����(����)
		 * �ڹٰ��߿����� ArrayList �ڷ����� ���� ����մϴ�.
		 * List�� ���������� ArrayList �Ϲ������� �ڹٿ����� List��� ���� �̾߱� �մϴ�.
		 * List�� Ư¡ : ���Ӱ���, ������ �ִ�. ũ�Ⱑ �������̴�. ����ϴ� ��ŭ�̴�. ����ϱ� �� ���ϴ�.
		 * 
		 * ���� �������� �迭�� List�� Ư¡�� �ܰ������̴�.*/
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
