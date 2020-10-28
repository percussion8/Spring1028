package com.Spring1028.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import com.Spring1028.domain.BoardVO;

public interface BoardMapper {
	
	//@Select("select * from tbl_board where bno > 0")
	public List<BoardVO> getList();
	
	public void insert(BoardVO board); //인서트만 처리되고 생성된 PK값을 알 필요가 없는 경우
	
	public void insertSelectKey(BoardVO board); //인서트가 실행되고 생성된 PK값을 알아야 하는경우
	public BoardVO read(long bno); //정해진 숫자에 해당하는 레코드 읽어오기
	public int delete(Long bno);

}
