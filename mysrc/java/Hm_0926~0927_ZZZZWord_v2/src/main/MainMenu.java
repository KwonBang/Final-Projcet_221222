package main;

import java.util.Scanner;

import wordGame.*;
import wordManager.WordManager;

public class MainMenu {
	// 1. 전역구성
	   // 목적을 수행하기 위해서 필요한 변수.. WordGame, WordManager
	private WordManager wmge=new WordManager();
	private GameInfo wgame= null;
	private Scanner in = new Scanner(System.in);
	
	MainMenu(){
		// 1. 단어관리, 2. 단어게임을 분기 하는 클래스
		for(;;) {
			System.out.println("1.  단어관리");
			System.out.println("2.  단어게임");
			
			System.out.println("3.  프로그램종료");
			System.out.println("4.  게임선택");
			System.out.println("선택 >>");
			int selMenu = in.nextInt();
			in.nextLine();
			if(selMenu==1) {
				wmge.wordManagerRun();
			}else if(selMenu==2) {
				if(wgame == null) {
					System.out.println("게임을 먼저 선택하세요");
				}else {
					wgame.WordGameRun();
				}
			}else  if(selMenu==4) {
				choiceGame();
			}else{
				break;
			}
		}
		
	}
	private void choiceGame() {
		// 게임을 선택하세요
		int a = 2;
		if(a==1) {
			wgame= new WordGame(wmge);
		}else if(a==2) {
			wgame= new WordGameV2(wmge);
		}
		
	}
	
}
