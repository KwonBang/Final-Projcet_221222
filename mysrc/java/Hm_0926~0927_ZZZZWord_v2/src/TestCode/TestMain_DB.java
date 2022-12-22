package TestCode;

public class TestMain_DB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordDAO wdao= new WordDAO();
		//단어정보를 만들고 이것을 입력...
		String eng="banana";
		String kor="바나나";
		String impor="중";
		String comment="명사";
		WordInfoDTO w = new WordInfoDTO();
		w.setEngName(eng);
		w.setKorName(kor);
		w.setImporFlag(impor);
		w.setComment(comment);
		
		wdao.insertWord(w);
		//wdao.insertWord(eng,kor,impor,comment);
		//System.out.println(wdao.connect());
	}

}
