package wordGame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import word.WordInfo;
import wordManager.WordManager;

public abstract class GameInfo {
	WordManager wmanager = null;
	HashMap<String, WordInfo> wgList = null;
	String[] wgKeySet = null;   // 제시 단어를 여기 저장...
	int[] wgKeySetCnt = null;
	Scanner in = new Scanner(System.in);
	int jumsu = 0;
	ArrayList<String> badWordList = new ArrayList<>();
	
	public GameInfo() {
		// TODO Auto-generated constructor stub
	}
	
	public abstract void WordGameRun();
	
	

}
