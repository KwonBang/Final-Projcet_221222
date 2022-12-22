package User;

public class User {
	private String name = null;
	private int age = 0;
	public void set_name(String name) {
		this.name = name;
	}
	public void set_age(int age) {
		this.age = age;
	}
	public void prt() {
		System.out.println("이름 : "+name+" "+"나이 : "+age);
	}
	public void age_up() {
		this.age +=1;
	}
}
