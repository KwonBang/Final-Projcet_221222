package test;

public class Day04_ex01 {

	public static void main(String[] args) {
		//1.배열의 모든 값에 10을 입력하세요.
		int[] a = new int[10];
		for(int i=0;i<10;i++) {
			a[i]+=10;
		}
		//2.배열의 모든 값을 출력하시오.
		for(int i=0;i<10;i++) {
			System.out.println(a[i]);
		}
		/*3. 배열의 값에 0 1 2 3 4 5 6 7 8 9 를 입력하고 출력하시오.
		(단 for문 2개로 해결하시고, for문 2개는 다음과 같습니다)
		입력하는 for
		출력하는 for*/
		int[] a3 = new int[10];
		for(int i=0;i<10;i++) {
			a3[i]+=i;
		}
		for(int i=0;i<10;i++) {
			System.out.println(a3[i]);
		}

		//4. 배열의 값에 9 8 7 6 5 4 3 2 1 0 을 입력하고 출력하시오 . for문 2개
		int[] a4 = new int[10];
		for(int i=0;i<10;i++) {
			a4[i]=9-i;
		}
		for(int i=0;i<10;i++) {
			System.out.println(a4[i]);
		}
		//5. 값이 짝수인 경우 값을 출력하시오.
		int[] b = {23,45,23,56,75,56};
		for(int i=0;i<6;i++) {
			if(b[i]%2==0) {
				System.out.println(b[i]);
			}
		}
		/*6.값이 짝수인 경우 짝수 값을 갖는 인덱스를 출력하시오.*/
		int[] b6 = {23,45,23,56,75,56};
		for(int i=0;i<6;i++) {
			if(b6[i]%2==0) {
				System.out.println(i);
			}
		}
		/*7. 최고 값을 갖고 있는 인덱스 번호를 출력하시오.*/
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
		/*8. 모든 값을 1씩 증가시키시오.*/
		int[] b8 = {23,45,23,58,75,56};
		for(int i=0;i<6;i++) {
			b8[i]++;
		}
		/*9. 빈칸을 0이라고 가정한다. 빈칸의 값을 가진 인덱스 번호를 출력하세요.*/
		int[] b9 = {23,45,0,58,75,0};
		for(int i=0;i<6;i++) {
			if(b9[i]==0)
				System.out.println(i);
		}
		System.out.println("------------------------------");
		/*10. 다음조건에 따라 오름차순으로 저장되게 정렬하시오.
		1. 가장큰 값을 찾아서 맨뒤 값에 저장한다.
		2. 두번째로 큰 값을 찾아서 맨뒤에서 두번째 자리에 저장한다.
		정렬이 될때 까지 반복한다.*/
		int[] b10 = {93,45,23,58,75,56};
		int max5;
		for(int i=0;i<6;i++) {
			for(int i1=0;i<6;i++) {

			}
		}


		/*11. 
   		carnum배열의 인덱스가 0인 값부터 주차장에 들어온다. // carnum배열은 자동차 번호를 의미합니다. 
   		parking의 인덱스 번호가 주차번호이다. 
   		자동차 번호의 마지막 번호는 해당 차량이 주차할 주차번호이다.
   		만약 주차번호에 다른 차량이 주차되어 있으면 다음 주차번호에 주차를 한다.
   		(이때, 다음 주차번호에도 차량이 있으면 주차불가이다. 예제는 이와 같은 상황이 안 나오므로 고려하지 않아도됨)
		주차가 끝난 후 주차번호와 주차항 차량 번호를 출력하시오.*/
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
						parking[0]=carnum[i];	다음주차 칸이 없을때 맨앞으로 주차할경우
					}*/
			}
		}
		for(int i = 0;i<10;i++) {
			System.out.println(parking[i]);
		}

























	}

}
