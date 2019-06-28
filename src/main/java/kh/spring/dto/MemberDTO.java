package kh.spring.dto;

import org.springframework.web.multipart.MultipartFile;

public class MemberDTO {
	private String id;
	private String pw;
	private MultipartFile img;
	
	public MemberDTO() {
		super();
	}
	public MemberDTO(String id, String pw, MultipartFile img) {
		super();
		this.id = id;
		this.pw = pw;
		this.img = img;
	}
	public String getId() {
		return id;
		
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public MultipartFile getImg() {
		return img;
	}
	public void setImg(MultipartFile img) {
		this.img = img;
	}
}
