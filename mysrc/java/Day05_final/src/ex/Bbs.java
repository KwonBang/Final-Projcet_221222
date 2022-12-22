package ex;

public class Bbs {
	String title = null;
	int no = 0;
	String body = null;
	int views = 0;
	int cnt = 0;
	String[] badword = {"개나리","십장생"};
	public int save(String a,int b,String c) {
		for(int i=0;i<badword.length;i++) {
			if(a.indexOf(badword[i])!=-1) {
				return 0;
			}
		}
		title=a;
		no=b;
		body=c;
		return 1;
	}
	public void views_count() {
		views++;
	}
	public String retrun_title (String a) {
		if(title!=null&&title.contains(a)) {
			return title;
		}else {
			return null;
		}
	}
	public int retrun_no () {
		return no;
	}
	public String retrun_body () {
		return body;
	}
	public int retrun_views () {
		return views;
	}
	public int cnt(String a) {
		for(int i = 0;i<body.length();i++) {
			if(body.indexOf(a,i)!=-1) {
				cnt++;
				i=body.indexOf(a,i);
			}
		}
		return cnt;
	}
}
