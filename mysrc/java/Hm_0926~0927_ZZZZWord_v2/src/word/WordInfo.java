package word;

public class WordInfo {
	// 다른 객체에 의존하고 있지 않습니다. 
	private String engName = null;
	public String getEngName() {
		return engName;
	}

	public void setEngName(String eng) {
		this.engName = eng;
	}

	private String korName=null;
	private String imporFlag=null;
	private String comment=null;
	// 최근 3번 나왔을때 정보를 저장
	private int[] checkFlag = new int[3];
	private int missCnt=0;
	
	public int getMissCnt() {
		return missCnt;
	}
	
	public int[] getCheckFlag() {
		return checkFlag;
	}

	public void setCheckFlag(int[] checkFlag) {
		this.checkFlag = checkFlag;
	}

	public void setCheckFlag(boolean flag) {
		//flag가 true이면 정답, 오답이면 false매개 변수가 넘어온다.. 
		checkFlag[0]=checkFlag[1];
		checkFlag[1]=checkFlag[2];
		if(flag) {
			checkFlag[2]=0;
		}else {
			checkFlag[2]=1;
		}
		missCnt = checkFlag[0] + checkFlag[1] + checkFlag[2]; 
	}
	
	public void setMissCnt(int missCnt) {
		this.missCnt = missCnt;
	}

	public String getKorName() {
		return korName;
	}
	public void setKorName(String korName) {
		this.korName = korName;
	}
	public String getImporFlag() {
		return imporFlag;
	}
	public void setImporFlag(String imporFlag) {
		this.imporFlag = imporFlag;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public void prt() {
		System.out.println("----------------------");
		System.out.println(" 영어 단어 : "+engName);
		System.out.println(" 한글설명 : "+korName);
		System.out.println(" 중요도   : "+imporFlag);
		System.out.println(" 코멘트   : "+comment);
		System.out.println(" 틀린 갯수   : "+missCnt);
	}
	public void tuple() {
		System.out.println("----------------------");
		System.out.println("영어단어"+"\t"+"한글설명"+"\t"+"중요도"+"\t"+"코멘트"+"\t"+"틀린 갯수");
		System.out.println(engName+"\t"+korName+"\t"+imporFlag+"\t"+comment+"\t"+missCnt);
	}
	

}
