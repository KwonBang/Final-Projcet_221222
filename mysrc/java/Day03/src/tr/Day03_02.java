package tr;

import java.util.Scanner;

public class Day03_02 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		// ctrl + shift + ���ĺ� o
		// ���� ��� �޴��� Ű����� �Է� �޴´�. 1���� �ݶ�, 2���� ���̴�, 3���� Ŀ��, 4���� �꽺
		// �߰������� �ݶ��� ������ 1. ��ũ 2. ���
		System.out.println("�޴��� �����ϼ���!!");
		int inputdata = in.nextInt(); // �Է°��� 3�̶�� ����
		System.out.println(inputdata);
		if (inputdata == 1) {
			// �ݶ� ����ϴ� �ڵ�
			System.out.println("�ݶ��� ������ �����Ͻÿ�");
			int seldata = 1;
			if (seldata == 1) {
				System.out.println("��ũ");
			} else if (seldata == 2) {
				System.out.println("���");
			}
		} else if (inputdata == 2) {
			System.out.println("���̴�");
		} else if (inputdata == 3) {
			System.out.println("Ŀ��");
		} else if (inputdata == 4) {
			System.out.println("�꽺");
		}

	}

}
