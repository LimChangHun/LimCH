package kh.spring.dao;

import kh.spring.dto.MemberDTO;

public interface MemberDAO {
	public int memberJoin(MemberDTO dto)throws Exception;
	public int LoginOk(MemberDTO dto)throws Exception;
	public int LoginId(String id)throws Exception;
	public String image(MemberDTO dto)throws Exception;
	
}
