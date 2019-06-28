package kh.spring.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kh.spring.dto.MemberDTO;

@Component
public class MemberServiceImpl {

	@Autowired
	private MemberDAOImpl dao;
	@Autowired
	private DataSource ds;
	
	public void memberJoin(MemberDTO dto) {
		dao.memberJoin(dto);
	}
	
	
}
