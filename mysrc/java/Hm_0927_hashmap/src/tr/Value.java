package tr;


public class Value {
	private String body = null;
	private String grade = null;
	private String comment = null;
	private String word = null;
	public void set_body(String body) {
		this.body = body;
	}
	public void set_grade(String grade) {
		this.grade = grade;
	}
	public void set_comment(String comment) {
		this.comment = comment;
	}
	public void set_word(String word) {
		this.word = word;
	}
	public void prt() {
		System.out.println("뜻 : "+body);
		System.out.println("설명 : "+comment);
		System.out.println("중요도 : "+grade);
	}
	public String get_body() {
		return body;
	}
	public String get_grade() {
		return grade;
	}
	public String get_comment() {
		return comment;
	}
	public String get_word() {
		return word;
	}
}
