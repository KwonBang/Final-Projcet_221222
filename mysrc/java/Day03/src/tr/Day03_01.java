package tr;
public class Day03_01 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//���� ��� > �׽�Ʈ��� 60�� �̻��̸� �հ� 60�� �̸��̸� ���հ��̶�� ���
		int point = 50;	//point �׽�Ʈ�� ���

		if(point>=60){
			System.out.println("�հ�");
		}else{
			System.out.println("���հ�");
		}
		//��øif	�鿩���� �߿�
		if(point>=60) {
			if(point<=80) {
				System.out.println("���߾��");
			}
		}
		/*���� ���ǿ� ���� ó���ؾ� �Ұ��� ���������?
		���� ���, ������ ���� A, B, C, D, E �� ����� �����ٸ�
		A : 90-100 B : 80-89 C : 70-79 ~~~*/
		int apoint = 80;
		/*����1�� ���� �Ǻ�, �����̸� ����2�� �Ǻ�, �����̸� ����3�� �Ǻ�, 
		�̶� ���̸� ����3�� ���϶� �����ϰ� ��*/
		if(/*����1*/apoint>=90) {
			//����1�� ���϶� ������ ���ǹ� ����
			System.out.println("A");
		}else if(/*����2*/apoint>=80) {
			//����2�� ���϶� ������ ���ǹ� ����
			System.out.println("B");
		}else if(/*����3*/apoint>=70) {
			//����3�� ���϶� ������ ���ǹ� ����
			System.out.println("C");
		}else if(/*����4*/apoint>=60) {
			//����4�� ���϶� ������ ���ǹ� ����
			System.out.println("D");
		}else if(/*����5*/apoint>=50) {
			//����3�� ���϶� ������ ���ǹ� ����
			System.out.println("E");
		}
	}

}
