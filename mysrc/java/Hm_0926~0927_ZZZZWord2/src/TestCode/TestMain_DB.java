package TestCode;

public class TestMain_DB {

	public static void main(String[] args) {
		WordDAO wDao = new WordDAO();
		System.out.println(wDao.connect());
		String eng = "banana";
		String korName = "바나나";
		String comment = "중";
		String imporFlag = "명사";
		WordInfoDTO w = new WordInfoDTO();
		w.setEngName(eng);
		w.setKorName(korName);
		w.setImporFlag(imporFlag);
		w.setComment(comment);
		wDao.insertWord(w);
	}

}
