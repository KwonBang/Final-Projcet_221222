package ex;

public class Main {

	public static void main(String[] args) {
		car c = new car();
		c.global_variable();
		c.savename("그랜저");
		c.global_variable();
		c.savetype("가솔린");
		c.save_yearlymodel_color(2022, "black");
		c.global_variable();
		System.out.println(c.type_retrun());
		System.out.println(c.addcarKm(100));
		int colorflag = c.equalcolor("black");
		if(colorflag==1) {
			System.out.println("같다");
		}else {
			System.out.println("다르다");
		}
		boolean oilflag = c.savetype("전기");
		if(oilflag) {
			System.out.println("가능");
		}else {
			System.out.println("불가능");
		}
		c.global_variable();
	}

}
