package test;

public class Member {
	String name = null;
	int age = 1;
	public void prt() {
		System.out.println(name+"/"+age);
	}
	public Member(String name,int age) {
		this.age=age;
		this.name=name;
	}
	
}
