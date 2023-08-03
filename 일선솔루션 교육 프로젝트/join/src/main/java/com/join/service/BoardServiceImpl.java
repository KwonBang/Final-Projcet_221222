package com.join.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.join.dao.IF_BoardDAO;
import com.join.vo.BoardVO;
import com.join.vo.FileVO;
import com.join.vo.PageVO;
@Service
public class BoardServiceImpl implements IF_BoardService{
	@Inject
	private IF_BoardDAO boarddao;
	@Override
	public List<BoardVO> selectAll(PageVO pvo) throws Exception {
		return boarddao.selectAll(pvo);
	}
	@Override
	public int insert(BoardVO vo,List<FileVO> flist) throws Exception {
		return boarddao.insert(vo,flist);
	}
	@Override
	public int delete(String seq) throws Exception {
		return boarddao.delete(seq);
	}
	@Override
	public List<Map<String, Object>> selectOne(Map<String, Object> seq) throws Exception {
		return boarddao.selectOne(seq);
	}
	@Override
	public int update(Map<String, Object> board) throws Exception {
		return boarddao.update(board);
	}
	public int totalCount(PageVO pvo) throws Exception {
		return boarddao.totalCount(pvo);
	}
	@Override
	public List<Map<String, Object>> list(Map<String, Object> map) throws Exception {
		return boarddao.list(map);
	}
	@Override
	public int selectSeq(BoardVO bvo) throws Exception {
		return boarddao.selectSeq(bvo);
	}

}
