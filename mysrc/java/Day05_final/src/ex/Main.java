package ex;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bbs bbs = new Bbs();
		bbs.save("개나이", 1, "가나다라가나가나다라마가");
		bbs.views_count();
		System.out.println(bbs.retrun_title("개"));
		System.out.println(bbs.retrun_no());
		System.out.println(bbs.retrun_body());
		System.out.println(bbs.retrun_views());
		System.out.println(bbs.cnt("가"));
	}

}
