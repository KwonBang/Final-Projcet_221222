package Market;
//���� �Ѱ��� �ǹ��ϴ� ��ü
public class Goods {
	String name = null;
	String id = null;
	int cnt = 0;
	int price = 0;
	int buy = 0;
	
	public void setting(String name,String id,int cnt,int price) {
		//this�� �ڱ��ڽ��� ���������� �����Ҷ� ����ϴ� Ű����
		this.name=name;
		this.id=id;
		this.cnt=cnt;
		this.price=price;
	}
	public void prt() {
		System.out.println("�̸� : "+this.name);
		System.out.println("���̵� : "+this.id);
		System.out.println("�������� : "+this.cnt);
		System.out.println("�ܰ� : "+this.price);
		System.out.println("��ٱ��Ͽ� ���� ���� : "+this.buy);
	}
}
