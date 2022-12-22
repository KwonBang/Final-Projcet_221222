package ex;

public class Ex01 {
	String id;
	int cnt = 10;
	int Price;
	public void inprice(int a) {
		Price=a;
	}
	public int count() {
		return cnt;
	}
	public void info() {
		System.out.println(id+"/"+cnt+"/"+Price);
	}
	public void infosave(String a,int b,int c) {
		id=a;
		cnt=b;
		Price=c;
	}
	Ex01(){
		
	}
}
