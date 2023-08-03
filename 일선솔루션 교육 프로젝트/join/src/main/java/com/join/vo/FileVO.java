package com.join.vo;

public class FileVO {
	private String file_seq;
	private String real_name;
	private String save_name;
	private String reg_date;
	private String save_path;
	private int list_seq;
	private int seq;
	public String getFile_seq() {
		return file_seq;
	}
	public void setFile_seq(String file_seq) {
		this.file_seq = file_seq;
	}
	public String getReal_name() {
		return real_name;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}
	public String getSave_name() {
		return save_name;
	}
	public void setSave_name(String save_name) {
		this.save_name = save_name;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public String getSave_path() {
		return save_path;
	}
	public void setSave_path(String save_path) {
		this.save_path = save_path;
	}
	public int getList_seq() {
		return list_seq;
	}
	public void setList_seq(int list_seq) {
		this.list_seq = list_seq;
	}
	@Override
	public String toString() {
		return "FileVO [file_seq=" + file_seq + ", real_name=" + real_name + ", save_name=" + save_name + ", reg_date="
				+ reg_date + ", save_path=" + save_path + ", list_seq=" + list_seq + ", seq=" + seq + "]";
	}
}
