package kh.spring.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kh.spring.dto.BoardDTO;
import kh.spring.dto.MemberDTO;

@Repository
public class MemberDAOImpl {
	
	@Autowired
	private JdbcTemplate template;
	@Autowired
	private SqlSessionTemplate sst;
		
	public int memberJoin(MemberDTO dto) {
		String sql = "insert into members values(?,?,?)";
		return template.update(sql,dto.getId(),dto.getPw(),dto.getImg().getOriginalFilename());
//		return sst.insert("MemberDAO.memberJoinInsert",dto);
	}
	
	public int LoginOk(MemberDTO dto){
//		String sql = "select count(*) from members where id=? and pw=?";
//		return template.queryForObject(sql,Integer.class,dto.getId(),dto.getPw());
		return sst.selectOne("MemberDAO.memberLogin",dto);
	}
	
	public int LoginId(String id) {
//		String sql = "select count(*) from members where id=?";
//		return template.queryForObject(sql,Integer.class,id);
		return sst.selectOne("MemberDAO.memberLoginId",id);
	}
	
	public String image(String id) {
//		String sql = "select img from members where id=?";
//		return template.queryForObject(sql, String.class,id);
		return sst.selectOne("MemberDAO.memberImage",id);
	}
}
