package pack1;

public class test_01 {

	public static void main(String[] args) {
		String[] word={"a","b","c","d","e"};
		int a =60,b=90;
		System.out.println((a>=90||b>=90)?"false":"true");
		a=3;
		System.out.println(word[(a+2)%5]);
	}

}
