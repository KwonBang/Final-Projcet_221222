package TestCode;

public class TestMain_DB {

	public static void main(String[] args) {
		WordDAO wDao = new WordDAO();
		System.out.println(wDao.connect());
		String eng = "banana";
		String korName = "�ٳ���";
		String comment = "��";
		String imporFlag = "���";
		WordInfoDTO w = new WordInfoDTO();
		w.setEngName(eng);
		w.setKorName(korName);
		w.setImporFlag(imporFlag);
		w.setComment(comment);
		wDao.insertWord(w);
	}

}
