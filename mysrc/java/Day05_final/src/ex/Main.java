package ex;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bbs bbs = new Bbs();
		bbs.save("������", 1, "�����ٶ󰡳������ٶ󸶰�");
		bbs.views_count();
		System.out.println(bbs.retrun_title("��"));
		System.out.println(bbs.retrun_no());
		System.out.println(bbs.retrun_body());
		System.out.println(bbs.retrun_views());
		System.out.println(bbs.cnt("��"));
	}

}
