package TestCode;
//DTO는 튜플에 저장할 정보를 갖고 있거나 또는 데이터 베이스에서 가져온 튜플의 정보를 자바로 가져오는 객체이다.
//이름은 가독성을 위해 DTO로 하는게 좋고 이름이 DTO라고 DTO가 되는 것이 아니라
//전역변수의 getter setter가 있어야 DTO라고 부른다.
public class WordInfoDTO {
	//다른 객체에 의존하고 있지 않습니다.
	private String engName = null;
	private String korName=null;
	private String imporFlag=null;
	private String comment=null;
	//최근 3번 나왔을때 정보를 저장
	private int[] checkFlag = new int[3];
	private int missCnt=0;
	public int getMissCnt() {
		return missCnt;
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

	public int[] getCheckFlag() {
		return checkFlag;
	}

	public void setCheckFlag(int[] checkFlag) {
		this.checkFlag = checkFlag;
	}

	public String getEngName() {
		return engName;
	}

	public void setEngName(String engName) {
		this.engName = engName;
	}
}
