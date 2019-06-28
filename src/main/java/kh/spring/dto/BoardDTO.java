package kh.spring.dto;

import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

public class BoardDTO {
	private int board_seq1;
	private String title;
	private String contents;
	private String writer;
	private Timestamp writedate;
	private int viewcount;
	private String ipaddr;
	private String path;
	
	public BoardDTO() {
		super();
	}
	
	

	public BoardDTO(int board_seq1, String title, String contents, String writer, Timestamp writedate, int viewcount,
			String ipaddr) {
		super();
		this.board_seq1 = board_seq1;
		this.title = title;
		this.contents = contents;
		this.writer = writer;
		this.writedate = writedate;
		this.viewcount = viewcount;
		this.ipaddr = ipaddr;
	}



	public BoardDTO(int board_seq1, String title, String contents, String writer, Timestamp writedate, int viewcount,
			String ipaddr, String path) {
		super();
		this.board_seq1 = board_seq1;
		this.title = title;
		this.contents = contents;
		this.writer = writer;
		this.writedate = writedate;
		this.viewcount = viewcount;
		this.ipaddr = ipaddr;
		this.path = path;
	}

	public int getBoard_seq1() {
		return board_seq1;
	}

	public void setBoard_seq1(int board_seq1) {
		this.board_seq1 = board_seq1;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public Timestamp getWritedate() {
		return writedate;
	}

	public void setWritedate(Timestamp writedate) {
		this.writedate = writedate;
	}

	public int getViewcount() {
		return viewcount;
	}

	public void setViewcount(int viewcount) {
		this.viewcount = viewcount;
	}

	public String getIpaddr() {
		return ipaddr;
	}

	public void setIpaddr(String ipaddr) {
		this.ipaddr = ipaddr;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	

	
	
	
}
