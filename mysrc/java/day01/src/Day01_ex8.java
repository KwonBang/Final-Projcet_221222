
public class Day01_ex8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10000, pay = 4500, jandon = a - pay;
		/*�մ��� �� �ݾ�, ���� ����, �Ž�����
		�Ž������� õ��¥�� 0��, ���¥�� 0��, �ʿ�¥�� 0��, 1��¥�� 0���� �������� ����ϼ���*/
		int cjs = jandon/1000%10, qor = jandon/100%10, tlq = jandon/10%10, dlf = jandon/1%10;
		System.out.println("õ��¥�� "+cjs+"��"+"���¥�� "+qor+"��"+"�ʿ�¥�� "+tlq+"��"+"�Ͽ�¥�� "+dlf+"��");
		
		
	}

}
