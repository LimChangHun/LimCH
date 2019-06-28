package kh.spring.dto;

import java.sql.Timestamp;

public class CommentsDTO {
	private int comments_seq;
	private String contents;
	private String writer;
	private Timestamp time;
	
	public CommentsDTO() {
		super();
	}
	public CommentsDTO(int comments_seq, String contents, String writer, Timestamp time) {
		super();
		this.comments_seq = comments_seq;
		this.contents = contents;
		this.writer = writer;
		this.time = time;
	}
	public int getComments_seq() {
		return comments_seq;
	}
	public void setComments_seq(int comments_seq) {
		this.comments_seq = comments_seq;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
}
