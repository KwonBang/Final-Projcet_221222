package tr;


public class Day03_03 {
	public static void main(String[] args) {
		String[] word = {"��","��","��","��"};
		
		for(int i=0;i<4;i++) {
			System.out.println(word[i]);
		}
		//����1. ��������� �����Ͻÿ�.
		for(int i=0;i<4;i++) {
			System.out.println(word[i++]);	//��,��
		}
		int[] point = {23,45,22,34,67};
		//����2. ��� ����Ʈ�� ����ϼ���.
		for(int i=0;i<5;i++) {
			System.out.println(point[i]);
		}
		//����3. ��������� 23/45/22/34/67/���� ����ϼ���
		for(int i=0;i<5;i++) {
			System.out.print(point[i]+"/");
		}
		
		System.out.println();
		
		//����4. �迭�� ���� ¦���� ����ϼ���
		for(int i=0;i<=4;i++) {
			if(i%2 == 0) {
				System.out.println(point[i]);
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
