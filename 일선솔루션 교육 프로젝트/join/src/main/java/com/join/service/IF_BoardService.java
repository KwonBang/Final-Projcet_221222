package com.join.service;

import java.util.List;
import java.util.Map;

import com.join.vo.BoardVO;
import com.join.vo.FileVO;
import com.join.vo.PageVO;

public interface IF_BoardService {
	public List<BoardVO> selectAll(PageVO pvo)throws Exception;
	public int insert(BoardVO vo,List<FileVO> flist)throws Exception;
	public int delete(String seq)throws Exception;
	public List<Map<String, Object>> selectOne(Map<String, Object> seq)throws Exception;
	public int update(Map<String, Object> board)throws Exception;
	public int totalCount(PageVO pvo)throws Exception;
	public int selectSeq(BoardVO bvo)throws Exception;
	
	public List<Map<String, Object>> list(Map<String, Object> map) throws Exception;
}
