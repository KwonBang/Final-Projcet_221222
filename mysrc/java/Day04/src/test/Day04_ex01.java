package test;

public class Day04_ex01 {

	public static void main(String[] args) {
		//1.�迭�� ��� ���� 10�� �Է��ϼ���.
		int[] a = new int[10];
		for(int i=0;i<10;i++) {
			a[i]+=10;
		}
		//2.�迭�� ��� ���� ����Ͻÿ�.
		for(int i=0;i<10;i++) {
			System.out.println(a[i]);
		}
		/*3. �迭�� ���� 0 1 2 3 4 5 6 7 8 9 �� �Է��ϰ� ����Ͻÿ�.
		(�� for�� 2���� �ذ��Ͻð�, for�� 2���� ������ �����ϴ�)
		�Է��ϴ� for
		����ϴ� for*/
		int[] a3 = new int[10];
		for(int i=0;i<10;i++) {
			a3[i]+=i;
		}
		for(int i=0;i<10;i++) {
			System.out.println(a3[i]);
		}

		//4. �迭�� ���� 9 8 7 6 5 4 3 2 1 0 �� �Է��ϰ� ����Ͻÿ� . for�� 2��
		int[] a4 = new int[10];
		for(int i=0;i<10;i++) {
			a4[i]=9-i;
		}
		for(int i=0;i<10;i++) {
			System.out.println(a4[i]);
		}
		//5. ���� ¦���� ��� ���� ����Ͻÿ�.
		int[] b = {23,45,23,56,75,56};
		for(int i=0;i<6;i++) {
			if(b[i]%2==0) {
				System.out.println(b[i]);
			}
		}
		/*6.���� ¦���� ��� ¦�� ���� ���� �ε����� ����Ͻÿ�.*/
		int[] b6 = {23,45,23,56,75,56};
		for(int i=0;i<6;i++) {
			if(b6[i]%2==0) {
				System.out.println(i);
			}
		}
		/*7. �ְ� ���� ���� �ִ� �ε��� ��ȣ�� ����Ͻÿ�.*/
		int max = 0;
		int[] b7 = {23,45,23,58,75,56};
		for(int i=0;i<6;i++) {
			if(b7[i]>max) {
				max=b7[i];
			}
		}
		for(int i=0;i<6;i++) {
			if(b7[i]==max) {
				System.out.println(i);
			}
		}
		/*8. ��� ���� 1�� ������Ű�ÿ�.*/
		int[] b8 = {23,45,23,58,75,56};
		for(int i=0;i<6;i++) {
			b8[i]++;
		}
		/*9. ��ĭ�� 0�̶�� �����Ѵ�. ��ĭ�� ���� ���� �ε��� ��ȣ�� ����ϼ���.*/
		int[] b9 = {23,45,0,58,75,0};
		for(int i=0;i<6;i++) {
			if(b9[i]==0)
				System.out.println(i);
		}
		System.out.println("------------------------------");
		/*10. �������ǿ� ���� ������������ ����ǰ� �����Ͻÿ�.
		1. ����ū ���� ã�Ƽ� �ǵ� ���� �����Ѵ�.
		2. �ι�°�� ū ���� ã�Ƽ� �ǵڿ��� �ι�° �ڸ��� �����Ѵ�.
		������ �ɶ� ���� �ݺ��Ѵ�.*/
		int[] b10 = {93,45,23,58,75,56};
		int max5;
		for(int i=0;i<6;i++) {
			for(int i1=0;i<6;i++) {

			}
		}


		/*11. 
   		carnum�迭�� �ε����� 0�� ������ �����忡 ���´�. // carnum�迭�� �ڵ��� ��ȣ�� �ǹ��մϴ�. 
   		parking�� �ε��� ��ȣ�� ������ȣ�̴�. 
   		�ڵ��� ��ȣ�� ������ ��ȣ�� �ش� ������ ������ ������ȣ�̴�.
   		���� ������ȣ�� �ٸ� ������ �����Ǿ� ������ ���� ������ȣ�� ������ �Ѵ�.
   		(�̶�, ���� ������ȣ���� ������ ������ �����Ұ��̴�. ������ �̿� ���� ��Ȳ�� �� �����Ƿ� ������� �ʾƵ���)
		������ ���� �� ������ȣ�� ������ ���� ��ȣ�� ����Ͻÿ�.*/
		int[] carnum = {1232,1221,1235,1252,1234,4536,3457,3238,3229,2599};
		int[] parking = new int[10];
		for(int i=0;i<10;i++) {
			if(carnum[i]%10==0) {
				if(parking[0]==0) {
					parking[0]=carnum[i];
				}else if(parking[0]!=0) {
					parking[1]=carnum[i];
				}
			}else if(carnum[i]%10==1) {
				if(parking[1]==0) {
					parking[1]=carnum[i];
				}else if(parking[0]!=0) {
					parking[2]=carnum[i];
				}
			}else if(carnum[i]%10==2) {
				if(parking[2]==0) {
					parking[2]=carnum[i];
				}else if(parking[2]!=0) {
					parking[3]=carnum[i];
				}
			}else if(carnum[i]%10==3) {
				if(parking[3]==0) {
					parking[3]=carnum[i];
				}else if(parking[0]!=0) {
					parking[4]=carnum[i];
				}
			}else if(carnum[i]%10==4) {
				if(parking[4]==0) {
					parking[4]=carnum[i];
				}else if(parking[4]!=0) {
					parking[5]=carnum[i];
				}
			}else if(carnum[i]%10==5) {
				if(parking[5]==0) {
					parking[5]=carnum[i];
				}else if(parking[5]!=0) {
					parking[6]=carnum[i];
				}
			}else if(carnum[i]%10==6) {
				if(parking[6]==0) {
					parking[6]=carnum[i];
				}else if(parking[6]!=0) {
					parking[7]=carnum[i];
				}
			}else if(carnum[i]%10==7) {
				if(parking[7]==0) {
					parking[7]=carnum[i];
				}else if(parking[7]!=0) {
					parking[8]=carnum[i];
				}
			}else if(carnum[i]%10==8) {
				if(parking[8]==0) {
					parking[8]=carnum[i];
				}else if(parking[8]!=0) {
					parking[9]=carnum[i];
				}
			}else if(carnum[i]%10==9) {
				if(parking[9]==0) {
					parking[9]=carnum[i];
				}/*else if(parking[9]!=0) {
						parking[0]=carnum[i];	�������� ĭ�� ������ �Ǿ����� �����Ұ��
					}*/
			}
		}
		for(int i = 0;i<10;i++) {
			System.out.println(parking[i]);
		}

























	}

}
