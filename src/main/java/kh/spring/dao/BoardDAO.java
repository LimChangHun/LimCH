package kh.spring.dao;

import kh.spring.dto.BoardDTO;

public interface BoardDAO {
	public int boardWriteComplete(BoardDTO dto)throws Exception;
}
