
public class Day01_02 {

	public static void main(String[] args) {
		/*����, �鿩����, ����, ����, ������, ������(��Ģ���� :
		= : ���Կ�����
		+ : ���ϱ�
		- : ����
		* : ���ϱ�
		/ :������ �K
		% : ������)
		*/
		String name="�޸�";
		int point=100;
		
		name = name + "����";
		point = 300;
		
		System.out.println(name);	//�޸ձ���
		System.out.println(point);	//300
		
		
		double avalue=18;	// �ǵ� : �����ϳ� �����
		double bvalue=4;
		double result=0;	//�ǵ��� �� �ΰ��� �������� ���� ���� ����
		double result1=0;
		double result2=0;
		double result3=0;
		
		result = avalue + bvalue;
		result1 = avalue * bvalue;
		result2 = avalue / bvalue;	//18/4	:4.5
		result3 = avalue % bvalue;
		
		System.out.println("����� : "+result);			//22
		System.out.println("����� : "+result1);			//72
		System.out.println("����� : "+result2);			//4
		System.out.println("����� : "+result3);			//2
		System.out.println("����� : "+(avalue - bvalue));	//14
				
	}

}
