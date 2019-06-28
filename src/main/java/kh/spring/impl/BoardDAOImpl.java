package kh.spring.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import kh.spring.dto.BoardDTO;

@Component
public class BoardDAOImpl {

	@Autowired
	private JdbcTemplate template;
	
	
static int recordCountPerPage = 10;
	
	
	public List<BoardDTO> boardContents(int currentPage){
		
		int endNum = currentPage*recordCountPerPage;
		int startNum = endNum - (recordCountPerPage-1);
		
		String sql = "select * from (select row_number() over(order by board_seq1 desc) as rown,board_seq1,"
				+ "title,contents,writer,writedate,viewcount,ipaddr,path from board1) where rown between ? and ? order by board_seq1 desc";
		
		return template.query(sql, new Object[]{startNum,endNum}, new RowMapper<BoardDTO>() {
			@Override
			public BoardDTO mapRow(ResultSet rs, int arg1) throws SQLException {

				BoardDTO dto = new BoardDTO();
				
				dto.setBoard_seq1(rs.getInt(2));
				dto.setTitle(rs.getString(3));
				dto.setContents(rs.getString(4));
				dto.setWriter(rs.getString(5));
				dto.setWritedate(rs.getTimestamp(6));
				dto.setViewcount(rs.getInt(7));
				dto.setIpaddr(rs.getString(8));
				dto.setPath(rs.getString(9));
				
				return dto;
			}
		});
		
	}
	
	public int boardContentsSize() {
		String sql = "select count(*) from board1";
		return template.queryForObject(sql, int.class);
	}

	
	/* 페이지 네비게이터(내가 후원한 글 목록) */
	public String getNaviforMySupport(int currentPage){ // 부트스트랩은 int로 받아야함
		int recordTotalCount = this.boardContentsSize();
		int recordCountPerPage = 10; // 5개의 글이 보이게 한다.
		int naviCountPerPage = 5; // 5개의 네비가 보이게 한다.

		int pageTotalCount = recordTotalCount / recordCountPerPage;
		if (recordTotalCount % recordCountPerPage > 0) {
			pageTotalCount++;
		}

		if (currentPage < 1) {
			currentPage = 1;
		} else if (currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}

		int startNavi = (currentPage - 1) / naviCountPerPage * naviCountPerPage + 1;
		int endNavi = startNavi + (naviCountPerPage - 1);

		// 네비 끝값이 최대 페이지 번호를 넘어가면 최대 페이지번호로 네비 끝값을 설정한다.
		if (endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}

		System.out.println("1시작 : 현재 위치 : " + currentPage);
		System.out.println("네비 시작 : " + startNavi);
		System.out.println("네비 끝 : " + endNavi);

		boolean needPrev = true;
		boolean needNext = true;

		if (startNavi == 1) {
			needPrev = false;
		}
		if (endNavi == pageTotalCount) {
			needNext = false;
		}

		StringBuilder sb = new StringBuilder();
		if (needPrev) {
			int prevStartNavi = startNavi - 1;
			sb.append("   <li class=\"page-item\"><a class=\"page-link\" href=\"board?currentPage="
					+ prevStartNavi + "\""
					+ "                     aria-label=\"Previous\"> <span aria-hidden=\"true\">&laquo;</span>"
					+ "                  </a></li>");

		}
		for (int i = startNavi; i <= endNavi; i++) {
			sb.append("<li class=\"page-item\"><a class=\"page-link pageNumber1\" href=\"board?currentPage=" + i + "\">"
					+ i + "</a></li>");
		}
		if (needNext) {
			int nextEndNavi = endNavi + 1;
			sb.append("<li class=\"page-item\"><a class=\"page-link\" href=\"board?currentPage="
					+ nextEndNavi++ + "\""
					+ "                     aria-label=\"Next\"> <span aria-hidden=\"true\">&raquo;</span>"
					+ "                  </a></li>");
		}

		return sb.toString();
	}//페이징
	
	
	public int boardWriteInsert(BoardDTO dto,String name) {
		String sql = "insert into board1 values(board_seq1.nextval,?,?,?,default,default,'1:1:1','qwe')";
		return template.update(sql,dto.getTitle(),dto.getContents(),name);
	}
	
	public List<BoardDTO> boardWriteSelectAll(){
		String sql = "select * from board1 order by board_seq1";
		return template.query(sql, new RowMapper<BoardDTO>() {
			public BoardDTO mapRow(ResultSet rs,int rn) throws SQLException {
				BoardDTO dto = new BoardDTO();
				dto.setBoard_seq1(rs.getInt(1));
				dto.setTitle(rs.getString(2));
				dto.setContents(rs.getString(3));
				dto.setWriter(rs.getString(4));
				dto.setWritedate(rs.getTimestamp(5));
				dto.setViewcount(rs.getInt(6));
				dto.setIpaddr(rs.getString(7));
				dto.setPath(rs.getString(8));
				return dto;
			}
		});
	}
	
	public BoardDTO boardView(int seq_board) {
		String sql = "select * from board1 where board_seq1=?";
		return template.queryForObject(sql,new RowMapper<BoardDTO>() {
			public BoardDTO mapRow(ResultSet rs, int rn) throws SQLException {
				BoardDTO dto = new BoardDTO();
				dto.setBoard_seq1(rs.getInt(1));
				dto.setTitle(rs.getString(2));
				dto.setContents(rs.getString(3));
				dto.setWriter(rs.getString(4));
				dto.setWritedate(rs.getTimestamp(5));
				dto.setViewcount(rs.getInt(6));
				dto.setIpaddr(rs.getString(7));
				dto.setPath(rs.getString(8));
				return dto;
			}
		},seq_board);
	}
	
	public  int boardViewCountUp(BoardDTO dto,int seq_board) {
		String sql = "update board1 set viewcount=? where board_seq1=?";
		return template.update(sql,dto.getViewcount(),seq_board);			
	}
	
	public int deleteWrite(int seq_board) {
		String sql = "delete from board1 where board_seq1=?";
		return template.update(sql,seq_board);
	}
	
	public int modifyWrite(BoardDTO dto,int seq_board) {
		String sql = "update board1 set title=?,contents=? where board_seq1=? ";
		return template.update(sql,dto.getTitle(),dto.getContents(),seq_board);
	}
	
	public int commentInsert(String contents,String writer) {
		String sql = "insert into comments values(comments_seq1.nextval,?,?,default)";
		return template.update(sql,contents,writer);
	}

}
