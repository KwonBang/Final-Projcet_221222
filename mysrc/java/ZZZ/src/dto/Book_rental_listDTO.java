package dto;

import java.time.LocalDate;

public class Book_rental_listDTO {
	int rental_no = 0;
	int book_no = 0;
	String title = null;
	String info = null;
	String writer = null;
	String id = null;
	LocalDate rental_date = LocalDate.now();
	public int getRental_no() {
		return rental_no;
	}
	public void setRental_no(int rental_no) {
		this.rental_no = rental_no;
	}
	public int getBook_no() {
		return book_no;
	}
	public void setBook_no(int book_no) {
		this.book_no = book_no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public LocalDate getRental_date() {
		return rental_date;
	}
	public void setRental_date(LocalDate rental_date) {
		this.rental_date = rental_date;
	}
	
}
