
public class Day01_04 {

	public static void main(String[] args) {
		//�̹� ������ ����ȯ (���� ���ϸ� �ڷ����� ��ȯ��Ų��.
		int a = 10, b = a;
		double c = a;	//������ ������ C (doubleŸ��), ���� ������ �˴ϴ�
						//���� Ÿ���� �ٸ��� ������ ���� �ʴ´�. �ڵ�����ȯ
		System.out.println(b);
		System.out.println(c);
		
		double d= 13.1;
//		int e = d;	����. �ڵ�����ȯ�� ���� �ʴ´�. ������ ū�ڷ������� ���� �ڷ����� 
//					��������ȯ�� �ؾ��Ѵ�.
		int e = (int)d;
		System.out.println(e);
	}

}
