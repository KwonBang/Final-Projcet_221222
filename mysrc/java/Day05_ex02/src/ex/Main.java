package ex;

public class Main {

	public static void main(String[] args) {
		car c = new car();
		c.global_variable();
		c.savename("�׷���");
		c.global_variable();
		c.savetype("���ָ�");
		c.save_yearlymodel_color(2022, "black");
		c.global_variable();
		System.out.println(c.type_retrun());
		System.out.println(c.addcarKm(100));
		int colorflag = c.equalcolor("black");
		if(colorflag==1) {
			System.out.println("����");
		}else {
			System.out.println("�ٸ���");
		}
		boolean oilflag = c.savetype("����");
		if(oilflag) {
			System.out.println("����");
		}else {
			System.out.println("�Ұ���");
		}
		c.global_variable();
	}

}
